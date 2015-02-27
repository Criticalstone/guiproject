package guiProject;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Callback;
import se.chalmers.ait.dat215.project.IMatDataHandler;

import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ShoppingCartHandler extends GridPane{

    private HashMap<Product, Integer> productList;

    @FXML
    private ListView<String> listView;
    @FXML
    private Label sum;

    private ShoppingCart cart;

    public ShoppingCartHandler() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/ShoppingCart.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        cart = IMatDataHandler.getInstance().getShoppingCart();

        listView.setCellFactory(new Callback<ListView<String>,
                ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> list) {
                return new CartListCell();
            }
        });

        listView.setPadding(new Insets(5, 0, 0, 0));
    }

    public int getQtyOfProduct(Product p){
//        if(productList.containsKey(p))
//            return productList.get(p);
//        else
            return 0;
    }

    public ShoppingItem getShoppItemFromProd(Product p){
        List<ShoppingItem> list = cart.getItems();
        for(ShoppingItem item: list){
            if(item.getProduct().equals(p)){
                return item;
            }
        }
        return null;
    }

    public void addProduct(Product p, int quantityDiff){

        if(cart.getItems().contains(getShoppItemFromProd(p))){
            ShoppingItem item = getShoppItemFromProd(p);
            item.setAmount(item.getAmount()+quantityDiff);
            if(item.getAmount()<=0){
                cart.removeItem(item);
            }
        }else if(quantityDiff > 0){
            cart.addProduct(p, quantityDiff);
        }

        updateList();
    }

    public void updateList(){
        listView.getItems().clear();
        System.out.println(listView.getItems().size());
        int i = 0;
        List<String> templist = new ArrayList<>();
        for(ShoppingItem item: cart.getItems()){
            templist.add(Integer.toString(item.getProduct().getProductId()));
        }
        List<String> finalList = new ObservableListWrapper<String>(templist);
        listView.getItems().addAll(finalList);

        sum.setText(cart.getTotal() + " kr");

        System.out.println(listView.getItems().size());
    }

    @FXML
    private void clearOnClick(ActionEvent event){
        listView.getItems().clear();
        cart.clear();
        updateList();
    }

    private class CartListCell extends ListCell<String> implements IListCell{
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {
                HBox main = new HBox();
                VBox details = new VBox();
                HBox quantity = new HBox();

                Product p = IMatDataHandler.getInstance().getProduct(Integer.parseInt(item));
                ShoppingItem shoppingItem = getShoppItemFromProd(p);

                Label name = new Label(p.getName());
                Label price = new Label(Utilities.zeroPaddedPrice(p.getPrice()));
                Button minus = new Button("-");
                Label numberOf = new Label(shoppingItem.getAmount() + " " + p.getUnit());
                Button plus = new Button("+");
                quantity.getChildren().addAll(minus, numberOf, plus);
                quantity.setSpacing(3);
                details.getChildren().addAll(name, price, quantity);
                details.setAlignment(Pos.CENTER);

                ImageView image = new ImageView(Utilities.getProductImage(p, new Dimension(60, 60)));
                HBox imageContainer = new HBox();
                imageContainer.getChildren().addAll(image);

                Button removeButton = new Button("X");

                main.setAlignment(Pos.CENTER);
                main.setSpacing(8);
                main.getChildren().addAll(imageContainer, details, removeButton);
                setGraphic(main);

            }else{
                setText(null);
                setGraphic(null);
            }
        }

        @Override
        public void onAction(ActionEvent event) {

        }
    }

    private interface IListCell{
        public void onAction(ActionEvent event);
    }


}
