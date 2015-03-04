package Archive;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class NewProfileAccount extends GridPane{

	public int count=0;
	
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
	
	@FXML
	public void CreateNewAccount(){
		if(count<4){
			TestMain.createLogInBox();	
		}
		count=count+1;
		
	}
}
