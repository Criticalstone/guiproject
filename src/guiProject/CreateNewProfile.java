package guiProject;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class CreateNewProfile extends AnchorPane {
	public CreateNewProfile(){
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
        "fxml/CreateNewProfile.fxml"));

		  fxmlLoader.setController(this);
		  fxmlLoader.setRoot(this);

		  try {
			  fxmlLoader.load();
		  } catch (IOException exception) {
			  throw new RuntimeException(exception);
		  }
	}
}
