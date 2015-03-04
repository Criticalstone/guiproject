package Archive;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

public class TotalLogInView extends HBox {
	
	@FXML
	private HBox hBox;
	
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
		  
		  hBox.getChildren().add(new LogInView());
		  hBox.getChildren().add(new CreateNewProfile());
		  
	}
  

}
