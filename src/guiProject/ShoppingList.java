package guiProject;

import guiProject.interfaces.IFObserver;
import guiProject.interfaces.IFProductList;
import guiProject.interfaces.IFSubject;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ShoppingList extends GridPane {

    @FXML
    private ListView<HBox> listOrder;
    @FXML
    private ListView<HBox> listProducts;
    @FXML
    private ListView<HBox> listShopping;
    @FXML
    private Button buttonAddToCart;

    private ShoppingListObserver shoppingListObserver = new ShoppingListObserver();

    private List<ShoppingItem> productList;

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

        buttonAddToCart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addToCartOnClick(event);
            }
        });

        productList = new ArrayList<>();

    }

    public void addToCartOnClick(ActionEvent event){
        for(ShoppingItem item : productList) {
            ControllerMain.addProductToCart(item.getProduct(), (int)item.getAmount());
        }
    }

    public void updateOrdersListView() {
        listOrder.getItems().clear();
        List<Order> orders = ControllerMain.getOrderHistory();
        for (Order order : orders) {
            listOrder.getItems().add(new OrderListCell(order));
        }
    }

    public void updateShoppingListView() {
        listShopping.getItems().clear();
        HashMap<String, IFProductList<ShoppingItem>> lists = ControllerMain.getShoppingLists();
        Set<String> keys = lists.keySet();
        for(String key : keys){
            listShopping.getItems().add(new ShoppingListCell((SavedShoppingList)lists.get(key)));
        }
    }

    public void clearProductListView(){
        listProducts.getItems().clear();
    }

    public class ProductListCell extends HBox implements IFSubject{
        Label name = new Label();
        TextField numberOf = new TextField();
        Button plus = new Button("+");
        Button minus = new Button("-");
        HBox quantity = new HBox();
        IFObserver observer;
        ShoppingItem item;

        ProductListCell(ShoppingItem item) {
            super();
            this.observer = shoppingListObserver;
            this.item = item;
            this.getStyleClass().add("list-cell");
            this.setBackground(null);
            name.getStyleClass().add("list-text");
            plus.getStyleClass().add("addsub-buttons");
            minus.getStyleClass().add("addsub-buttons");
            String tabs = "\t\t\t";
            for(int i = 0; i < Math.round(item.getProduct().getName().length() / 4); i++){
                tabs = tabs.substring(1);
            }
            name.setText(item.getProduct().getName() + tabs);// + tabs + Integer.toString((int) item.getAmount()) + " st");

            minus.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    item.setAmount(item.getAmount()-1);
                    updateNumber();
                }
            });

            numberOf = new IntegerTextField();
            numberOf.setText(Integer.toString((int)item.getAmount()));
            numberOf.setPrefColumnCount(3);
            EventHandler eventHandler = new EventHandler() {
                @Override
                public void handle(Event event) {
                    if (numberOf.getText().equals("")){
                        numberOf.setText("1");
                        numberOf.selectPositionCaret(1);
                    }
                    updateNumber();
                }
            };
            numberOf.setOnKeyReleased(eventHandler);
            numberOf.setOnAction(eventHandler);

            plus.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    item.setAmount(item.getAmount()+1);
                    updateNumber();
                }
            });

            quantity.getChildren().addAll(minus, numberOf, plus);
            quantity.setAlignment(Pos.CENTER_RIGHT);
            setSpacing(30);
            
            this.getChildren().addAll(name, quantity);
        }

        public void updateNumber(){
            numberOf.setText(Integer.toString((int) item.getAmount()));
            System.out.println(Integer.parseInt(numberOf.getText()));
            if (Integer.parseInt(numberOf.getText())<0){
                System.out.println("inne! :");
                productList.remove(item);
            }
            notifyObserver(item);
        }

        @Override
        public void addObserver(IFObserver obj) {
            this.observer = obj;
        }

        @Override
        public void removeObserver(IFObserver obj) {
            this.observer = null;
        }

        @Override
        public void notifyObserver(Object... obj) {
            observer.update(obj[0]);
        }

        @Override
        public Object getUpdate(IFObserver obj) {
            return item;
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
            this.setBackground(null);
            this.getStyleClass().add("list-cell");
            label.getStyleClass().add("list-text");
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

    public class ShoppingListCell extends HBox implements IFSubject {
        Label label = new Label();
        Button remove = new Button("X");
        IFObserver observer;
        SavedShoppingList list;

        ShoppingListCell(SavedShoppingList list) {
            super();
            this.observer = shoppingListObserver;
            this.list = list;
            this.setBackground(null);
            this.getStyleClass().add("list-cell");
            label.getStyleClass().add("list-text");
            label.setText(list.getName() + " : " + list.getTimeStamp());
            label.setMaxWidth(Double.MAX_VALUE);
            remove.setAlignment(Pos.CENTER_RIGHT);
            remove.getStyleClass().add("addsub-buttons");
            HBox.setHgrow(label, Priority.ALWAYS);

            this.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    onAction(event);
                }
            });

            remove.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    onAction(event);
                }
            });

            this.getChildren().addAll(label, remove);
        }

        public void onAction(Event event){
            if(event.getClass() == MouseEvent.class) {
                notifyObserver(this.list);
            }else{
                ControllerMain.removeShoppingList(list.getName());
                updateShoppingListView();
                clearProductListView();
            }
        }

        @Override
        public void addObserver(IFObserver obj) {
            observer = obj;
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
            return list;
        }
    }

    private class ShoppingListObserver implements IFObserver{
        IFSubject subject;

        @Override
        public void update(Object... obj) {

            if(obj[0].getClass() == ShoppingItem.class) {
                ShoppingItem newItem = (ShoppingItem)obj[0];
                for(ShoppingItem item : productList){
                    if(item.getProduct().getName().equals(newItem.getProduct().getName())){
                        item.setAmount(newItem.getAmount());
                        if(item.getAmount() <= 0){
                            //TODO: REMOVE IF LOWER OR EQUAL TO ZERO
                        }
                    }
                }
            }else {
                listProducts.getItems().clear();
                productList.clear();
                SavedShoppingList list = (SavedShoppingList) obj[0];
                for (ShoppingItem item : list.getProducts()) {
                    listProducts.getItems().add(new ProductListCell(item));
                    productList.add(item);
                }
            }
        }

        @Override
        public void setSubject(IFSubject sub) {
            subject = sub;
        }
    }

    private class CustomListObserver implements IFObserver{
        IFSubject subject;

        @Override
        public void update(Object... obj) {
            listProducts.getItems().clear();
            productList.clear();
            Order o = (Order)obj[0];
            for(ShoppingItem item : o.getItems()){
                listProducts.getItems().add(new ProductListCell(item));
                productList.add(item);
            }
        }

        @Override
        public void setSubject(IFSubject sub) {
            subject = sub;
        }
    }
}
