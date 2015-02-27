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
	private TextField cardNumberOne;
	@FXML
	private TextField cardNumberTwo;
	@FXML
	private TextField cardNumberThree;
	@FXML
	private TextField cardNumberFour;
	@FXML
	private TextField dateYear;
	@FXML
	private TextField dateMonth;
	@FXML
	private TextField cardholder;
	@FXML
	private TextField cvc;
	

	
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
	}

	public void setCardType() {
		cardType.setItems(FXCollections.observableArrayList("MasterCard", "Visa", "Maestro"));
	}
  
	public String getcardNumber(){
		return cardNumberOne.getText() + cardNumberTwo.getText() + cardNumberThree.getText()
				+ cardNumberFour.getText();	
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
