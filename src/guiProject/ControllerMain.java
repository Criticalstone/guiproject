package guiProject;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import guiProject.CheckoutView.PaymentOption;
import se.chalmers.ait.dat215.project.*;
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
 * @author Kevin & Anton
 *
 */
//Maybe this class should be set as a singleton?
public class ControllerMain extends Application{
	
	
    private static IMatDataHandler imat;
    private static Scene scene;
    
    //Components
    private static ControllerResultList controllerResultList;
    private static ShoppingCartHandler controllershoppingCart;
    private static Banner controllerBanner;
    private static ControllerShoppingLists controllerShoppingLists;
    private static Categories controllerCategories;
    private static RecipeView recipeView;
    private static StartView startView;
    private static Profile profile;
    private static CheckoutView checkoutView;
    private static User user;
    private static Customer customer;
    private static RecipeListView recipeListView;
    private static ShoppingListView shoppingListView;

    
    //Panes in mainview
    @FXML
    private static GridPane categoriesView;
    @FXML
    private static GridPane detailView;
    @FXML
    private static GridPane shoppingCartPane;
    @FXML
    private static GridPane bannerPane;
    
    //For color schemes
    
    private static ColorScheme currentColorScheme;
    private static String defaultSheet = "/res/defaultStyleSheet.css";
    
    public enum ColorScheme {
        DARK("/res/colorSchemeDark.css"),
        BLUE("/res/colorSchemeBlue.css"),
        RED("/res/colorSchemeRed.css"),
        PINK("/res/colorSchemePink.css");

        private String colorScheme;

        ColorScheme(String colorScheme) {
            this.colorScheme = colorScheme;
        }

        public String getScheme() {
            return colorScheme;
        }
    }

    /**
     * Returns a list of products based on a category.
     * @param categ The category for which all items are requested.
     * @return A list containing all products in the specified category.
     */
    public static List<Product> getProductFromCategory(Category categ){
        List<Product> products = CategoryInterpreter.getProductFromCateg(categ);
        return products;
    }

    /**
     * Sets which products to display in the result list based on a category.
     * @param categ A category for which all products should be displayed in the result area.
     */
    public static void setProductFromCategory(Category categ){
        setProductList(CategoryInterpreter.getProductFromCateg(categ));
    }

	//DOERS
    /**
     * Method to toggle if the product should be marked as a favorite in the iMatHandler
     * @param p The product which will have it's favorite status modified.
     * @param toggle If the items should be a favorite (true) or not (false).
     */
    public static void starProduct(Product p, boolean toggle){
    	controllerShoppingLists.starProduct(p, toggle);
    	
    }
    
	public static void addFavoriteList(String name){
		controllerShoppingLists.addFavoriteList(name);
		controllerCategories.displayLists();
		
	}

    public static void performSearch(String query){
        List<Product> result = imat.findProducts(query);
        controllerResultList.setItems(result);
    }

	public static void emptyCart() {
		controllershoppingCart.emptyCart();
		
	}
	
	public static boolean login(String username, String password){
		if (username.equals(imat.getUser().getUserName()) && password.equals(imat.getUser().getPassword())){
			return true;
		}
		return false;
	}

	//SETTERS
    
    public static void setBanner(String n){
    	controllerBanner.setBanner(n);
    }

    /**
     * Sets which items should be displayed in the result list.
     * @param productList A list of all items to be displayed (unsorted).
     */
    public static void setProductList(List<Product> productList){
        controllerResultList.setItems(productList);
        displayProductResultList();
    }
    
    public static void setColorScheme(ColorScheme color){
    	removeAllAddedSchemes();
    	scene.getStylesheets().add(color.getScheme());
    	currentColorScheme = color;
    }


    
	//DISPLAY METHODS
    public static void updateQtyAllCards(){
        controllerResultList.updateQtyInCartForAllCards();
    }
    
	public static void displayPaymentOption(PaymentOption option){
		checkoutView.displayPaymentOption(option);
	}
	
	public static void displayPurchaseConfirmation() {
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(new ThankYouForPurchase());
		
	}
	
	public static void displayStartView(){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(startView);
		setBanner("start");
	}
	
	public static void displayRecipeView(){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(recipeView);
		setBanner("start");
	}
	
	public static void displayDisplayProfile() {
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(new Profile()); 
		
	}
	
