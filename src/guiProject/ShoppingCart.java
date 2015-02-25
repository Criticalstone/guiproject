package guiProject;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCart extends ListView<Product>{

    HashMap<Product, Integer> productList;

    public ShoppingCart() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/ShoppingCart.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        productList = new HashMap<>();

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /*public void addProduct(Product p){
        if(!productList.cogit ){
            productList.add(p);
        }else{
            Product product = productList.get(productList.indexOf(p));
            product.get
        }
    }*/
}
