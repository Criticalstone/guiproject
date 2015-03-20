package guiProject;

import guiProject.CheckoutView.PaymentOption;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class PaymentView extends VBox{

	@FXML
	private ToggleGroup group;
	@FXML
	private RadioButton toggleCard;
	@FXML
	private RadioButton togglePayPal;
	@FXML
	private RadioButton toggleTransfer;
	@FXML
	private RadioButton toggleBill;
	@FXML
	private TextField cardNumberFour;
	
	public PaymentView(){
	  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/PaymentView.fxml"));

	  fxmlLoader.setController(this);
	  fxmlLoader.setRoot(this);

	  try {
		 fxmlLoader.load();
	  } catch (IOException exception) {
		 throw new RuntimeException(exception);
	  }
	}
	
	public void togglePaymentOption(ActionEvent e){
		
		if (group.getSelectedToggle().equals(toggleCard)){
			ControllerMain.displayPaymentOption(PaymentOption.CARD);
			
		} else if (group.getSelectedToggle().equals(togglePayPal)){
			ControllerMain.displayPaymentOption(PaymentOption.PAYPAL);
			
		} else if (group.getSelectedToggle().equals(toggleTransfer)){
			ControllerMain.displayPaymentOption(PaymentOption.TRANSFER);
			
		} else if (group.getSelectedToggle().equals(toggleBill)){
			ControllerMain.displayPaymentOption(PaymentOption.BILL);
			
		}
	}
}