	public static void displayCheckout(){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(checkoutView);
	}
	public static void displayRecipeListView(){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(recipeListView);
	}
	
	public static void displayShoppingListView(){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(shoppingListView);
	}
	

    public static void displayProfile(){
        detailView.getChildren().removeAll(detailView.getChildren());
        detailView.getChildren().add(profile);
        profile.loadInfo();
    }
	
	public static void displayProductResultList(){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(controllerResultList);
	}
	
	//GETTERS
	public static List<Order> getOrderHistory(){
		return controllerShoppingLists.getOrderHistory();
	}
	
    public static User getUser(){
        return imat.getUser();
    }

    public static Customer getCustomer(){
        return imat.getCustomer();
    }
    
    public static List<IFProductList> getFavoriteLists(){
    	return controllerShoppingLists.getFavoriteLists();
    }

	public static List<Product> getStaredProducts() {
		return controllerShoppingLists.getStaredProducts();
	}
	
    public static Banner getBanner(){
    	return controllerBanner;
    }

    /**
     * Returns the quantity in the current shopping cart of the specified item though the shopping cart handler.
     * @param p The product for witch the quantity is requested
     * @return The quantity of the item in the cart.
     */
    public static int getQuantityOfProduct(Product p){
        return controllershoppingCart.getQtyOfProduct(p);
    }

    /**
     * Adds a product to the shopping cart handler which communicate with the back end shopping cart.
     * @param p Product to be added
     * @param quantityDiff the quantity to be added or removed, accepts both positive and negative integers.
     */
    public static void addProductToCart(Product p, int quantityDiff){
        controllershoppingCart.addProduct(p, quantityDiff);
    }
    
    /**
     * Returns the instance of the Product result list (which displays the items for the user)
     * @return the current instance of the product result list.
     */
    public static ControllerResultList getProductList(){
        return controllerResultList;
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
    
    public static ShoppingCartHandler getShoppingCart(){
        return controllershoppingCart;
    }
    
	public static boolean getIsStared(Product p){
		return controllerShoppingLists.isStared(p);
	}
	
	//LOCAL METHODS
	private static void removeAllAddedSchemes() {
		for (String sheet: scene.getStylesheets()){
    		if (!sheet.equals(defaultSheet)){
    			scene.getStylesheets().removeAll(sheet);
    		}
    	}
	}
	

	
	//STARTUP METHODS
	@Override
    public void start(Stage primaryStage) throws Exception{

        controllerResultList = new ControllerResultList();
        controllershoppingCart = new ShoppingCartHandler();
        controllerShoppingLists = ControllerShoppingLists.getInstance();
        controllerCategories = Categories.getInstance();
        checkoutView = new CheckoutView();
        controllerBanner = new Banner();
        startView = new StartView();
        recipeView = new RecipeView();
        profile = new Profile();
        recipeListView = new RecipeListView();
        shoppingListView = new ShoppingListView();
        
        //Setup FXML
        Parent root = FXMLLoader.load(getClass().getResource("fxml/MainView.fxml"));
        primaryStage.setTitle("iMat");
        scene = new Scene(root, 1000, 600);
        
        //Initialize main panels.
		categoriesView = (GridPane) scene.lookup("#categoriesView");
		detailView = (GridPane) scene.lookup("#detailView");
		shoppingCartPane = (GridPane) scene.lookup("#shoppingCartPane");
		bannerPane = (GridPane) scene.lookup("#bannerPane");

        //Add Categories pane
		categoriesView.getChildren().add(controllerCategories);
		
        //Add banner
        bannerPane.getChildren().add(controllerBanner);
        
        //Add shoppingcart
        shoppingCartPane.getChildren().add(controllershoppingCart);
        
        //Display start
        detailView.getChildren().add(startView);
        
        //THIS METHOD SHOULD BE REMOVED WHEN RUNNING LIVE!!!
//        testDataTEMPORARY();


        
        //Complete setup
        scene.getStylesheets().add(defaultSheet);
        
        primaryStage.setScene(scene);

        primaryStage.show();
        setColorScheme(ColorScheme.BLUE);
    }


	
    /**
     * Initialize the controller. Sets the IMatDataHandler, controllerProdList (result display area) and the shopping cart handler.
     * This method must me run only once for the controller to work.
     */
    public static void initialize(String[] args) {
        imat = IMatDataHandler.getInstance();
    	launch(args);
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
