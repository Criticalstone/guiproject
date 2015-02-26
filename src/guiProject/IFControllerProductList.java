package guiProject;

import java.util.List;

import se.chalmers.ait.dat215.project.Product;

public interface IFControllerProductList {
	/**
	 * This method tells the area which products should be displayed as results.
	 * @param p A list of products that should be displayed.
	 */
	public void setItems(List<Product> p);
	/**
	 * This method tells all displayed cards to refresh the qty displayed on the cards to the current value. 
	 * Typically used when loading a shopping list, or emptying the cart.
	 */
	public void updateQtyInCartForAllCards();
	/**
	 * This method tells all cards containing the specific product to update the qty. 
	 * Typically used when updating a single item in the shopping cart.
	 * @param p The product for which all cards should update.
	 */
	public void updateQtyInCartForCard(Product p);
}
