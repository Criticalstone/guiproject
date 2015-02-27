package guiProject;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import guiProject.interfaces.IFStarList;

public class StarList implements IFStarList{

	private static final long serialVersionUID = -8665428642080036392L;
	List<Product> productList;
	String name;
	IMatDataHandler imat;
	
	public StarList(){
		this.name="Star";
		productList = new ArrayList<Product>();
		imat = IMatDataHandler.getInstance();
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
	public boolean containProduct(Product p) {
		return productList.contains(p);
	}



	@Override
	public String getName() {
		return name;
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
