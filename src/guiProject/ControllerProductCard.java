package guiProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class ControllerProductCard {
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

	public void setName(){
		labelProductName.setText("Tomater");
		
	}
	
	public void buttonAddAction(ActionEvent e){
		labelProductName.setText("Tomater");
	}
	
	public void buttonSubAction(ActionEvent e){
		labelProductName.setText("Bananer");
	}
	
	public void textFieldQtyAction(){
		labelProductName.setText(textFieldQty.getText());

	}
}
