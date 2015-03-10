package Archive;

import java.awt.Dimension;
import java.io.IOException;

import guiProject.Utilities;
import guiProject.interfaces.IFProductCard;
import se.chalmers.ait.dat215.project.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


/**
 * The class handling the detailed cards in the result view. These cards are displayed when user request further information of the item.
 * @author Jennifer
 *
 */


import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DetailedCard extends GridPane implements IFProductCard{

	
	Product product;
	@FXML
	private ImageView detImage;
	@FXML
	private Label detNameLabel;
	@FXML
	private Label detDescrLabel;
	@FXML
	private Label detIngLabel;
	@FXML
	private Button buttonSub;
	@FXML
	private Button buttonAdd;
	@FXML
	private Label detCostLabel;
	@FXML
	private Button buttonStarred;
	@FXML
	private Button buttonAddToList;
	@FXML
	private TextField textFieldQty;
	
	
	public DetailedCard(Product p) {
		
		//Load the FXML

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/DetailedProductView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        //Initialize
        this.product = p;
        setImageCard();
        setName();
        setDescription();
        setIngrediens();
        setPrice();
	}


	//Sets the image through the Utilities method getProductImage. Wrapper method used to extract image as the image is stored in swing/awt format.
	private void setImageCard(){
		 detImage.setImage(Utilities.getProductImage(product, new Dimension((int) detImage.getFitWidth(), (int) detImage.getFitHeight())));
	}
	
	
	private void setName(){
		detNameLabel.setText(product.getName());
	}
	
	private void setDescription() {
		detDescrLabel.setText("God");
	}
	
	private void setIngrediens() {
		detIngLabel.setText("Pasta");
	}
	
	private void setPrice(){
		detCostLabel.setText(new Double(product.getPrice()).toString());
	}
	
	

	@FXML
	private void handleButtonAction() {
		//TODO
		//This method may cause issues as it the text field is not checked for only numbers.
		int quantity=Integer.parseInt(textFieldQty.getText())-1;
		textFieldQty.appendText(Integer.toString(quantity));
	}


	@Override
	public int compareTo(IFProductCard o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateQtyInCart() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateShoppingLists() {
		// TODO Auto-generated method stub
		
	}

}
