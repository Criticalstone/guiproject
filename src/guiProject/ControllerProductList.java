package guiProject;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import se.chalmers.ait.dat215.project.Product;

public class ControllerProductList extends AnchorPane{
	@FXML
	private AnchorPane paneResultList;

	public ControllerProductList(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "ViewProductResultList.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        
	}
	
	public void addItem(Product p){
		paneResultList.getChildren().add(new ControllerProductCardPane(p));
	}
}