package guiProject;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class StartView extends GridPane {
	
	public StartView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/StartView.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
	
	public void recipeEvent(MouseEvent e){
		System.out.println(((Node) e.getSource()).getId());
		ControllerMain.displayRecipeView(((Node) e.getSource()).getId());
	}
	
	public void recipeMouseEntered(MouseEvent e){
		setCursor(Cursor.HAND);
	}
	
	public void recipeMouseExited(MouseEvent e){
		setCursor(Cursor.DEFAULT);
	}

}
