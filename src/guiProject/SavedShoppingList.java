package guiProject;

import guiProject.interfaces.IFShoppingList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import se.chalmers.ait.dat215.project.Product;

public class SavedShoppingList implements IFShoppingList{

	private static final long serialVersionUID = -4789214486011266428L;
	private List<Product> productList;
	private String name;
	
	public SavedShoppingList(String name){
		this.name = name;
		productList = new ArrayList<Product>();
	}


	@Override
	public boolean containProduct(Product p) {
		return productList.contains(p);
	}



	@Override
	public String getName() {
		return name;
	}
	


	@Override
	public void addProduct(Product p) {
		productList.add(p);
		
	}

	@Override
	public void removeProduct(Product p) {
		productList.remove(p);
		
	}

	@Override
	public List<Product> getProducts() {
		return new ArrayList<Product>(productList);
	}


	@Override
	public void addList(List<Product> products) {
		productList.addAll(products);
		
	}


	@Override
	public void removeProductList(List<Product> products) {
		productList.removeAll(products);
		
	}
	
}
