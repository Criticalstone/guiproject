package guiProject;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class PersonalInfo extends GridPane{

	public PersonalInfo(){
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
	            "fxml/PersonalInfo.fxml"));
	    fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);
	    
	    try {
	        fxmlLoader.load();
	    } catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }
	}
	
	public void saveOnAction(){
		
	}
	
}
