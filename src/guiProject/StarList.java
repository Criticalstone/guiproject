package guiProject;

import java.util.ArrayList;
import java.util.List;

import guiProject.interfaces.IFProductList;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

/**
 * A list of all items set with a star. This list is also connected to the Backend.
 * @author Anton
 *
 */
public class StarList implements IFProductList<Product>{

	private static final long serialVersionUID = -8665428642080036392L;
	String name;
	IMatDataHandler imat;
	
	public StarList(){
		this.name="Star";
		imat = IMatDataHandler.getInstance();
	}


	@Override
	public void addProduct(Product p) {
		System.out.print(p.getName() + ": ");
		imat.addFavorite(p);
		
	}

	@Override
	public void removeProduct(Product p) {
		imat.removeFavorite(p);
		
	}

	@Override
	public boolean containProduct(Product p) {
		return imat.isFavorite(p);
	}



	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<Product> getProducts() {
		return new ArrayList<Product>(imat.favorites());
	}


	@Override
	public void addList(List<Product> products) {
		for (Product p: products){
			imat.addFavorite(p);
		}
		
	}


	@Override
	public void removeProductList(List<Product> products) {
		for (Product p:products){
			imat.removeFavorite(p);
		}
		
	}
	

}
