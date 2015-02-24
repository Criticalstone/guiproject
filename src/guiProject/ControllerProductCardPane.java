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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class ControllerProductCardPane extends GridPane{
	
	Product product;
	@FXML
	private ImageView imageProduct;
	@FXML
	private VBox boxDetailIcons;
	@FXML
	private Label labelProductName;
	@FXML
	private Label labelPrice;
	@FXML
	private Label labelPriceSpecifier;
	@FXML
	private Label labelAvPrice;
	@FXML
	private Label labelAvPriceSpecifier;
	@FXML
	private Button buttonSub;
	@FXML
	private Button buttonAdd;
	@FXML
	private TextField textFieldQty;

	
	//Create controller so that this object can be instanced.
	public ControllerProductCardPane(Product p)  {
		this.product = p;
		System.out.println("1");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "ViewProductCardPane.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
		System.out.println("2");
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
		System.out.println("3");
        setName();
        setImage();
        setPrice();
        setAvPrice();
	}
	
	private void setName(){
		labelProductName.setText(product.getName());
		
	}
	
	private void setImage(){
		imageProduct.setImage(Utilities.getProductImage(product, new Dimension((int)imageProduct.getFitWidth(), (int)imageProduct.getFitHeight())));
	}
	private void setPrice(){
		
	}
	private void setAvPrice(){
		
	}
	
	
	//Action events
	public void buttonAddAction(ActionEvent e){
		
	}
	
	public void buttonSubAction(ActionEvent e){
		
	}
	
	public void textFieldQtyAction(){
		

	}
}
