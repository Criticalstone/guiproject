package guiProject;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class DeliveryView extends GridPane {
	
	@FXML
	private ChoiceBox<String> shop;
	@FXML
	private DatePicker deliveryDate;
	@FXML
	private ToggleGroup group;

	public DeliveryView(){
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
             "fxml/DeliveryView.fxml"));

		 fxmlLoader.setController(this);
		 fxmlLoader.setRoot(this);

		 try {
			 fxmlLoader.load();
		 } catch (IOException exception) {
			 throw new RuntimeException(exception);
		 }
		 
		 setShopChoice();
	}
	
	private void setShopChoice(){
		shop.setItems(FXCollections.observableArrayList("Göteborg", "Stockholm", "Malmö"));
	}
	
	public String getShop(){
		return shop.toString();
	}
	
	public String getDeliveryDate(){
		return deliveryDate.toString();
		
	}
	
	
	
	
	
}
