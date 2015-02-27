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
//    private List<IFProductList> favoriteLists;
    private static IFStarList starList = new StarList();
   

	
	public static List<Product> getStaredProducts(){
		return starList.getProducts();
	}
	
	public static boolean isStared(Product p){
		return starList.containProduct(p);
	}
	
	public static void starProduct(Product p, boolean toggle){
		if (starList.containProduct(p) && !toggle){
			starList.removeProduct(p);
		} else if (!starList.containProduct(p) && toggle){
			starList.addProduct(p);
		}
	}
	

	
	

}
