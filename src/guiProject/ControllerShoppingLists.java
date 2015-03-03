package guiProject;

import guiProject.interfaces.IFProductList;
import guiProject.interfaces.IFStarList;

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
    private static List<IFProductList> favoriteLists;
    private static IFStarList starList = new StarList();
    private static ControllerShoppingLists singleton;
   
    private ControllerShoppingLists(){
    	favoriteLists = new ArrayList<IFProductList>();
    }
    
    public static synchronized ControllerShoppingLists getInstance(){
    	if (singleton == null){
    		singleton = new ControllerShoppingLists();
 
    	}
    	return singleton;
    }

	
	public List<Product> getStaredProducts(){
		return starList.getProducts();
	}
	
	public boolean isStared(Product p){
		return starList.containProduct(p);
	}
	
	public void starProduct(Product p, boolean toggle){
		if (starList.containProduct(p) && !toggle){
			starList.removeProduct(p);
		} else if (!starList.containProduct(p) && toggle){
			starList.addProduct(p);
		}
	}
	
	public List<IFProductList> getFavoriteLists(){
		return favoriteLists;
	}
	
	public void addFavoriteList(String name){
		favoriteLists.add(new SavedShoppingList(name));
	}
	

	
	

}
