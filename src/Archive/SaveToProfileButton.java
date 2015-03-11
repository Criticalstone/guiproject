package Archive;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class SaveToProfileButton extends Button{
	
	public SaveToProfileButton(){
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
        "fxml/SaveToProfileButton.fxml"));

		  fxmlLoader.setController(this);
		  fxmlLoader.setRoot(this);

		  try {
			  fxmlLoader.load();
		  } catch (IOException exception) {
			  throw new RuntimeException(exception);
		  }
	}
}
