package guiProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.io.IOException;

public class Categories extends TabPane{

    public Categories() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/Categories.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    public void buttonOnClick(ActionEvent event){
        ProductCategory categ = ProductCategory.valueOf(((ToggleButton)event.getSource()).getId());
        ControllerMain.setProductFromCategory(categ);
    }

}
