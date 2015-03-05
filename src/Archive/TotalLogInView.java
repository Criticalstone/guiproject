package Archive;


import guiProject.CreateNewProfile;
import guiProject.NewProfileAccount;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class TotalLogInView extends GridPane {
	
	@FXML
	private HBox hBox;
	private int createCount=0;
	
	public TotalLogInView(){
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
            "fxml/TotalLogInView.fxml"));

		  fxmlLoader.setController(this);
		  fxmlLoader.setRoot(this);

		  try {
			  fxmlLoader.load();
		  } catch (IOException exception) {
			  throw new RuntimeException(exception);
		  }
		  
		 if(createCount==0){
			hBox.getChildren().add(new NewProfileAccount()); 
		 }else{
			 hBox.getChildren().add(new CreateNewProfile()); 
		 }	  
	}
  

}
