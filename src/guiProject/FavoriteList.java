package guiProject;

import guiProject.interfaces.IFFavoriteList;

import java.util.HashMap;

import se.chalmers.ait.dat215.project.Product;

public class FavoriteList implements IFFavoriteList{

	private HashMap<Product, Integer> productList;
	private String name;
	
	public FavoriteList(String name){
		this.name = name;
		productList = new HashMap<Product, Integer>();
	}

	@Override
	public void increaseQtyOfProduct(Product p, int qty) {
		if (containProduct(p)){
			productList.put(p, productList.get(p)+qty);
		}
		else {
			productList.put(p, qty);
		}
		
	}

	@Override
	public void reduceQtyOfProduct(Product p, int qty) {
		if (containProduct(p) && productList.get(p) <= qty){
			productList.remove(p);
		} else if (containProduct(p) && productList.get(p) > qty){
			productList.put(p, productList.get(p)-qty);
		}
		
	}

	@Override
	public boolean containProduct(Product p) {
		return productList.containsKey(p);
	}

	@Override
	public int getQtyOfProduct(Product p) {
		if (containProduct(p)){
			return productList.get(p);
		}
		else return 0;

	}

	@Override
	public HashMap<Product, Integer> getProducts() {
		HashMap<Product, Integer> toReturn = new HashMap<Product, Integer>(productList);
		return toReturn;
		
	}

	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4789214486011266428L;

	@Override
	public void addProduct(Product p, int qty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProduct(Product p) {
		// TODO Auto-generated method stub
		
	}
	
}
