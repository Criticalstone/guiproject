package guiProject;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class Banner extends GridPane{

    public Banner() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/Banner.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
