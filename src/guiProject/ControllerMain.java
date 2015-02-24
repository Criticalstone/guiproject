package guiProject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.Test;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerMain{
    private static IMatDataHandler imat;
    private static ControllerProductList controllerProdList;

    public static void initialize() {
        imat = IMatDataHandler.getInstance();
        controllerProdList = new ControllerProductList();
    }

    public static List<Product> getProductFromCategory(ProductCategory categ){
        return imat.getProducts(categ);
    }

    public static void setProductFromCategory(ProductCategory categ){
        List<Product> productList = getProductFromCategory(categ);
        setProductList(productList);
    }

    public static void setProductList(List<Product> productList){
        for(Product p: productList){
            controllerProdList.addItem(p);
        }
    }



}
