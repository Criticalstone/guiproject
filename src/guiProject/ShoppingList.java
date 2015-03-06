package guiProject;

import guiProject.interfaces.IFObserver;
import guiProject.interfaces.IFSubject;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;
import java.util.List;

public class ShoppingList extends GridPane {

    @FXML
    private ListView<HBox> listOrder;
    @FXML
    private ListView<GridPane> listProducts;
    @FXML
    private ListView<HBox> listShopping;

    private List<Product> productList;

    public ShoppingList() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/ShoppingListView.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    public void listOrderOnClick(MouseEvent event) {
//        updateProductListView();

    }

    public void updateOrdersListView() {
        listOrder.getItems().clear();
        List<Order> orders = ControllerMain.getOrderHistory();
        for (Order order : orders) {
            listOrder.getItems().add(new OrderListCell(order));
        }
    }

    public class ProductListCell extends GridPane {
        Label name = new Label();
        IFObserver observer;
        ShoppingItem item;

        ProductListCell(ShoppingItem item) {
            super();
            this.observer = new CustomListObserver();
            this.item = item;
            String tabs = "\t\t\t\t\t\t\t\t";
            for(int i = 0; i < item.getProduct().getName().length()/4; i++){
                tabs = tabs.substring(1);
            }
            name.setText(item.getProduct().getName() + tabs + Integer.toString((int) item.getAmount()) + " st");

            this.add(name, 0,0);
        }


    }

    public class OrderListCell extends HBox implements IFSubject {
        Label label = new Label();
        IFObserver observer;
        Order order;

        OrderListCell(Order order) {
            super();
            this.observer = new CustomListObserver();
            this.order = order;
            System.out.println(order.getItems().size());
            label.setText("Order: " + order.getOrderNumber() + " : " + order.getDate().toString());
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);

            this.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    onAction();
                }
            });

            this.getChildren().addAll(label);
        }

        public void onAction(){
            notifyObserver(this.order);
        }

        @Override
        public void addObserver(IFObserver obj) {
            observer = null;
        }

        @Override
        public void removeObserver(IFObserver obj) {
            observer = null;
        }

        @Override
        public void notifyObserver(Object... obj) {
            observer.update(obj[0]);
        }

        @Override
        public Object getUpdate(IFObserver obj) {
            return order;
        }
    }

    private class CustomListObserver implements IFObserver{
        IFSubject subject;

        @Override
        public void update(Object... obj) {
            Order o = (Order)obj[0];
            System.out.println(o.getItems().size());
            for(ShoppingItem item : o.getItems()){
                System.out.println(item.getProduct().getName());
                listProducts.getItems().add(new ProductListCell(item));
            }
        }

        @Override
        public void setSubject(IFSubject sub) {
            subject = sub;
        }
    }
}
