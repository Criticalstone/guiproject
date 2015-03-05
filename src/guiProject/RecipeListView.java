package guiProject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;


import java.io.IOException;

public class RecipeListView extends GridPane{

    public RecipeListView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/RecipeListView.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
             
    }
}