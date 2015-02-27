package guiProject;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class CheckoutView extends Pane {
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
	    }

}
