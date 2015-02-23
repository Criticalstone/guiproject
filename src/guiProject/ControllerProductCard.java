package guiProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class ControllerProductCard{
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
	
	private void setName(){
		labelProductName.setText("Tomater");
		
	}
	
	
	//Action events
	public void buttonAddAction(ActionEvent e){
		
	}
	
	public void buttonSubAction(ActionEvent e){
		
	}
	
	public void textFieldQtyAction(){
		

	}
}
