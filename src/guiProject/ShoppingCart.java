package guiProject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.io.IOException;

public class ShoppingCart extends GridPane{

    public ShoppingCart() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "ShoppingCart.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
