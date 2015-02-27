package guiProject;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;


/**
 * TheFavoriteList contains all the lists saved by the user. This object is possible to save to file for future reference.
 * @author Anton
 *
 */
public class ControllerShoppingLists implements Serializable{

	//A list of all the Favorite lists
    private List<SavedShoppingList> favoriteLists;
    
	public ControllerShoppingLists(){
		favoriteLists = new ArrayList<SavedShoppingList>();
	}
	/**
	 * A default serialization of the object.
	 */
	private static final long serialVersionUID = 1L;
	
	

}
