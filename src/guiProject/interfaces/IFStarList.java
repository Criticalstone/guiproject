package guiProject.interfaces;

import java.util.List;

import se.chalmers.ait.dat215.project.Product;

public interface IFStarList extends IFProductList{
	/**
	 * Returns a list of all the products that has been set with a star.
	 * @return
	 */
	public List<Product> getStaredProducts();
	
}
