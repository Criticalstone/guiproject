package guiProject;

import guiProject.interfaces.IFProductList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Categories extends GridPane{
	
	@FXML
	private ToggleButton buttonStarList;
	
	@FXML
	private VBox favoritesList;
	
	private static Categories singelton;
	private ToggleGroup buttonGroup = new ToggleGroup();
	
	Accordion acc = new Accordion();

    private Categories() {
        add(initCategories(), 0, 0);
    }

    private Accordion initCategories(){
        acc.getPanes().addAll(initMeat(), initFriut(), initDairies(), initPantry(), initDrink(), initSweet());
        acc.setPrefWidth(1000);
        return acc;
    }

    private TitledPane initMeat(){
        List<ToggleButton> buttons = new ArrayList<>();

        buttons.add(new ToggleButton("Nötkött"));
        buttons.add(new ToggleButton("Kyckling"));
        buttons.add(new ToggleButton("Fisk"));
        buttons.get(0).setId("BEEFMEAT");
        buttons.get(1).setId("CHICKEN");
        buttons.get(2).setId("FISH");

        VBox inside = new VBox();
        for(ToggleButton button : buttons){
            button.addEventHandler(ActionEvent.ACTION, event -> buttonOnClick(event));
            button.setMinWidth(130);
            setButtonStyle(button);
        }

        buttonGroup.getToggles().addAll(buttons);


        inside.setFillWidth(true);
        inside.getChildren().addAll(buttons);
        TitledPane res = new TitledPane("Kött", inside);
//        res.getStyleClass().add("category-menu-list-item");
        return res;
    }

    private TitledPane initFriut(){
        List<ToggleButton> buttons = new ArrayList<>();
        buttons.add(new ToggleButton("Bär"));
        buttons.add(new ToggleButton("Citrusfrukter"));
        buttons.add(new ToggleButton("Exotiska frukter"));
        buttons.add(new ToggleButton("Meloner"));
        buttons.add(new ToggleButton("Stenfrukter"));
        buttons.add(new ToggleButton("Rotfrukter"));
        buttons.add(new ToggleButton("Kål"));
        buttons.add(new ToggleButton("Baljväxter"));
        buttons.add(new ToggleButton("Potatis"));
        buttons.add(new ToggleButton("Örter"));
        buttons.get(0).setId("BERRY");
        buttons.get(1).setId("CITRUS_FRUIT");
        buttons.get(2).setId("EXOTIC_FRUIT");
        buttons.get(3).setId("MELONS");
        buttons.get(4).setId("FRUIT");
        buttons.get(5).setId("ROOT_VEGETABLE");
        buttons.get(6).setId("CABBAGE");
        buttons.get(7).setId("POD");
        buttons.get(8).setId("POTATO");
        buttons.get(9).setId("HERB");

        for(ToggleButton button : buttons){
            button.addEventHandler(ActionEvent.ACTION, event -> buttonOnClick(event));
            button.setMinWidth(130);
            setButtonStyle(button);
            
        }

        buttonGroup.getToggles().addAll(buttons);

        VBox inside = new VBox();
        inside.getChildren().addAll(buttons);
        TitledPane res = new TitledPane("Frukt och grönt", inside);
        return res;
    }

    private TitledPane initDairies(){
        ToggleButton button = new ToggleButton("Mejeri");
        button.setId("DAIRIES");
        button.addEventHandler(ActionEvent.ACTION, event -> buttonOnClick(event));
        button.setMinWidth(130);
        setButtonStyle(button);
        buttonGroup.getToggles().add(button);

        VBox inside = new VBox();
        inside.getChildren().add(button);
        TitledPane res = new TitledPane("Mejeri", inside);
        return res;
    }

    private TitledPane initPantry(){
        List<ToggleButton> buttons = new ArrayList<>();
        buttons.add(new ToggleButton("Bröd"));
        buttons.add(new ToggleButton("Mjöl"));
        buttons.add(new ToggleButton("Socker"));
        buttons.add(new ToggleButton("Salt"));
        buttons.add(new ToggleButton("Nötter & frön"));
        buttons.add(new ToggleButton("Pasta"));
        buttons.add(new ToggleButton("Potatis"));
        buttons.add(new ToggleButton("Ris"));
        buttons.get(0).setId("BREAD");
        buttons.get(1).setId("FLOUR");
        buttons.get(2).setId("SUGAR");
        buttons.get(3).setId("SALT");
        buttons.get(4).setId("NUTS_AND_SEEDS");
        buttons.get(5).setId("PASTA");
        buttons.get(6).setId("POTATO");
        buttons.get(7).setId("RICE");

        for(ToggleButton button : buttons){
            button.addEventHandler(ActionEvent.ACTION, event -> buttonOnClick(event));
            button.setMinWidth(130);
            setButtonStyle(button);
        }

        buttonGroup.getToggles().addAll(buttons);

        VBox inside = new VBox();
        inside.getChildren().addAll(buttons);
        TitledPane res = new TitledPane("Skafferi", inside);
        return res;
    }

    private TitledPane initDrink(){
        List<ToggleButton> buttons = new ArrayList<>();
        buttons.add(new ToggleButton("Varma"));
        buttons.add(new ToggleButton("Kalla"));
        buttons.get(0).setId("HOT_DRINKS");
        buttons.get(1).setId("COLD_DRINKS");

        for(ToggleButton button : buttons){
            button.addEventHandler(ActionEvent.ACTION, event -> buttonOnClick(event));
            button.setMinWidth(130);
            setButtonStyle(button);
        }

        buttonGroup.getToggles().addAll(buttons);

        VBox inside = new VBox();
        inside.getChildren().addAll(buttons);
        TitledPane res = new TitledPane("Drycker", inside);
        return res;
    }

    private TitledPane initSweet(){
        ToggleButton button = new ToggleButton("Sötsaker");
        button.setId("SWEET");
        button.addEventHandler(ActionEvent.ACTION, event -> buttonOnClick(event));
        button.setMinWidth(130);
        setButtonStyle(button);
        buttonGroup.getToggles().add(button);

        VBox inside = new VBox();
        inside.getChildren().add(button);
        TitledPane res = new TitledPane("Sötsaker", inside);
        return res;
    }
    
    public static synchronized Categories getInstance(){
    	if (singelton == null){
    		singelton = new Categories();
    	}
    	return singelton;
    	
    	
    }

	public void addFavoriteList(IFProductList list){
    	favoritesList.getChildren().add(new ListButton(list));
    }

    @FXML
    public void buttonOnClick(ActionEvent event){
        Category categ = CategoryInterpreter.categoryValueOf(((ToggleButton) event.getSource()).getId());
        ControllerMain.setProductFromCategory(categ);
        ControllerMain.setBanner(categ.toString());
    }
    

    class ListButton extends ToggleButton{
    	public ListButton(IFProductList list){
    		this.setText(list.getName());
    		//this.setToggleGroup(buttonGroup);
    	}
    }
    
    public void setButtonStyle(ToggleButton button){
    	button.getStyleClass().add("menu-button");
    }
    
    public void collapseCategories(){
    	for(TitledPane p :acc.getPanes()){
    		p.setExpanded(false);
    	}
    	unSelectCategories();
    }
    
    public void unSelectCategories(){
    	for(Toggle b : buttonGroup.getToggles()){
    		b.setSelected(false);
    	}
    }
}
