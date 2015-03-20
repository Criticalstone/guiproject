package guiProject;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class PersonNumberView extends GridPane{
	
	@FXML
	private TextField postNumber;
	@FXML
	private IntegerTextField personNrOne;
	@FXML
	private IntegerTextField personNrTwo;
	@FXML
	private TextField name;
	@FXML
	private TextField city;
	@FXML
	private TextField adress;

	
	public PersonNumberView(){
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
            "fxml/personnumberView.fxml"));

		 fxmlLoader.setController(this);
		 fxmlLoader.setRoot(this);

		 try {
			 fxmlLoader.load();
		 } catch (IOException exception) {
			 throw new RuntimeException(exception);
		 }	 	 
	}
	
	
	public String getPostNumber(){
		return postNumber.getText();
	}
	
	public void setPostNumber(String postNumber){
		this.postNumber.setText(postNumber);
	}
	
	public String getName(){
		return name.getText();
	}
	
	public String getCity(){
		return city.getText();
	}
	
	public String getAdress(){
		return adress.getText();
	}
}
