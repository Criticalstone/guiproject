package guiProject;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class LogInView extends GridPane {

	public LogInView(){
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
        "fxml/LogInView.fxml"));

		  fxmlLoader.setController(this);
		  fxmlLoader.setRoot(this);

		  try {
			  fxmlLoader.load();
		  } catch (IOException exception) {
			  throw new RuntimeException(exception);
		  }
		  
		  
		  
		  
	}
}
