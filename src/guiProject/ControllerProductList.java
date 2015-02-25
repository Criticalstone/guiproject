package guiProject;


import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.TilePane;
import se.chalmers.ait.dat215.project.Product;

public class ControllerProductList extends ScrollPane implements IFControllerProductList{

	@FXML
	private TilePane tilePaneResultArea;
	
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
	
	public void addItem(List<Product> p){
		for (int i = 0; i < p.size(); i++){
			tilePaneResultArea.getChildren().add(new ControllerProductCardPane(p.get(i)));
		}
	}
}
