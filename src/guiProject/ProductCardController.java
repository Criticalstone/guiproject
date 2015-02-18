package guiProject;

import java.awt.Dimension;

import javafx.event.Event;
import javafx.event.EventHandler;

import javax.swing.ImageIcon;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

public class ProductCardController {
	private IMatDataHandler imat;
	private EventHandler subtractButtonEH;
	private EventHandler addButtonEH;
	private EventHandler weightButtonEH;
	private EventHandler eachButtonEH;
	
	public ProductCardController(){
		 imat = IMatDataHandler.getInstance();
		 setupEH();
	}

	private void setupEH() {
		subtractButtonEH = new EventHandler(){

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				
			}
			 
		 };
		addButtonEH = new EventHandler(){

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				
			}
			 
		 };
		weightButtonEH = new EventHandler(){

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				
			}
			 
		 };
		eachButtonEH = new EventHandler(){

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				
			}
			 
		 };

	}
	
	public ImageIcon getProductImage(Product p, Dimension d){
		return imat.getImageIcon(p, d);
	}
	
	public String getProductName(Product p){
		return p.getName();
	}
	
	public String getProductPrice(Product p){
		
	}
	public String getProductAvPrice(Product p){
		
	}
	public EventHandler getSubEH(){
		return subtractButtonEH;
	}
	
}
