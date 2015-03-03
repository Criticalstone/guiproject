package guiProject;

import guiProject.interfaces.IFProductList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleButton;

import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import se.chalmers.ait.dat215.project.ProductCategory;

import java.io.IOException;

public class Categories extends TabPane{
	
	@FXML
	private ToggleButton buttonStarList;
	
	@FXML
	private VBox favoritesList;
	
	private static Categories singelton;
	@FXML
	private ToggleGroup favoriteListGroup;

    private Categories() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/Categories.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        displayLists();
    }
    
    public static synchronized Categories getInstance(){
    	if (singelton == null){
    		singelton = new Categories();
    	}
    	return singelton;
    	
    	
    }
    
    public void displayLists() {
    	favoritesList.getChildren().removeAll(favoritesList.getChildren());
		for (IFProductList list: ControllerMain.getFavoriteLists()){
			addFavoriteList(list);
		}
		
	}

	public void addFavoriteList(IFProductList list){
    	favoritesList.getChildren().add(new ListButton(list));
    }

    @FXML
    public void buttonOnClick(ActionEvent event){
        ProductCategory categ = ProductCategory.valueOf(((ToggleButton)event.getSource()).getId());
        ControllerMain.setProductFromCategory(categ);
        ControllerMain.setBanner(categ);
    }

    
    @FXML
    public void starButtonAction(){
    	ControllerMain.setProductList(ControllerMain.getStaredProducts());
    }
    
    class ListButton extends ToggleButton{
    	public ListButton(IFProductList list){
//    		this.getStylesheets().add("../res/CategoriesMenuItem.css");
    		this.getStyleClass().add("menu-button");
    		this.setText(list.getName());
    		this.setToggleGroup(favoriteListGroup);
    	}
    }
}
