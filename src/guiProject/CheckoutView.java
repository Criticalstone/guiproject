package guiProject;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class CheckoutView extends ScrollPane{
	
	@FXML
	private VBox boxDetails;
	
	
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
	       boxDetails.getChildren().add(new CardInformationView());

	       boxDetails.getChildren().add(new PersonNumberView());
//	       boxDetails.getChildren().add(new DeliveryView());
	 }
}
