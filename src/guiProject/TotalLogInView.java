package guiProject;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class TotalLogInView extends GridPane {
	
	@FXML
	private HBox hBox;
	private String nextSide;
	
	public TotalLogInView(String side){
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
            "fxml/TotalLogInView.fxml"));

		  fxmlLoader.setController(this);
		  fxmlLoader.setRoot(this);

		  try {
			  fxmlLoader.load();
		  } catch (IOException exception) {
			  throw new RuntimeException(exception);
		  }
		  
		  nextSide=side;
		  hBox.getChildren().add(new CreateNewProfile(side)); //additionstecknet  
		  getSavedUsers();  //S�tter upp alla konton som logga in konton	  
	}
	
	public void createLogInBox(String user){
		hBox.getChildren().add(new LogInView(user, nextSide));
	}
	


	public void getSavedUsers(){	
	  if(!Utilities.getSavedFiles(null).isEmpty()){
		  for(int i=0; i<Utilities.getSavedFiles(null).size(); i++){
			  String name = Utilities.getSavedFiles(null).get(i);
			  createLogInBox(name);
		  }  
	  }
	}
}	

