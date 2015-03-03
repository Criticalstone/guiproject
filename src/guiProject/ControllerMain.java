package guiProject;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import guiProject.interfaces.IFProductList;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 * The main controller for iMat. The sub controllers will call for this class, which will coordinate actions between different nodes.
 * @author Kevin
 *
 */
//Maybe this class should be set as a singleton?
public class ControllerMain extends Application{
	
	
    private static IMatDataHandler imat;
    private static ControllerResultList controllerProdList;
    private static ShoppingCartHandler cart;
    private static ControllerShoppingLists favoriteLists;
    private static Categories categories;

    private static CheckoutView checkoutView;
    
    @FXML
    private static GridPane categoriesView;
    @FXML
    private static GridPane detailView;
    @FXML
    private static GridPane shoppingCartPane;
    @FXML
    private static GridPane bannerPane;


    /**
     * Initialize the controller. Sets the IMatDataHandler, controllerProdList (result display area) and the shopping cart handler.
     * This method must me run only once for the controller to work.
     */
    public static void initialize(String[] args) {
    	launch(args);

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
    	displayProductResultList();
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


	public static void displayCheckout(){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(checkoutView);
	}
	
	public static void displayProductResultList(){
		if (detailView == null){
			System.out.println("derp");
		}
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(controllerProdList);
	}
	
	@Override
    public void start(Stage primaryStage) throws Exception{
		
        imat = IMatDataHandler.getInstance();
        controllerProdList = new ControllerResultList();
        cart = new ShoppingCartHandler();
        favoriteLists = ControllerShoppingLists.getInstance();
        categories = Categories.getInstance();
        checkoutView = new CheckoutView();
        
        //Setup FXML
        Parent root = FXMLLoader.load(getClass().getResource("fxml/MainView.fxml"));
        primaryStage.setTitle("iMat");
        Scene scene = new Scene(root);
        
        //Initialize main panels.
		categoriesView = (GridPane) scene.lookup("#categoriesView");
		detailView = (GridPane) scene.lookup("#detailView");
		shoppingCartPane = (GridPane) scene.lookup("#shoppingCartPane");
		bannerPane = (GridPane) scene.lookup("#bannerPane");
        

        //Add Categories pane
		categoriesView.getChildren().add(Categories.getInstance());
		
        //Add banner
        bannerPane.getChildren().add(new Banner());
        
        //Add shoppingcart
        shoppingCartPane.getChildren().add(ControllerMain.getShoppingCart());
        
        
        //THIS METHOD SHOULD BE REMOVED WHEN RUNNING LIVE!!!
//        testDataTEMPORARY();


        
        //Complete setup
        scene.getStylesheets().add("/res/sample.css");
        scene.getStylesheets().add("/res/CategoriesMenuItem.css");
        primaryStage.setScene(scene);

        primaryStage.show();
        

    }

	//Add statements to this method to run test data in the environment.
	private void testDataTEMPORARY() {
		//Details view test
        ControllerResultList productList = ControllerMain.getProductList();
        
        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 1; i < 30;i++){
        	products.add(IMatDataHandler.getInstance().getProduct(i));
        }
        productList.setItems(products);
        detailView.getChildren().add(productList);


        

        
        //Setup test for checkoutView
        /*Pane checkoutViewPane = (Pane) scene.lookup("#detailView");
        checkoutViewPane.getChildren().add(new CheckoutView());*/
        
        //Testing Favorite lists
    	ControllerMain.addFavoriteList("Derp list");
	}



}
