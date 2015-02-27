package guiProject;


import guiProject.interfaces.IFControllerProductList;
import guiProject.interfaces.IFProductCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.TilePane;
import se.chalmers.ait.dat215.project.Product;
import javafx.scene.control.ScrollPane;

/**
 * The result area in which the products are displayed.
 * @author Anton
 *
 */
public class ControllerResultList extends ScrollPane implements IFControllerProductList{

	@FXML
	private TilePane tilePaneResultArea;
	
	/**
	 * Constructor for the result list. Will setup the FXML only.
	 */
	public ControllerResultList(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/ViewProductResultList.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        
	}

	@Override
	public void setItems(List<Product> p) {
		clearPane();
		addCards(createSortedCardsAZ(p));
		
    }

	//Removes all product cards from the pane.
	private void clearPane() {
		tilePaneResultArea.getChildren().removeAll(tilePaneResultArea.getChildren());
		
	}

	//Internal method to add cards to the display area.
	private void addCards(List<ControllerProductCardPane> listOfCards){
        for (ControllerProductCardPane card: listOfCards) {
            tilePaneResultArea.getChildren().add(card);
        }
        
	}
	//Internal method the takes a list of products and returns a sorted list of cards.
	private List<ControllerProductCardPane> createSortedCardsAZ(List<Product> p){
		List<ControllerProductCardPane> listOfCards = new ArrayList<ControllerProductCardPane>();
		for (Product product: p){
			listOfCards.add(new ControllerProductCardPane(product));
		}
		
		Collections.sort(listOfCards, new ComparatorProductCard());
		return listOfCards;
	}


	@Override
	public void updateQtyInCartForAllCards() {
		//Cycle through all cards and tells all of them to update the displayed qty.
		List<Node> displayedCards = tilePaneResultArea.getChildren();
		for (int i = 0; i < displayedCards.size(); i++){
			Node temp = displayedCards.get(i);
			IFProductCard card = (IFProductCard)temp;
			card.updateQtyInCart();
		}

	}


	@Override
	public void updateQtyInCartForCard(Product p) {
		//Cycles through all cards and asks on those displaying the specified item to refresh.
		List<Node> displayedCards = tilePaneResultArea.getChildren();
		for (int i = 0; i < displayedCards.size(); i++){
			Node temp = displayedCards.get(i);
			IFProductCard card = (IFProductCard)temp;
			if (card.getProduct().equals(p)){
				card.updateQtyInCart();
			}
		}
		
	}
}
