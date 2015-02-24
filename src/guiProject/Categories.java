package guiProject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Categories extends TabPane{

    public Categories() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "Categories.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    public void buttonOnClick(MouseEvent event){
        System.out.println(((Label)event.getSource()).getId());
    }
}
