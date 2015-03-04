package guiProject;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class PersonalInfoEdit extends GridPane{

	public PersonalInfoEdit(){
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
	
}
