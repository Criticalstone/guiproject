package guiProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import se.chalmers.ait.dat215.project.Product;
import guiProject.interfaces.IFStarList;

public class StarList implements IFStarList{


	HashMap<Product, Integer> productList;
	String name;
	
	public StarList(String name){
		this.name=name;
	}
	
	@Override
	public void increaseQtyOfProduct(Product p, int qty) {
		if (productList.containsKey(p)){
			productList.put(p, productList.get(p)+qty);
		}
		else productList.put(p, qty);
		
	}

	@Override
	public void reduceQtyOfProduct(Product p, int qty) {
		if (productList.containsKey(p) && productList.get(p)> qty){
			productList.put(p, productList.get(p)-qty);
		} else if (productList.containsKey(p)){
			productList.put(p, 0);
		}
		
	}

	@Override
	public void addProduct(Product p, int qty) {
		productList.put(p, qty);
		
	}

	@Override
	public void removeProduct(Product p) {
		productList.remove(p);
		
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
		return 0;
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

	@Override
	public List<Product> getStaredProducts() {
		List<Product> toReturn = new ArrayList<Product>(productList.keySet());
		return toReturn;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8665428642080036392L;
}
