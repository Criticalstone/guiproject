package guiProject;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ThankYouForPurchase extends GridPane{
	
	public ThankYouForPurchase(){
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
	            "fxml/ThankYouForPurchase.fxml"));
	    fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);
	    
	    try {
	        fxmlLoader.load();
	    } catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }
	    
	}
	
	public void homeEvent(MouseEvent e){
		ControllerMain.displayStartView();
	}
}
