package guiProject;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ThankYouForPurchase extends GridPane{
	@FXML
	private Label deliveryLabel;
	
	public ThankYouForPurchase(String deliveryTime){
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
	            "fxml/ThankYouForPurchase.fxml"));
	    fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);
	    
	    try {
	        fxmlLoader.load();
	    } catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }
	    deliveryLabel.setText(deliveryTime);
	    
	}
	
	public void homeEvent(MouseEvent e){
		ControllerMain.displayStartView();
	}
}
