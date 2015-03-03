package guiProject;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LogInView extends GridPane {
	@FXML
	private VBox logInBox;
	
	
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
	
	@FXML
	public void ButtonLogIn(){
		logInBox.setVisible(true);	
	}
}
