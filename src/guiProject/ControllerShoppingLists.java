package guiProject;

import guiProject.interfaces.IFProductList;
import java.io.Serializable;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;


/**
 * TheFavoriteList contains all the lists saved by the user. This object is possible to save to file for future reference.
 * @author Anton
 *
 */
public class ControllerShoppingLists implements Serializable{
	
	private final long serialVersionUID = 3054308858388647312L;
    private HashMap<String, IFProductList<ShoppingItem>> shoppingLists;
    private IFProductList<Product> starList = new StarList();
    private static ControllerShoppingLists singleton;
    private IMatDataHandler imat;
   
    private ControllerShoppingLists(){
    	shoppingLists = new HashMap<>();
        imat = IMatDataHandler.getInstance();
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
	
	public HashMap<String, IFProductList<ShoppingItem>> getShoppingLists(){
		return shoppingLists;
	}
	
	public List<Order> getOrderHistory(){
        return imat.getOrders();
	}
	
	public void addShoppingList(String name){
		shoppingLists.put(name, new SavedShoppingList(name));
	}

    public void addProductToList(String name, ShoppingItem item){

    }

    public void addProductToList(String name, List<ShoppingItem> items){
        IFProductList<ShoppingItem> list = shoppingLists.get(name);
        list.addList(items);
    }
	

	
	

}
