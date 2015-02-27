package guiProject;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import se.chalmers.ait.dat215.project.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

public class CheckoutView extends GridPane{
	
	@FXML
	private GridPane gridOne;
	@FXML
	private GridPane gridTwo;
	@FXML
	private GridPane gridThree;
	@FXML
	private GridPane gridFour;
	
	
	 public CheckoutView() {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
	                "fxml/CheckoutView.fxml"));

	        fxmlLoader.setController(this);
	        fxmlLoader.setRoot(this);

	        try {
	            fxmlLoader.load();
	        } catch (IOException exception) {
	            throw new RuntimeException(exception);
	        }
            
	        	gridOne.add(arg0, arg1, arg2);
	 }
}
