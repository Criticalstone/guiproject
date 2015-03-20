package guiProject;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class CheckoutView extends ScrollPane{
	
	@FXML
	private VBox boxDetails;
	private DeliveryScheduleComponent deliverySchedule;
	
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
		deliverySchedule = new DeliveryScheduleComponent();
		boxDetails.getChildren().add(deliverySchedule);
		boxDetails.getChildren().add(new PaymentView());
	 }
	
	public void displayPaymentOption(PaymentOption option){
		if (boxDetails.getChildren().size() > 3){
			boxDetails.getChildren().remove(3);
		}
		if (option == PaymentOption.CARD){
			boxDetails.getChildren().add(3,new CardInformationView());
		} else if (option == PaymentOption.PAYPAL){
			
		} else if (option == PaymentOption.TRANSFER){
			
		} else if (option == PaymentOption.BILL){
			
		}
	}
	
	public void buyNowButtonAction(){
			ControllerMain.displayPurchaseConfirmation(deliverySchedule.getDeliveryTime());
			ControllerMain.placeOrder();
			ControllerMain.emptyCart();		
	}
}
