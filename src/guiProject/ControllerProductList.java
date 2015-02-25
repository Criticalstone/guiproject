package guiProject;


import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.TilePane;
import se.chalmers.ait.dat215.project.Product;
import javafx.scene.control.ScrollPane;

public class ControllerProductList extends ScrollPane implements IFControllerProductList{

	@FXML
	private TilePane tilePaneResultArea;
	
	public ControllerProductList(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/ViewProductResultList.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        setStyle("-fx-background-color: blue");
        
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        
	}


	public void setItems(List<Product> p) {
		clearPane();
		addItems(p);
    }

	private void clearPane() {
		tilePaneResultArea.getChildren().removeAll(tilePaneResultArea.getChildren());
		
	}
	private void addItems(List<Product> p){
        for (int i = 0; i < p.size(); i++) {
            tilePaneResultArea.getChildren().add(new ControllerProductCardPane(p.get(i)));
        }
	}
}
