package guiProject;

import java.awt.Dimension;
import java.io.IOException;

import se.chalmers.ait.dat215.project.Product;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerDetailedCard extends GridPane implements IFProductCard{
	
	Product product;
	@FXML
	private ImageView detImage;
	@FXML
	private Label detNameLabel;
	@FXML
	private Label detDescrLabel;
	@FXML
	private Label detIngLabel;
	@FXML
	private Button buttonSub;
	@FXML
	private Button buttonAdd;
	@FXML
	private Label detCostLabel;
	@FXML
	private Button buttonStarred;
	@FXML
	private Button buttonAddToList;
	@FXML
	private TextField textFieldQty;
	
	
	public ControllerDetailedCard() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/DetailedProductView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
       
        setImageCard();
        setName();
        setDescription();
        setIngrediens();
        setPrice();
	}



	private void setImageCard(){
		 detImage.setImage(Utilities.getProductImage(product, new Dimension((int)detImage.getFitWidth(), (int)detImage.getFitHeight())));
	}
	
	
	private void setName(){
		detNameLabel.setText(product.getName());
	}
	
	private void setDescription() {
		detDescrLabel.setText("God");
	}
	
	private void setIngrediens() {
		detIngLabel.setText("Pasta");
	}
	
	private void setPrice(){
		detCostLabel.setText(new Double(product.getPrice()).toString());
	}
	
	

	@FXML
	private void handleButtonAction() {
		int quantity=Integer.parseInt(textFieldQty.getText())-1;
		textFieldQty.appendText(Integer.toString(quantity));
	}

	@Override
	public Product getProduct() {
		return product;
	}
}
