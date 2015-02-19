package guiProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCateg implements Initializable{


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleButtonAction(ActionEvent event) {
        System.out.println(((Button)event.getSource()).getText());
        System.out.println(((Button) event.getSource()).getId());
    }
}
