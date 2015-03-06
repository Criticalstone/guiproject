package guiProject;

import com.sun.javafx.collections.ObservableListWrapper;

import guiProject.ControllerMain.ColorScheme;
import guiProject.interfaces.IFObserver;
import guiProject.interfaces.IFSubject;
import javafx.event.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Callback;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
/**
 * 
 * @author Kevin
 *
 */
public class ShoppingCartHandler extends GridPane{
    public enum Type {
        PLUS,
        MINUS,
        REMOVE,
        TEXT,
        CLOSE;
    }

    private HashMap<Product, Integer> productList;

    @FXML
    private ListView<String> listView;
    @FXML
    private Label sum;
    @FXML
    private Button buttonCheckout;
    @FXML
    private Button buttonBuyNow;
    @FXML
    private Button buttonSaveToList;

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
        if(getShoppItemFromProd(p) == null)
            return 0;

        return (int)getShoppItemFromProd(p).getAmount();
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
    public void updateList(){
        listView.getItems().clear();
        List<String> templist = new ArrayList<>();
        for(ShoppingItem item: cart.getItems()){
            templist.add(Integer.toString(item.getProduct().getProductId()));
        }
        List<String> finalList = new ObservableListWrapper<String>(templist);
        listView.getItems().addAll(finalList);

        sum.setText(cart.getTotal() + " kr");
    }

    //ActionEvent for the clear button
    @FXML
    private void clearOnClick(ActionEvent event){
    	emptyCart();
    }

    public void checkoutButtonAction(ActionEvent e){
    	ControllerMain.displayCheckout();
    	ControllerMain.setBanner("kassa");
    	ControllerMain.collapseCategories();
    }

    public void buyNowButtonAction(ActionEvent e){
    	
    }

    public void saveToListButtonAction(ActionEvent e){
    	String name = "Ink�pslista " + LocalDateTime.now().toLocalDate();
    	ControllerMain.addShoppingList(name);
    	
    }

    //Private class which represent the List items in the gui.
    private class CartListCell extends ListCell<String> implements IFSubject{

        IFObserver observer;
        ShoppingItem shoppingItem;
        Product p;
        TextField numberOf;

        public CartListCell(){
            this.addObserver(new CartListObserver());
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {
                HBox main = new HBox();
                VBox details = new VBox();
                HBox quantity = new HBox();

                p = IMatDataHandler.getInstance().getProduct(Integer.parseInt(item));
                shoppingItem = getShoppItemFromProd(p);

                Label name = new Label(p.getName());
                Label price = new Label(Utilities.zeroPaddedPrice(p.getPrice()) + " kr");
                Button minus = new Button("-");
                minus.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        onAction(Type.MINUS);
                    }
                });

                numberOf = new IntegerTextField();
                numberOf.setText(Integer.toString((int)shoppingItem.getAmount()));
                numberOf.setPrefColumnCount(3);
                EventHandler eventHandler = new EventHandler() {
                    @Override
                    public void handle(Event event) {
                		if (numberOf.getText().equals("")){
                			numberOf.setText("1");
                			numberOf.selectPositionCaret(1);
                		}
                    	onAction(Type.TEXT);
                    }
                };
                numberOf.setOnKeyReleased(eventHandler);
                numberOf.setOnAction(eventHandler);

                Button plus = new Button("+");
                plus.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        onAction(Type.PLUS);
                    }
                });

                quantity.getChildren().addAll(minus, numberOf, plus);
                quantity.setSpacing(3);
                details.getChildren().addAll(name, price, quantity);
                details.setAlignment(Pos.CENTER);

                ImageView image = new ImageView(Utilities.getProductImage(p, new Dimension(60, 60)));
                HBox imageContainer = new HBox();
                imageContainer.getChildren().addAll(image);

                Button removeButton = new Button("X");
                removeButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        onAction(Type.REMOVE);
                    }
                });

                main.setAlignment(Pos.CENTER);
                main.setSpacing(8);
                main.getChildren().addAll(imageContainer, details, removeButton);
                setGraphic(main);

            }else{
                setText(null);
                setGraphic(null);
            }
        }

        public void onAction(Type type) {
            System.out.println(type.toString());
            int qDiff = 0;
            if(type == Type.PLUS){
                qDiff = 1;
            }else if(type == Type.MINUS){
                qDiff = -1;
            }else if(type == Type.TEXT){
                qDiff = Integer.parseInt(numberOf.getText()) - getQtyOfProduct(p);
            }else if(type == Type.REMOVE){
                cart.removeItem(shoppingItem);
            }
            notifyObserver(qDiff);
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
            observer.update(p, obj[0]);
        }

        @Override
        public Object getUpdate(IFObserver obj) {
            return shoppingItem.getAmount();
        }
    }

    private class CartListObserver implements IFObserver{
        IFSubject subject;

        @Override
        public void update(Object... obj) {
            addProduct((Product) obj[0], (int) obj[1]);
            ControllerMain.updateQtyAllCards();
        }

        @Override
        public void setSubject(IFSubject sub) {
            this.subject = sub;
        }
    }

	public void emptyCart() {
        listView.getItems().clear();
        cart.clear();
        updateList();
		
	}

}
