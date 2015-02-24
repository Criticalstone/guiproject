package guiProject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.io.IOException;

public class Banner extends AnchorPane{

    public Banner() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "Banner.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
