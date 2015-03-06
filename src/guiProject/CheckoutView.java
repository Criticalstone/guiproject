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
		boxDetails.getChildren().add(new PersonNumberView());
		boxDetails.getChildren().add(new PaymentView());
		boxDetails.getChildren().add(new DeliveryScheduleComponent());
	 }
	
	public void displayPaymentOption(PaymentOption option){
		if (boxDetails.getChildren().size() > 2 && !(boxDetails.getChildren().get(2) instanceof PersonNumberView)){
			boxDetails.getChildren().remove(2);
		}
		if (option == PaymentOption.CARD){
			boxDetails.getChildren().add(2,new CardInformationView());
		} else if (option == PaymentOption.PAYPAL){
			
		} else if (option == PaymentOption.TRANSFER){
			
		} else if (option == PaymentOption.BILL){
			
		}
	}
	
	public void buyNowButtonAction(){
		ControllerMain.displayPurchaseConfirmation();
        ControllerMain.placeOrder();
	}
}
