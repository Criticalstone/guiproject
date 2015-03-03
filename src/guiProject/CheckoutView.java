package guiProject;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class CheckoutView extends ScrollPane{
	
	@FXML
	private VBox boxDetails;
	
	public enum PaymentOption{
		CARD,
		PAYPAL,
		TRANSFER,
		BILL;
	}
	
	public CheckoutView() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
		        "fxml/CheckoutView.fxml"));
		
		fxmlLoader.setController(this);
		fxmlLoader.setRoot(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
		boxDetails.getChildren().add(new PaymentView());

		boxDetails.getChildren().add(new PersonNumberView());
//		boxDetails.getChildren().add(new DeliveryView());
	 }
	
	public void displayPaymentOption(PaymentOption option){
		if (!(boxDetails.getChildren().get(1) instanceof PersonNumberView)){
			boxDetails.getChildren().remove(1);
		}
		if (option == PaymentOption.CARD){
			boxDetails.getChildren().add(1,new CardInformationView());
		} else if (option == PaymentOption.PAYPAL){
			
		} else if (option == PaymentOption.TRANSFER){
			
		} else if (option == PaymentOption.BILL){
			
		}
	}
	
	public void buyNowButtonAction(){
		ControllerMain.displayPurchaseConfirmation();
		ControllerMain.emptyCart();
	}
}
