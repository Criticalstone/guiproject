package Archive;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class CalenderInfoBox extends GridPane{
	
	public CalenderInfoBox(){
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
            "fxml/CalenderBox.fxml"));

		 fxmlLoader.setController(this);
		 fxmlLoader.setRoot(this);

		 try {
			 fxmlLoader.load();
		 } catch (IOException exception) {
			 throw new RuntimeException(exception);
		 }
	}
}
