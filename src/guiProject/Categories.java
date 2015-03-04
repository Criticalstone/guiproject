package guiProject;

import guiProject.interfaces.IFProductList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.io.IOException;

public class Categories extends GridPane{
	
	@FXML
	private ToggleButton buttonStarList;
	
	@FXML
	private VBox favoritesList;
	
	private static Categories singelton;
	@FXML
	private ToggleGroup favoriteListGroup;

    private Categories() {

        // Create the accordion control
        Accordion acc = new Accordion();
        acc.getPanes().addAll(initMeat());
        acc.setPrefWidth(1000);
        add(acc, 0, 0);
    }



    private TitledPane initMeat(){
        ToggleButton meat = new ToggleButton("Nötkött");
        ToggleButton chicken = new ToggleButton("Kyckling");
        ToggleButton fish = new ToggleButton("Fisk");
        meat.setId("BEEFMEAT");
        chicken.setId("CHICKEN");
        fish.setId("FISH");

        meat.addEventHandler(ActionEvent.ACTION, event -> buttonOnClick(event));
        chicken.addEventHandler(ActionEvent.ACTION, event -> buttonOnClick(event));
        fish.addEventHandler(ActionEvent.ACTION, event -> buttonOnClick(event));

        ToggleGroup meatGroup = new ToggleGroup();
        meatGroup.getToggles().addAll(meat, chicken, fish);

        VBox inside = new VBox(10);
        inside.getChildren().addAll(meat, chicken, fish);
        TitledPane res = new TitledPane("Kött", inside);
        return res;
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
        CategoryInterpreter.Category categ = CategoryInterpreter.categoryValueOf(((ToggleButton) event.getSource()).getId());
        ControllerMain.setProductFromCategory(categ);
        //ControllerMain.setBanner(CategoryInterpreter.customCategToCateg(categ));
    }
    @FXML
    public void settingsOnAction() {
        ControllerMain.displayProfile();
    }

    @FXML
    public void myImatButtonAction(){
    	ControllerMain.displayDisplayProfile();
    }
    
    class ListButton extends ToggleButton{
    	public ListButton(IFProductList list){
    		this.getStyleClass().add("menu-button");
    		this.setText(list.getName());
    		this.setToggleGroup(favoriteListGroup);
    	}
    }
}
