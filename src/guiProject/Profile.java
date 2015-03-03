package guiProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.User;

import java.io.IOException;

/**
 * Created by kritt on 2015-03-03.
 */
public class Profile extends GridPane{

    @FXML
    private TextField textName;
    @FXML
    private TextField textAdress;
    @FXML
    private TextField textPostalCode;
    @FXML
    private TextField textPostal;
    @FXML
    private TextField textTel;
    @FXML
    private TextField textEmail;

    @FXML
    private Button buttonSave;

    public Profile() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/PersonalInfo.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        loadInfo();
    }

    @FXML
    private void saveOnAction(ActionEvent event){
        setInfoToCustomer();
    }

    public void loadInfo(){
        Customer customer = ControllerMain.getCustomer();
        textName.setText(customer.getFirstName() + " " + customer.getLastName());
        System.out.println(customer.getLastName());
        textAdress.setText(customer.getAddress());
        textPostalCode.setText(customer.getPostCode());
        textPostal.setText(customer.getPostAddress());
        textTel.setText(customer.getMobilePhoneNumber());
        textEmail.setText(customer.getEmail());
    }

    public void setInfoToCustomer(){
        Customer customer = ControllerMain.getCustomer();
        customer.setFirstName(textName.getText().split(" ")[0].trim());
        customer.setLastName(textName.getText().split(" ")[1].trim());
        customer.setAddress(textAdress.getText());
        customer.setPostCode(textPostalCode.getText());
        customer.setPostAddress(textPostal.getText());
        customer.setMobilePhoneNumber(textTel.getText());
        customer.setEmail(textEmail.getText());
    }



}
