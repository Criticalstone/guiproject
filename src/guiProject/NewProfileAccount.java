package guiProject;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class NewProfileAccount extends GridPane{

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
		if(name.getText().equals("")){
			setMessageNoName();
		}else if(firstPassword.getText().equals(secondPassword.getText())){
			if(!firstPassword.getText().equals("")){
				createUserProfile(getUserName());
			}
			setMessageNoPassword();
		}else{
			setMessageNotSame();
		}
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
	
	public void createUserProfile(String name){
			UserProfile user=new UserProfile(name, firstPassword.getText());	
			
			Utilities.SaveToFile(user, null, name);
			
			ControllerMain.setUser(user);
			ControllerMain.getLogInView().setLoggedInStatus(true);
			ControllerMain.getBanner().setTextToLoggedIn();
			ControllerMain.getBanner().setUsernameLabel();
			
			ControllerMain.displayProfile(user);
			
			clean();	
	}
	
	public void setMessageFull(){
		wrongMessage.setText("*Kan ej ha fler konton");
		wrongMessage.setVisible(true);
	}
	
	public void setMessageNoPassword(){
		wrongMessage.setText("*Inget lösenord inskrivet");
		wrongMessage.setVisible(true);
	}
	
	public void setMessageNotSame(){
		wrongMessage.setText("*Ej samma lösenord");
		wrongMessage.setVisible(true);
	}
	
	public void setMessageNoName(){
		wrongMessage.setText("*Inget namn inskrivet");
		wrongMessage.setVisible(true);
	}
}
