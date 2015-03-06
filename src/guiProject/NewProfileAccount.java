package guiProject;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class NewProfileAccount extends GridPane{

	private int count=0;
	@FXML
	private PasswordField firstPassword;
	@FXML
	private PasswordField secondPassword;
	@FXML
	private TextField name;
	@FXML 
	private Label wrongMessage;
	
	public NewProfileAccount(){
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
          "fxml/NewProfileAccount.fxml"));

		  fxmlLoader.setController(this);
		  fxmlLoader.setRoot(this);

		  try {
			  fxmlLoader.load();
		  } catch (IOException exception) {
			  throw new RuntimeException(exception);
		  }
	}
	
	
	@FXML
	public void ButtonCreateNewAccount(){
			if(getPassword().equals(secondPassword.getText()) && !getPassword().equals("")){
				if(count<3){
					TestMain.createLogInBox(name.getText());
					clean();
					count=count+1;
				}else{
					wrongMessage.setText("*Kan ej ha fler konton");
					wrongMessage.setVisible(true);
				}
			}else if(getPassword().equals("")){
				wrongMessage.setText("*Inget lösenord inskrivet");
				wrongMessage.setVisible(true);
			}else{
				wrongMessage.setText("*Ej samma lösenord");
				wrongMessage.setVisible(true);
			}
	
		
	}
	
	public String getPassword(){
		return firstPassword.getText();
	}
	
	public String getUserName(){
		return name.getText();
	}
	
	public void clean(){
		name.clear();
		firstPassword.clear();
		secondPassword.clear();
		wrongMessage.setVisible(false);
	}
}
