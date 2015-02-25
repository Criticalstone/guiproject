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
    private static ShoppingCart cart;

    public static void initialize() {
        imat = IMatDataHandler.getInstance();
        controllerProdList = new ControllerProductList();
        cart = new ShoppingCart();
    }

    public static List<Product> getProductFromCategory(ProductCategory categ){
        List<Product> products = imat.getProducts(categ);
        for(Product p:products){
            System.out.println(p.getName());
        }
        return products;
    }

    public static void setProductFromCategory(ProductCategory categ){
        List<Product> productList = getProductFromCategory(categ);
        setProductList(productList);
    }

    public static void setProductList(List<Product> productList){
    	controllerProdList.addItem(productList);
    }

    public static int getQuantityOfProduct(Product p){
        return cart.getQtyOfProduct(p);
    }

    public static void addProductToCart(Product p, int quantityDiff){
        cart.addProduct(p, quantityDiff);
    }

    public static ControllerProductList getProductList(){
        return controllerProdList;
    }



}
