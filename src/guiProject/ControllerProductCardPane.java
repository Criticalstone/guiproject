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


	}



	private void setName(){
		labelProductName.setText(product.getName());
		
	}
	
	private void setImage(){
		imageProduct.setImage(Utilities.getProductImage(product, new Dimension((int)imageProduct.getFitWidth(), (int)imageProduct.getFitHeight())));
	}
	private void setPrice(){
		labelPrice.setText(Utilities.zeroPappedPrice(product.getPrice()));
		labelPriceUnit.setText(product.getUnit());

	}
	
	
	
	//Action events
	public void buttonAddAction(ActionEvent e){
		
	}
	
	public void buttonSubAction(ActionEvent e){
		
	}
	
	public void textFieldQtyAction(){
		

	}



	@Override
	public Product getProduct() {
		return product;
	}
}
