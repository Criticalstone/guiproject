package guiProject;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class PaymentView extends VBox{

	public PaymentView(){
	  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/PaymentView.fxml"));

	  fxmlLoader.setController(this);
	  fxmlLoader.setRoot(this);

	  try {
		 fxmlLoader.load();
	  } catch (IOException exception) {
		 throw new RuntimeException(exception);
	  }
	}
  
}
