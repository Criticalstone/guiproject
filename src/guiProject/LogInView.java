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
        "fxml/LogInBox.fxml"));

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
		if(logInBox.isVisible()){
			logInBox.setVisible(false);
		}else{
			logInBox.setVisible(true);
		}
			
	}
}
