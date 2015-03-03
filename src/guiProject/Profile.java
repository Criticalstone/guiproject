package guiProject;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Created by kritt on 2015-03-03.
 */
public class Profile {
    public Profile() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/ProfileInfo.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


}
