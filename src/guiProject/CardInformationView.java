package guiProject;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CardInformationView extends GridPane {
	
	@FXML
	private ChoiceBox<String> cardType;
	@FXML
	private IntegerTextField cardNo1;
	@FXML
	private IntegerTextField cardNo2;
	@FXML
	private IntegerTextField cardNo3;
	@FXML
	private IntegerTextField cardNo4;
	@FXML
	private IntegerTextField dateYear;
	@FXML
	private IntegerTextField dateMonth;
	@FXML
	private TextField cardholder;
	@FXML
	private IntegerTextField cvc;

	

	
	public CardInformationView(){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/cardInformationView.fxml"));

		fxmlLoader.setController(this);
		fxmlLoader.setRoot(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
			setCardType();	
			setLengthOfTextFields();
			
	}

	private void setLengthOfTextFields() {
		cardNo1.setMaxLength(4);
		cardNo2.setMaxLength(4);
		cardNo3.setMaxLength(4);
		cardNo4.setMaxLength(4);
		dateYear.setMaxLength(2);
		dateMonth.setMaxLength(2);
		cvc.setMaxLength(3);
		
	}

	public void setCardType() {
		cardType.setItems(FXCollections.observableArrayList("MasterCard", "Visa", "Maestro"));
	}
  
	public String getcardNumber(){
		return cardNo1.getText() + cardNo2.getText() + cardNo3.getText()
				+ cardNo4.getText();	
	}
	
	public String getCardType(){
		return cardType.toString();
	}
	
	public String getDateYear(){
		return dateYear.getText();
	}
	
	public String getDateMonth(){
		return dateMonth.getText();
	}
	
	public String getCardholder(){
		return cardholder.getText();
	}
	
	public String getCVC(){
		return cvc.getText();
	}
}
