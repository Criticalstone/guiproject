package guiProject.interfaces;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import se.chalmers.ait.dat215.project.Product;
/**
 * Master interface for all product lists.
 * @author Anton
 *
 */
public interface IFProductList extends Serializable{
	/**
	 * Adds a product to the list. 
	 * @param p The product to add
	 * @param qty The Quantity to be set to the product.
	 */
	public void addProduct(Product p);
	/**
	 * Adds a list of products to the product list.
	 * @param products The products to be added.
	 */
	public void addList(List<Product> products);
	/**
	 * Removes a product for the list. If the product doesn't exist this method does nothing.
	 * @param p The product to remove.
	 */
	public void removeProduct(Product p);
	/**
	 * Remove a list of products from the list.
	 * @param products to remove.
	 */
	public void removeProductList(List<Product> products);
	/**
	 * Checks if the product exist in the list.
	 * @param p The product to look for.
	 * @return Returns true if the item exist, return false if the item do not exist in the list.
	 */
	public boolean containProduct(Product p);
	
	/**
	 * Returns a list of all the products.
	 * @return A list of all the products in the list.
	 */
	public List<Product> getProducts();
	
	/**
	 * Returns the name of the list.
	 * @return The name of the list as a String.
	 */
	public String getName();
}
