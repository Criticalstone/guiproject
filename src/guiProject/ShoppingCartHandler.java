package guiProject;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.event.ActionEvent;
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
/**
 * 
 * @author Kevin
 *
 */
public class ShoppingCartHandler extends GridPane{

    private HashMap<Product, Integer> productList;

    @FXML
    private ListView<String> listView;
    @FXML
    private Label sum;

    private ShoppingCart cart;

    /**
     * Constructor for the shopping cart handler. Sets up the FXML, initialize the IMatDataHandler shopping cart and the list for the shopping cart displayed in the GUI.
     */
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
        //Gui shopping cart list.
        listView.setCellFactory(new Callback<ListView<String>,
                ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> list) {
                return new CartListCell();
            }
        });

        listView.setPadding(new Insets(5, 0, 0, 0));
    }

    /**
     * This method returns the current qty of the specified item in the back end shopping cart.
     * @param p The product for which the qty is requested.
     * @return The quantity of the item in the shopping cart.
     */
    public int getQtyOfProduct(Product p){
//        if(productList.containsKey(p))
//            return productList.get(p);
//        else
            return 0;
    }

    /**
     * Returns the ShoppingItem (from back end) for the specified Product.
     * @param p The product for which the ShoppItem is requested.
     * @return the corresponding ShoppingItem from the shopping cart in back end.
     */
    public ShoppingItem getShoppItemFromProd(Product p){
        List<ShoppingItem> list = cart.getItems();
        for(ShoppingItem item: list){
            if(item.getProduct().equals(p)){
                return item;
            }
        }
        return null;
    }

    /**
     * Adds the item to the back end shopping cart, or modifies the qty in the back end shopping cart if the item already exist.
     * @param p The product for which the qty should be modified.
     * @param quantityDiff The change in qty. May be either positive or negative.
     */
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

    /**
     * Update the displayed GUI list to display the items currently in the back end shopping cart.
     */
    //TODO REMOVE UNUSED CODE!!
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

    //ActionEvent for the clear button
    @FXML
    private void clearOnClick(ActionEvent event){
        listView.getItems().clear();
        cart.clear();
        updateList();
    }

    //Private class which represent the List items in the gui.
    private class CartListCell extends ListCell<String> {
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
    }
}
