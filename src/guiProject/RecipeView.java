package guiProject;

import java.io.IOException;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class RecipeView extends GridPane {
	
	public RecipeView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/RecipeView.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
	
	public void addToCartEvent(ActionEvent e){
		IMatDataHandler imat = IMatDataHandler.getInstance();
	
		ControllerMain.addProductToCart(imat.getProduct(115), 1);
		ControllerMain.addProductToCart(imat.getProduct(76), 1);
		ControllerMain.addProductToCart(imat.getProduct(147), 1);
		ControllerMain.addProductToCart(imat.getProduct(141), 1);
		ControllerMain.addProductToCart(imat.getProduct(55), 1);
		ControllerMain.addProductToCart(imat.getProduct(81), 1);
	}
}
