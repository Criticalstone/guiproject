package guiProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;

import se.chalmers.ait.dat215.project.ProductCategory;

public class Banner extends GridPane{

	@FXML
	private GridPane bannerBackground;
	@FXML
	private Button bannerTitle;
    @FXML
    private TextField textSearch;
    @FXML
    private Button myProfileButton;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView profileImg;

    
    public Banner() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/Banner.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        usernameLabel.setVisible(false);
        setBanner("start");
    }
    
    public void setBanner(String n){
    	switch(n){
    		case "kassa":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/IMAT.jpg');");
    			bannerTitle.setText("Kassa");
    			break;
    		case "start":
    	        bannerBackground.setStyle("-fx-background-image: url('res/banner/IMAT.jpg');");
    	        bannerTitle.setText("iMat");
    	        break;
    		case "BEEFMEAT":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/MEAT.jpg');");
    			bannerTitle.setText("Nötött");
    			break;
    		case "CHICKEN":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/MEAT.jpg');");
    			bannerTitle.setText("Kyckling");
    			break;
    		case "FISH":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/FISH.jpg');");
    			bannerTitle.setText("Fisk");
    			break;
    		case "POD":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/POD.jpg');");
    			bannerTitle.setText("Baljväxter");
				break;
    		case "BREAD":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/BREAD.jpg');");
    			bannerTitle.setText("Bröd");
				break;
    		case "BERRY":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/BERRY.jpg');");
    			bannerTitle.setText("Bär");
				break;
    		case "CITRUS_FRUIT":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/CITRUS_FRUIT.jpg');");
    			bannerTitle.setText("Citrus frukter");
				break;
    		case "HOT_DRINKS":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/HOT_DRINKS.jpg');");
    			bannerTitle.setText("Varm drycker");
				break;
    		case "COLD_DRINKS":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/COLD_DRINKS.jpg');");
    			bannerTitle.setText("Kalla drycker");
				break;
    		case "EXOTIC_FRUIT":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/EXOTIC_FRUIT.jpg');");
    			bannerTitle.setText("Exotiska frukter");
				break;
    		case "VEGETABLE_FRUIT":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/VEGETABLE_FRUIT.jpg');");
    			bannerTitle.setText("Grönsaksfrukter");
				break;
    		case "CABBAGE":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/CABBAGE.jpg');");
    			bannerTitle.setText("Kål");
				break;
    		case "DAIRIES":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/DAIRIES.jpg');");
    			bannerTitle.setText("Mejeri");
				break;
    		case "MELONS":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/MELONS.jpg');");
    			bannerTitle.setText("Meloner");
				break;
    		case "FLOUR":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/FLOUR_SUGAR_SALT.jpg');");
    			bannerTitle.setText("Mjöl");
				break;
    		case "SUGAR":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/FLOUR_SUGAR_SALT.jpg');");
    			bannerTitle.setText("Socker");
				break;
    		case "SALT":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/FLOUR_SUGAR_SALT.jpg');");
    			bannerTitle.setText("Mjöl");
				break;
    		case "NUTS_AND_SEEDS":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/NUTS_AND_SEEDS.jpg');");
    			bannerTitle.setText("Nötter & frön");
				break;
    		case "PASTA":	
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/PASTA.jpg');");
    			bannerTitle.setText("Pasta");
				break;
    		case "POTATO":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/POTATO_RICE.jpg');");
    			bannerTitle.setText("Potatis");
				break;
    		case "RICE":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/POTATO_RICE.jpg');");
    			bannerTitle.setText("Ris");
				break;
    		case "ROOT_VEGETABLE":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/ROOT_VEGETABLE.jpg');");
    			bannerTitle.setText("Rotfrukter");
				break;
    		case "FRUIT":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/FRUIT.jpg');");
    			bannerTitle.setText("Frukter");
				break;
    		case "SWEET":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/SWEET.jpg');");
    			bannerTitle.setText("Sötsaker");
				break;
    		case "HERB":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/HERB.jpg');");
    			bannerTitle.setText("Örter");
				break;
    		default:
    			break;
    	}
    }
    
    public void buttonAction(ActionEvent e){
    	switch(((Node) e.getSource()).getId()){
    		case "favorite":
    			if(ControllerMain.getLogInView().getLoggedInStatus()){
    				ControllerMain.setProductList(ControllerMain.getStaredProducts());
    				ControllerMain.unSelectCategories();
    				setBanner("start");
    				break;
    			}else{
    				ControllerMain.displayLoginView("favorite");
    				break;
    			}
    		case "shoppingList":
    			if(ControllerMain.getLogInView().getLoggedInStatus()){
    				ControllerMain.displayShoppingListView();
    				break;
    			}else{
    				ControllerMain.displayLoginView("list");
    				break;
    			}
    		case "recipe":
    			if(ControllerMain.getLogInView().getLoggedInStatus()){
    				ControllerMain.displayRecipeListView();
    				break;
    			}else{
    				ControllerMain.displayLoginView("recept");
    				break;
    			}
    		default:
    			break;
    	}
    }
    
    public void searchOnAction(){
        ControllerMain.performSearch(textSearch.getText());
        ControllerMain.unSelectCategories();
    }
    
    @FXML
    public void goHomeOnAction(){
    	ControllerMain.displayStartView();
    }
    
    @FXML
    public void MyProfileOnAction(){
    	if(ControllerMain.getLogInView().getLoggedInStatus()==true){  //Loggar ut
    		ControllerMain.getLogInView().setLoggedInStatus(false);
    		setTextToLoggedIn();
    		ControllerMain.setColorScheme(ControllerColorScheme.ColorScheme.DARK);
    		ControllerMain.displayLoginView("");
		}else{                                                         // Skickar dig s� du kan logga in
			ControllerMain.displayLoginView("");
		}		
    }
    
    @FXML
    public void nameLabelOnAction(){
    	ControllerMain.displayProfile(ControllerMain.getUser());
    }
  
    public void setUsernameLabel(){
    	usernameLabel.setText(ControllerMain.getUser().getUsername());
    }
    

    public void setTextToLoggedIn(){
    	if(ControllerMain.getLogInView().getLoggedInStatus()){
    		myProfileButton.setText("Logga ut");
    		usernameLabel.setVisible(true);
    		profileImg.setFitWidth(1);
    		profileImg.setVisible(false);
    	}else{
    		usernameLabel.setVisible(false);
    		profileImg.setVisible(true);
    		profileImg.setFitWidth(44);
    		myProfileButton.setText("Logga in");
    	}
    }
}
