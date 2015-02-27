package guiProject;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class ControllerDeliveryView {
	
	public ControllerDeliveryView(){
		
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
            "fxml/DeliveryViewn.fxml"));

		  fxmlLoader.setController(this);
		  fxmlLoader.setRoot(this);

		  try {
			  fxmlLoader.load();
		  } catch (IOException exception) {
			  throw new RuntimeException(exception);
		  }
		
	}
	
  
	

}
