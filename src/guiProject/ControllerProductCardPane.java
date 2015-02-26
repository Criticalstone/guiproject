package guiProject;

import java.awt.Dimension;
import java.io.IOException;

import se.chalmers.ait.dat215.project.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class ControllerProductCardPane extends GridPane implements IFProductCard{
	
	Product product;
	@FXML
	private ImageView imageProduct;
	@FXML
	private VBox boxDetailIcons;
	@FXML
	private Label labelProductName;
	@FXML
	private Button buttonStar;
	@FXML
	private Label labelPrice;
	@FXML
	private Label labelPriceUnit;
	@FXML
	private Button buttonSub;
	@FXML
	private Button buttonAdd;
	@FXML
	private TextField textFieldQty;


	
	//Create controller so that this object can be instanced.
	public ControllerProductCardPane(Product p)  {
		this.product = p;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/ViewProductCardPane.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        setName();
        setPrice();
        setImage();
        updateQtyInCart();


	}



	private void setName(){
		labelProductName.setText(product.getName());
		
	}
	
	private void setImage(){
		imageProduct.setImage(Utilities.getProductImage(product, new Dimension((int)imageProduct.getFitWidth(), (int)imageProduct.getFitHeight())));
	}
	private void setPrice(){
		labelPrice.setText(Utilities.zeroPaddedPrice(product.getPrice()));
		labelPriceUnit.setText(product.getUnit());

	}
	
	
	
	//Action events
	public void buttonAddAction(ActionEvent e){
		ControllerMain.addProductToCart(product, 1);
		updateQtyInCart();
	}
	
	public void buttonSubAction(ActionEvent e){
		ControllerMain.addProductToCart(product, -1);
		updateQtyInCart();
	}
	
	public void textFieldQtyAction(){
	    String c = textFieldQty.getText();
	    if("1234567890".contains(c)) {
	    	}
	    
	    else {
	    	textFieldQty.setText(Utilities.removeAllButNumbers(textFieldQty.getText()));
	    	textFieldQty.positionCaret(textFieldQty.getText().length());
	    }
	    if (textFieldQty.getText().equals("")){
	    	textFieldQty.setText("0");
	    }
		int qty = Integer.parseInt(textFieldQty.getText());
		ControllerMain.addProductToCart(product, qty - ControllerMain.getQuantityOfProduct(product));
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
			return ((ControllerProductCardPane)o).getProduct().equals(this.product);
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
}
