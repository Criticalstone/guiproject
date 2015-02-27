package guiProject;

import guiProject.interfaces.IFProductList;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;


/**
 * TheFavoriteList contains all the lists saved by the user. This object is possible to save to file for future reference.
 * @author Anton
 *
 */
public class ControllerShoppingLists implements Serializable{
	
	private static final long serialVersionUID = 3054308858388647312L;
    private List<IFProductList> favoriteLists;
    
	public ControllerShoppingLists(){
		favoriteLists = new ArrayList<IFProductList>();

		
		
	}

	//Commented out until shopping lists are implemented.
	/**
	 * Returns the products of the specified shopping list.
	 * @param name The name of the shopping list to find.
	 * @return The List of products in the shopping list.
	 */
	public List<Product> getShoppingList(String name){
		for (IFProductList list: favoriteLists){
			if (list.getName().equals(name)){
				return new ArrayList<Product>();
			}
		}
		return null;
	}
	

	
	

}
