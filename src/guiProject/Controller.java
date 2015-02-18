package guiProject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Test;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    private IMatDataHandler imat;

    //Lägg till componenter som ni vill kunna styra här
    //ex:
    //public Button searchButton;

    //om instansvariabeln ska vara private måste den prefixas med en @FXML tag
    //ex:
    @FXML
    private Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imat = IMatDataHandler.getInstance();
    }

    //Gör sedan en listener av valfritt slag till den
    public void buttonOnAction(){
        //do shizzle
        //kommunicera med modellen
        //hämta data, presentera data osv
        System.out.println(imat.getProduct(42).getName() + " " + imat.getProduct(42).getPrice());
    }
}
