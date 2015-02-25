package guiProject;

import java.io.IOException;

import se.chalmers.ait.dat215.project.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ControllerDetailedCard{
	
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
	private Button buttonStarred;
	@FXML
	private Button buttonAddToList;
	@FXML
	private TextField textFieldQty;
	
	
	public ControllerDetailedCard(Product p){
		this.product = p;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "DetailedProductView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        setDescription();
        setIngrediens();
        setName();
        setSize();
        setImage();
        setPrice();
	}
	
	
	private void setIngrediens() {
		// TODO Auto-generated method stub
		
	}


	private void setDescription() {
		// TODO Auto-generated method stub
		
	}


	private void setSize() {
		// TODO Auto-generated method stub
		
	}


	private void setName() {
		// TODO Auto-generated method stub
		
	}


	private void setPrice() {
		// TODO Auto-generated method stub
		
	}


	private void setImage() {
		// TODO Auto-generated method stub
		
	}

	@FXML
	private void handleButtonAction() {
		textFieldQty.setText("6");
		//int quantity=Integer.parseInt(textFieldQty.getText())-1;
		//textFieldQty.appendText(Integer.toString(quantity));
	}

}
