package guiProject;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import guiProject.CheckoutView.PaymentOption;
import guiProject.ControllerColorScheme.ColorScheme;
import se.chalmers.ait.dat215.project.*;
import guiProject.interfaces.IFProductList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Archive.TestFileChooser;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

/**
 * The main controller for iMat. The sub controllers will call for this class, which will coordinate actions between different nodes.
 * @author Kevin & Anton
 *
 */
//Maybe this class should be set as a singleton?
public class ControllerMain extends Application{

    private static IMatDataHandler imat;
    private static Scene scene;
    private static UserProfile user;
    private static ControllerColorScheme colorScheme;
    
    //Components
    private static ControllerResultList controllerResultList;
    private static ShoppingCartHandler controllershoppingCart;
    private static Banner controllerBanner;
    private static ControllerShoppingLists controllerShoppingLists;
    private static Categories controllerCategories;
    private static RecipeView recipeView;
    private static StartView startView;
    private static CheckoutView checkoutView;
    private static Customer customer;
    private static RecipeListView recipeListView;
    private static ShoppingList shoppingList;
    private static LogInView logInView;
    private static ProfileView profileView;
//    private static TestFileChooser fileChooser;
    
    //Panes in mainview
    @FXML
    private static GridPane categoriesView;
    @FXML
    private static GridPane detailView;
    @FXML
    private static GridPane shoppingCartPane;
    @FXML
    private static GridPane bannerPane;
    


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
    
	public static void addShoppingList(String name){
		controllerShoppingLists.addShoppingList(name);
	}

    public static void addProductToList(String name, List<ShoppingItem> list){
        controllerShoppingLists.addProductToList(name, list);
    }
    
    public static void addProductToList(String name, ShoppingItem product){
    	controllerShoppingLists.addProductToList(name, product);
    }

    public static void performSearch(String query){
        displayProductResultList();
        List<Product> result = imat.findProducts(query);
        controllerResultList.setItems(result);
    }

	public static void emptyCart() {
		controllershoppingCart.emptyCart();
	}
	
	public static void removeProductFromList(String listName, ShoppingItem item){
		controllerShoppingLists.removeProductFromList(listName, item);
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
    	colorScheme.setColorScheme(color);
    	scene.getStylesheets().setAll(colorScheme.getColorScheme());

    }
    
    public static void setStyleSheet(){
    	
    }

    public static void removeShoppingList(String name){
        controllerShoppingLists.getShoppingLists().remove(name);
    }
    
    public static void setUser(UserProfile userprofile){
    	user = userprofile;
    }


    
	//DISPLAY METHODS
    public static void updateCards(){
        controllerResultList.updateAllCards();
    }

    public static void updateShoppingListView(){
        shoppingList.updateShoppingListView();
    }
    
	public static void displayPaymentOption(PaymentOption option){
		checkoutView.displayPaymentOption(option);
	}
	
	public static void displayPurchaseConfirmation(String deliveryDate) {
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(new ThankYouForPurchase(deliveryDate));	
		controllershoppingCart.setCheckoutButtonStatus(true);
		
	}
	
	public static void displayStartView(){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(startView);
		collapseCategories();
		setBanner("start");
		controllershoppingCart.setCheckoutButtonStatus(true);
	}
	
	public static void displayRecipeView(String recipeName){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(recipeView);
		recipeView.setRecipe(recipeName);
		setBanner("start");
		controllershoppingCart.setCheckoutButtonStatus(true);
	}
	
	
	public static void displayCheckout(){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(checkoutView);
		controllershoppingCart.setCheckoutButtonStatus(false);
	}
	public static void displayRecipeListView(){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(recipeListView);
        unSelectCategories();
        setBanner("start");
        controllershoppingCart.setCheckoutButtonStatus(true);
    }
	
	public static void displayShoppingListView(){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(shoppingList);
        shoppingList.updateOrdersListView();
        shoppingList.updateShoppingListView();
    	unSelectCategories();
    	setBanner("start");
    	controllershoppingCart.setCheckoutButtonStatus(true);
	}
	

    public static void displayProfile(UserProfile userP){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(new ProfileView(userP)); 
		controllershoppingCart.setCheckoutButtonStatus(true);
    }
	
	public static void displayProductResultList(){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(controllerResultList);
		controllershoppingCart.setCheckoutButtonStatus(true);
	}
	
	public static void collapseCategories(){
		controllerCategories.collapseCategories();
	}
	
	public static void unSelectCategories(){
		controllerCategories.unSelectCategories();
	}

	public static void displayLoginView(String side){
		detailView.getChildren().removeAll(detailView.getChildren());
		detailView.getChildren().add(new TotalLogInView(side));
		controllershoppingCart.setCheckoutButtonStatus(true);
	}
	
	//GETTERS
	public static List<Order> getOrderHistory(){
		return controllerShoppingLists.getOrderHistory();
	}
	
    public static UserProfile getUser(){
        return user;
    }

    public static HashMap<String, IFProductList<ShoppingItem>> getShoppingLists(){
        return controllerShoppingLists.getShoppingLists();
    }

    public static Customer getCustomer(){
        return imat.getCustomer();
    }
    
    public static HashMap<String, IFProductList<ShoppingItem>> getFavoriteLists(){
    	return controllerShoppingLists.getShoppingLists();
    }

	public static List<Product> getStaredProducts() {
		return controllerShoppingLists.getStaredProducts();
	}
	
    public static Banner getBanner(){
    	return controllerBanner;
    }

    public static void placeOrder(){
        imat.placeOrder();
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
	
	public static LogInView getLogInView(){
		return logInView;
	}
	
	public static ProfileView getProfileView(){
		return profileView; 
	}
	
	public static ColorScheme getCurrentColorScheme(){
		return colorScheme.getCurrentColor();
	}
	
	public static List<ColorScheme> getAllAvailableColorSchemes(){
		return colorScheme.getAllSchemes();
	}
	
//	public static TestFileChooser getFileChooser(){
//		return fileChooser;
//	}
	
	
	//STARTUP METHODS
	@Override
    public void start(Stage primaryStage) throws Exception{

        controllerResultList = new ControllerResultList();
        controllershoppingCart = new ShoppingCartHandler();
        controllerShoppingLists = ControllerShoppingLists.getInstance();
        controllerCategories = Categories.getInstance();
        checkoutView = new CheckoutView();
        logInView=new LogInView("","");
        controllerBanner = new Banner();
        startView = new StartView();
        recipeView = new RecipeView();
        recipeListView = new RecipeListView();
        shoppingList = new ShoppingList();
        colorScheme = new ControllerColorScheme("defaultColorScheme");
        
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
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                imat.shutDown();
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
        setColorScheme(ColorScheme.DARK);
        controllershoppingCart.updateList();

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
	private static void testDataTEMPORARY() {

		

    }



}
