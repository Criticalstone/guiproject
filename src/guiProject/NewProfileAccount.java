package guiProject;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class NewProfileAccount extends GridPane{

	public NewProfileAccount(){
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
          "fxml/NewProfileAccount.fxml"));

		  fxmlLoader.setController(this);
		  fxmlLoader.setRoot(this);

		  try {
			  fxmlLoader.load();
		  } catch (IOException exception) {
			  throw new RuntimeException(exception);
		  }
		  
		  
	}
}
