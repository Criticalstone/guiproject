package guiProject;


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


public class ControllerProductList extends ScrollPane implements IFControllerProductList{

	@FXML
	private TilePane tilePaneResultArea;
	
	public ControllerProductList(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/ViewProductResultList.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        setStyle("-fx-background-color: blue");
        
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        
	}

	@Override
	public void setItems(List<Product> p) {
		clearPane();
		addItems(p);
    }

	private void clearPane() {
		tilePaneResultArea.getChildren().removeAll(tilePaneResultArea.getChildren());
		
	}

	private void addItems(List<Product> p){
		List<ControllerProductCardPane> listOfCards = new ArrayList<ControllerProductCardPane>();
		for (Product product: p){
			listOfCards.add(new ControllerProductCardPane(product));
		}
		
		Collections.sort(listOfCards, new ComparatorProductCard());
        for (ControllerProductCardPane card: listOfCards) {
            tilePaneResultArea.getChildren().add(card);
        }
        
	}


	@Override
	public void updateQtyInCartForAllCards() {
		List<Node> displayedCards = tilePaneResultArea.getChildren();
		for (int i = 0; i < displayedCards.size(); i++){
			Node temp = displayedCards.get(i);
			IFProductCard card = (IFProductCard)temp;
			card.updateQtyInCart();
		}

	}


	@Override
	public void updateQtyInCartForCard(Product p) {
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
