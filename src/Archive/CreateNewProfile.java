package Archive;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class CreateNewProfile extends HBox{
	
	@FXML
	private HBox hBox;
	private int one=1;
	
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
		if(one==1){
			hBox.getChildren().add(new NewProfileAccount());
			one=one+1;
		}
		
				
	}
	
	

}
