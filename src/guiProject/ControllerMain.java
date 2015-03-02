package guiProject;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import guiProject.interfaces.IFProductList;

import java.util.List;
/**
 * The main controller for iMat. The sub controllers will call for this class, which will coordinate actions between different nodes.
 * @author Kevin
 *
 */
//Maybe this class should be set as a singleton?
public class ControllerMain{
    private static IMatDataHandler imat;
    private static ControllerResultList controllerProdList;
    private static ShoppingCartHandler cart;
    private static ControllerShoppingLists favoriteLists;
    private static Categories categories;
    
    /**
     * Initialize the controller. Sets the IMatDataHandler, controllerProdList (result display area) and the shopping cart handler.
     * This method must me run only once for the controller to work.
     */
    public static void initialize() {
        imat = IMatDataHandler.getInstance();
        controllerProdList = new ControllerResultList();
        cart = new ShoppingCartHandler();
        favoriteLists = ControllerShoppingLists.getInstance();
        categories = Categories.getInstance();
    }

    /**
     * Returns a list of products based on a category.
     * @param categ The category for which all items are requested.
     * @return A list containing all products in the specified category.
     */
    public static List<Product> getProductFromCategory(ProductCategory categ){
        List<Product> products = imat.getProducts(categ);
        return products;
    }

    /**
     * Sets which products to display in the result list based on a category.
     * @param categ A category for which all products should be displayed in the result area.
     */
    public static void setProductFromCategory(ProductCategory categ){
        List<Product> productList = getProductFromCategory(categ);
        setProductList(productList);
    }

    public static void updateQtyAllCards(){
        controllerProdList.updateQtyInCartForAllCards();
    }

    /**
     * Sets which items should be displayed in the result list.
     * @param productList A list of all items to be displayed (unsorted).
     */
    public static void setProductList(List<Product> productList){
    	controllerProdList.setItems(productList);
    }

    /**
     * Returns the quantity in the current shopping cart of the specified item though the shopping cart handler.
     * @param p The product for witch the quantity is requested
     * @return The quantity of the item in the cart.
     */
    public static int getQuantityOfProduct(Product p){
        return cart.getQtyOfProduct(p);
    }

    /**
     * Adds a product to the shopping cart handler which communicate with the back end shopping cart.
     * @param p Product to be added
     * @param quantityDiff the quantity to be added or removed, accepts both positive and negative integers.
     */
    public static void addProductToCart(Product p, int quantityDiff){
        cart.addProduct(p, quantityDiff);
    }
    
    /**
     * Returns the instance of the Product result list (which displays the items for the user)
     * @return the current instance of the product result list.
     */
    public static ControllerResultList getProductList(){
        return controllerProdList;
    }
    /**
     * Method to toggle if the product should be marked as a favorite in the iMatHandler
     * @param p The product which will have it's favorite status modified.
     * @param toggle If the items should be a favorite (true) or not (false).
     */
    public static void starProduct(Product p, boolean toggle){
    	favoriteLists.starProduct(p, toggle);
    	
    }
    
	public static boolean isStared(Product p){
		return favoriteLists.isStared(p);
	}

    public static ShoppingCartHandler getShoppingCart(){
        return cart;
    }
    
    public static List<IFProductList> getFavoriteLists(){
    	return favoriteLists.getFavoriteLists();
    }

	public static List<Product> getStaredProducts() {
		return favoriteLists.getStaredProducts();
	}
	
	public static void addFavoriteList(String name){
		favoriteLists.addFavoriteList(name);
		categories.displayLists();
		
	}

    public static void performSearch(String query){
        List<Product> result = imat.findProducts(query);
        controllerProdList.setItems(result);
    }



}
