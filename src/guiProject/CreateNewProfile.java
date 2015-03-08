package guiProject;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;


public class CreateNewProfile extends HBox{
	
	@FXML
	private HBox hBox;
	@FXML 
	private ToggleButton addButton;
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
		  
		  if(Utilities.getSavedFiles(null).size()<=5){
			 addButton.setDisable(false); 
		  }else{
			  addButton.setDisable(true);
		  }
		  
	}
	
	@FXML
	public void ButtonAddProfile(){
		if(Utilities.getSavedFiles(null).size()<=5){
			if(one==1){
			hBox.getChildren().add(new NewProfileAccount());
			one=one+1;
			}
		}else{
			addButton.setDisable(true);
		}
	}
}
