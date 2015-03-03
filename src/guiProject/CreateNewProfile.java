package guiProject;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;



public class CreateNewProfile extends HBox{
	
	@FXML
	private HBox hBox;
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
	
	@FXML
	public void ButtonAddProfile(){
		hBox.getChildren().add(new NewProfileAccount());
		
	}
	
	

}
