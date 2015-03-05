package guiProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import se.chalmers.ait.dat215.project.ProductCategory;

public class Banner extends GridPane{

	@FXML
	private GridPane bannerBackground;
	@FXML
	private AnchorPane bannerTitle;
    @FXML
    private TextField textSearch;

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
        
        setBanner("start");
       
    }
    
    
    public void setBanner(ProductCategory categ){
    	switch(categ){
    		case MEAT:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/MEAT.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/meatTitle.png');");
    			break;
    		case FISH:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/FISH.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/fishTitle.png');");
    			break;
    		case POD:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/POD.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/podTitle.png');");
				break;
    		case BREAD:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/BREAD.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/breadTitle.png');");
				break;
    		case BERRY:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/BERRY.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/berryTitle.png');");
				break;
    		case CITRUS_FRUIT:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/CITRUS_FRUIT.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/citrus_fruitTitle.png');");
				break;
    		case HOT_DRINKS:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/HOT_DRINKS.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/hot_drinksTitle.png');");
				break;
    		case COLD_DRINKS:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/COLD_DRINKS.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/cold_drinksTitle.png');");
				break;
    		case EXOTIC_FRUIT:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/EXOTIC_FRUIT.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/exotic_fruitTitle.png');");
				break;
    		case VEGETABLE_FRUIT:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/VEGETABLE_FRUIT.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/vegetable_fruitTitle.png');");
				break;
    		case CABBAGE:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/CABBAGE.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/cabbageTitle.png');");
				break;
    		case DAIRIES:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/DAIRIES.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/dairiesTitle.png');");
				break;
    		case MELONS:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/MELONS.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/melonsTitle.png');");
				break;
    		case FLOUR_SUGAR_SALT:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/FLOUR_SUGAR_SALT.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/flour_sugar_saltTitle.png');");
				break;
    		case NUTS_AND_SEEDS:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/NUTS_AND_SEEDS.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/nuts_and_seedsTitle.png');");
				break;
    		case PASTA:	
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/PASTA.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/pastaTitle.png');");
				break;
    		case POTATO_RICE:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/POTATO_RICE.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/potato_riceTitle.png');");
				break;
    		case ROOT_VEGETABLE:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/ROOT_VEGETABLE.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/root_vegetableTitle.png');");
				break;
    		case FRUIT:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/FRUIT.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/fruitTitle.png');");
				break;
    		case SWEET:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/SWEET.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/sweetTitle.png');");
				break;
    		case HERB:
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/HERB.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/herbTitle.png');");
				break;
    		default:	
    			break;	
    	}
    }
    
    public void setBanner(String n){
    	switch(n){
    		case "kassa":
    			bannerBackground.setStyle("-fx-background-image: url('res/banner/IMAT.jpg');");
    			bannerTitle.setStyle("-fx-background-image: url('res/banner/kassa.png');");
    			break;
    		case "start":
    	        bannerTitle.setStyle("-fx-background-image: url('res/banner/iMat.png');");
    	        bannerBackground.setStyle("-fx-background-image: url('res/banner/IMAT.jpg');");
    	        break;
    		default:
    			break;
    	}
    }
    
    public void buttonAction(ActionEvent e){
    	switch(((Node) e.getSource()).getId()){
    		case "favorite":
    			ControllerMain.setProductList(ControllerMain.getStaredProducts());
    			break;
    		case "shoppingList":
    			ControllerMain.displayShoppingListView();
    			break;
    		case "recipe":
    			ControllerMain.displayRecipeListView();
    			break;
    		default:
    			break;
    	}
    }
    
    public void bannerEvent(MouseEvent e){
    	ControllerMain.displayStartView();
    }
    
    public void bannerMouse(MouseEvent e){
    	setCursor(Cursor.HAND);
    }
    
    public void bannerMouseExit(MouseEvent e){
    	setCursor(Cursor.DEFAULT);
    }
    
    public void searchOnAction(){
        ControllerMain.performSearch(textSearch.getText());
    }
    
    @FXML
    public void goHomeOnAction(){
    	ControllerMain.displayStartView();
    }
}
