package guiProject.interfaces;

import se.chalmers.ait.dat215.project.Product;

public interface IFProductCard extends Comparable<IFProductCard>{
	
	/**
	 * 
	 * @return The product that the card is displaying. (NOT CLONED)
	 */
	public Product getProduct();
	
	/**
	 * Force the card to update the qty in the cart displayed on the card.
	 */
	public void updateQtyInCart();
	
	public void updateShoppingLists();
	
}
