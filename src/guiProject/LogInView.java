package guiProject;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class LogInView extends GridPane {
	@FXML
	private VBox logInBox;
	@FXML 
	private PasswordField password;
	@FXML
	private Label wrongPassword;
	@FXML
	private Label username;
	private String userPassword;
	
	public LogInView(String userName, String userPassword){
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
        "fxml/LogInBox.fxml"));

		  fxmlLoader.setController(this);
		  fxmlLoader.setRoot(this);

		  try {
			  fxmlLoader.load();
		  } catch (IOException exception) {
			  throw new RuntimeException(exception);
		  }
		  this.userPassword=userPassword;
		  this.username.setText(userName);
	}
	
	@FXML
	public void LoginOnAction(){
		if(password.getText().equals(this.userPassword)){
			//Skickas till NextView så det visas
		}else{
			wrongPassword.setVisible(true);
		}
		
	}
	
	@FXML
	public void ButtonLogIn(){
		if(logInBox.isVisible()){
			logInBox.setVisible(false);
		}else{
			logInBox.setVisible(true);
		}
	}
}
