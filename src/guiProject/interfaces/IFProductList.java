package guiProject.interfaces;

import java.io.Serializable;
import java.util.HashMap;

import se.chalmers.ait.dat215.project.Product;
/**
 * Master interface for all product lists.
 * @author Anton
 *
 */
public interface IFProductList extends Serializable{
	/**
	 * Adds a quantity to the list. If the product did not exist on the list, it will be added.
	 * @param p The product which should be added/increased.
	 * @param qty The quantity to increase the item with. If item did not exist in the list, the qty of the item will be set to this qty. Should be a positive value. 
	 */
	public void increaseQtyOfProduct(Product p, int qty);
	/**
	 * Reduces the quantity of a product in the list. If the remaining qty is < 0 the qty will be set to 0.
	 * @param p The product to be reduced
	 * @param qty The quantity to 
	 */
	public void reduceQtyOfProduct(Product p, int qty);
	/**
	 * Adds a product to the list. If the item already existed the qty of the item will be set to the defiend qty.
	 * @param p The product to add
	 * @param qty The Quantity to be set to the product.
	 */
	public void addProduct(Product p, int qty);
	/**
	 * Removes a product for the list. If the product doesn't exist this method does nothing.
	 * @param p The product to remove.
	 */
	public void removeProduct(Product p);
	/**
	 * Checks if the product exist in the list.
	 * @param p The product to look for.
	 * @return Returns true if the item exist, return false if the item do not exist in the list.
	 */
	public boolean containProduct(Product p);
	/**
	 * Returns the qty of the product. If the product does not exist, this method returns 0.
	 * @param p The product to query for the qty.
	 * @return The quantity specified on the item in the list, or 0 if the item does not exist.
	 */
	public int getQtyOfProduct(Product p);
	/**
	 * Returns a list of all the products and their quantities.
	 * @return Map of all the items and their quantities.
	 */
	public HashMap<Product, Integer> getProducts();
	public String getName();
}
