package guiProject;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class  MyController
{

@FXML
public ComboBox myCombobox;

public void initialize(URL url, ResourceBundle rb) {
}

public void setData(){

myCombobox.getItems().clear();

myCombobox.getItems().addAll(
            "jacob.smith@example.com",
            "isabella.johnson@example.com",
            "ethan.williams@example.com",
            "emma.jones@example.com",
            "michael.brown@example.com");

}
}