package guiProject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;


import java.io.IOException;

public class ShoppingListView extends GridPane{

    public ShoppingListView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/ShoppingListView.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
             
    }
}