package guiProject;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import javafx.scene.layout.AnchorPane;

public class ProductCardEaches extends AnchorPane implements ProductCardIF{
	
	
	public ProductCardEaches(Product p){
		ProductCardController controller = new ProductCardController();
		
	}
	
	public static void main(String[] args){
		IMatDataHandler imat = IMatDataHandler.getInstance();
		new ProductCardEaches(imat.getProduct(1));
		
		
	}
}
