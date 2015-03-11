package guiProject;

import java.util.*;

import javafx.scene.image.Image;
import se.chalmers.ait.dat215.project.Product;

public class Recipe {
	
	private String name;
	private String info;
	private String imagePath;
	private Map<Product, String> ingredients;
	private String description;
	private List<String> instruction;
	
	public Recipe(String name, String info, String imagePath, Map<Product, String> ingredients, String description,
			List<String> instruction) {
		this.name = name;
		this.info = info;
		this.imagePath = imagePath;
		this.ingredients = ingredients;
		this.description = description;
		this.instruction = instruction;
	}
	
	public String getName(){
		return name;
	}
	
	public String getInfo(){
		return info;
	}
	
	public Image getImage(){
		return new Image(imagePath);
	}
	
	public Map<Product, String> getIngredients(){
		return ingredients;
	}
	
	public String getDescription(){
		return description;
	}
	
	public List<String> getInstruction(){
		return instruction;
	}

}
