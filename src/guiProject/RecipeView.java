package guiProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class RecipeView extends GridPane {	
	@FXML
	private Label nameLabel;
	@FXML
	private Label infoLabel;
	@FXML
	private ImageView recipeImage;
	@FXML
	private ListView<String> ingredientsList;
	@FXML
	private TextArea descriptionText;
	@FXML
	private ListView<String> instructionList;
	
	private Set<Recipe> recipes;

	
	public RecipeView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/RecipeView.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        getRecipe();
    }
	
	public void getRecipe(){
		 File file = new File("src/res/recipeView/recipes.txt");
	     FileReader reader;
	     recipes = new HashSet<Recipe>();
	     BufferedReader dis = null;
	     try {
            reader = new FileReader(file);
            dis = new BufferedReader(reader);
            String line = null;
            String name = null;
            String info = null;
            String imagePath = null;
            Map<Product, String> ingredients = null;
            String description = null;
            List<String>instruction = null;
            while ((line = dis.readLine()) != null) {
                if (line.equals("#name")) {
                    name = dis.readLine();
                }else if(line.equals("#info")){
                	info = dis.readLine();
                }else if (line.equals("#image")) {
                    imagePath = dis.readLine();
                }else if (line.equals("#ingredients")) {
                	IMatDataHandler imat = IMatDataHandler.getInstance();
                    ingredients = new HashMap<Product, String>();
                    Product i = null;
                    while (!(line = dis.readLine()).equals("#end")) {
                    	i = imat.getProduct(Integer.parseInt(line));
                    	ingredients.put(i, dis.readLine());
                    }
                }else if (line.equals("#description")) {
                	description = dis.readLine();
                }else if(line.equals("#instruction")){
                	instruction = new ArrayList<String>();
                	line = dis.readLine();
                	while (!line.equals("#end")) {
                		instruction.add(line);
                		line = dis.readLine();
                	}
                	recipes.add(new Recipe(name, info, imagePath, ingredients, description, instruction));
                }
            }
            dis.close();
            reader.close();
      
            
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }
	   
	}
	
	public void setRecipe(String recipeName){
		ObservableList<String> items = FXCollections.observableArrayList();
		ObservableList<String> instruction = FXCollections.observableArrayList();
		for(Recipe r : recipes){
			if(recipeName.equals(r.getName())){
				nameLabel.setText(r.getName());
				infoLabel.setText(r.getInfo());
				recipeImage.setImage(r.getImage());
				for( Entry<Product, String> entry: r.getIngredients().entrySet()){
					items.add(entry.getValue());
				}
				for(String i : r.getInstruction()){
					instruction.add(i);
				}
				ingredientsList.setItems(items);
				instructionList.setItems(instruction);
				descriptionText.setText(r.getDescription());
			}
		}
	}
	
	public void addToCartEvent(ActionEvent e){
		for(Recipe r: recipes){
			if(nameLabel.getText().equals(r.getName())){
				for(Entry<Product, String> entry: r.getIngredients().entrySet()){
					ControllerMain.addProductToCart(entry.getKey(), 1);
				}
			}
		}
	}
}
