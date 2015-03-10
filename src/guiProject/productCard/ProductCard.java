package guiProject.productCard;

import guiProject.ControllerMain;
import guiProject.IntegerTextField;
import guiProject.Utilities;
import guiProject.interfaces.IFProductCard;

import java.awt.Dimension;
import java.io.IOException;

import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * The default "card" used to display products in the result area.
 * @author Anton
 *
 */
public class ProductCard extends GridPane implements IFProductCard{
	
	Product product;
	@FXML
	private ImageView imageProduct;
	@FXML
	private VBox boxDetailIcons;
	@FXML
	private Label labelProductName;
	@FXML
	private MenuButton menuButtonAddToList;
	@FXML
	private ToggleButton buttonStar;
	@FXML
	private Label labelPrice;
	@FXML
	private Label labelPriceUnit;
	@FXML
	private Button buttonSub;
	@FXML
	private Button buttonAdd;
	@FXML
	private IntegerTextField textFieldQty;

	private CustomMenuItem newShoppingList;

	private ImageView checkIcon;
	
	/**
	 * Constructor for the product card. Will create and initialize a product card based on the provided product.
	 * @param p The product to be displayed on the card.
	 */
	public ProductCard(Product p)  {
		//Load FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "../fxml/ViewProductCardPane.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        //Initialize
        checkIcon = new ImageView(new Image(ProductCard.class.getResourceAsStream("/res/Check_mark.png")));
        this.product = p;
        setName();
        setPrice();
        setImage();
        updateQtyInCart();
        setStar();
        updateShoppingLists();

	}



	private void setStar() {
		buttonStar.setSelected(ControllerMain.getIsStared(product));
	}



	public void updateShoppingLists() {
		menuButtonAddToList.getItems().removeAll(menuButtonAddToList.getItems());
		addNewShoppingListMenuItem();
		menuButtonAddToList.getItems().add(new SeparatorMenuItem());
		
		for (String s: ControllerMain.getShoppingLists().keySet()){
			MenuItem menuItem = new MenuItem(s);
			for (ShoppingItem shop: ControllerMain.getShoppingLists().get(s).getProducts()){
				if (shop.getProduct().equals(product)){
					menuItem.setGraphic(checkIcon);
				}
			}

			menuItem.setOnAction(new EventHandler<ActionEvent>() {
			    @Override 
			    public void handle(ActionEvent e) {
			        ControllerMain.addProductToList(menuItem.getText(), new ShoppingItem(product, 1));
			    }
			});
			menuButtonAddToList.getItems().add(menuItem);
		}
		
	}



	private void addNewShoppingListMenuItem() {
		newShoppingList = new CustomMenuItem(new Label("Ny inköpslista..."));
		newShoppingList.setHideOnClick(false);
		newShoppingList.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
				TextField listName = new TextField();
				listName.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {
						ControllerMain.addShoppingList(listName.getText());
						ControllerMain.addProductToList(listName.getText(), new ShoppingItem(product,1));
						ControllerMain.updateCards();
					}
					
				});
				
				CustomMenuItem cmi = new CustomMenuItem(listName);
				cmi.setHideOnClick(false);
				menuButtonAddToList.getItems().remove(0);
				menuButtonAddToList.getItems().add(0, cmi);
				listName.setPromptText("ex Lunchlista");
				listName.selectPositionCaret(0);

		    }
		});
		menuButtonAddToList.getItems().add(newShoppingList);
	}



	private void setName(){
		labelProductName.setText(product.getName());
		
	}
	//Sets the image through the Utilities method getProductImage. Wrapper method used to extract image as the image is stored in swing/awt format.
	private void setImage(){
		imageProduct.setImage(Utilities.getProductImage(product, new Dimension((int) imageProduct.getFitWidth(), (int) imageProduct.getFitHeight())));
	}
	
	private void setPrice(){
		labelPrice.setText(Utilities.zeroPaddedPrice(product.getPrice()));
		labelPriceUnit.setText(product.getUnit());

	}
	
	@Override
	public Product getProduct() {
		return product;
	}



	@Override
	public void updateQtyInCart() {
		textFieldQty.setText(Integer.toString(ControllerMain.getQuantityOfProduct(product)));
	}

	/**
	 * Checks if both are the same class, then check if the cards contain the same product.
	 * @param o
	 * @return
	 */
	public boolean equals(Object o){
		if (o == this){
			return true;
		}else if (o.getClass() == this.getClass()){
			return ((ProductCard)o).getProduct().equals(this.product);
		}
		return false;
	}

	@Override
	/**
	 * Compares the name of the product alfabetically.
	 * @param o The object to compare
	 * @return 0 if it is not a ProductCardPane, +/- depending on the product names.
	 */
	public int compareTo(IFProductCard o) {
		return product.getName().compareTo(o.getProduct().getName());

	}
	
	
	//Action events
	/**
	 * The action event used by the add button to increase the quantity in the cart by 1.
	 * @param e ActionEvent provided by the button. Not used.
	 */
	public void buttonAddAction(ActionEvent e){
		ControllerMain.addProductToCart(product, 1);
		updateQtyInCart();
	}
	/**
	 * The action event used by the subtract button to decrease the quantity in the cart by 1.
	 * @param e ActionEvent provided by the button. Not used.
	 */
	public void buttonSubAction(ActionEvent e){
		ControllerMain.addProductToCart(product, -1);
		updateQtyInCart();
	}
	/**
	 * The action event used by the quantity text field to set the quantity in the cart to the contained value. 
	 * Method is run everytime a button is pressed in the text field.
	 * Will remove any data but the values "1234567890" before parsing to int.
	 */
	public void textFieldQtyAction(){
		if (textFieldQty.getText().equals("")){
			textFieldQty.setText("0");
			textFieldQty.selectPositionCaret(1);
		}
		int qty = Integer.parseInt(textFieldQty.getText());
		ControllerMain.addProductToCart(product, qty - ControllerMain.getQuantityOfProduct(product));
	}
	/**
	 * The action event used by the star toggle button to set if the item should be set as stared or not
	 * @param e ActionEvent sent by the button. Not currently used.
	 */
	public void starButtonAction(ActionEvent e){
		ControllerMain.starProduct(product, ((ToggleButton)e.getSource()).isSelected());
	}
	
	public void shoppingListActionButton(ActionEvent e){

	}
}
