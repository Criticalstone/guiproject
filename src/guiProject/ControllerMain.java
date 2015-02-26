package guiProject;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.util.List;

public class ControllerMain{
    private static IMatDataHandler imat;
    private static ControllerProductList controllerProdList;
    private static ShoppingCartHandler cart;

    public static void initialize() {
        imat = IMatDataHandler.getInstance();
        controllerProdList = new ControllerProductList();
        cart = new ShoppingCartHandler();
    }

    public static List<Product> getProductFromCategory(ProductCategory categ){
        List<Product> products = imat.getProducts(categ);
        return products;
    }

    public static void setProductFromCategory(ProductCategory categ){
        List<Product> productList = getProductFromCategory(categ);
        setProductList(productList);
    }

    public static void setProductList(List<Product> productList){
    	controllerProdList.setItems(productList);
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
    
    public static void starProduct(Product p, boolean toggle){
    	//TODO
    	System.out.println("Starbutton has been pressed for " + p.getName() + " and it's is now set to " + toggle);
    }
    
    

    public static ShoppingCartHandler getShoppingCart(){
        return cart;
    }



}
