package guiProject;

import guiProject.ShoppingList.ShoppingListCell;
import guiProject.interfaces.IFProductList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import se.chalmers.ait.dat215.project.ShoppingItem;

public class RecipeListView extends GridPane{
	
    @FXML
    private ListView<HBox> listProducts;
    @FXML
    private ListView<HBox> listRecipe;
    @FXML
    private Button buttonAddToCart;
    
    private List<ShoppingItem> productList;

    public RecipeListView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/RecipeListView.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        buttonAddToCart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addToCartOnClick(event);
            }
        });
        productList = new ArrayList<>();    
    }
    
    public void addToCartOnClick(ActionEvent event){
        for(ShoppingItem item : productList) {
            ControllerMain.addProductToCart(item.getProduct(), (int)item.getAmount());
        }
    }
}