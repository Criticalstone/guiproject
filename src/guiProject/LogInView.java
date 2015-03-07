package guiProject;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LogInView extends GridPane {
	@FXML
	private VBox logInBox;
	@FXML 
	private PasswordField password;
	@FXML
	private Label wrongPassword;
	@FXML
	private Label username;
	
	private UserProfile user;
	
	private boolean isLoggedIn=false;
	
	private String nameNextSide;
	
	public LogInView(String userName ,String sidename){
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
        "fxml/LogInBox.fxml"));

		  fxmlLoader.setController(this);
		  fxmlLoader.setRoot(this);

		  try {
			  fxmlLoader.load();
		  } catch (IOException exception) {
			  throw new RuntimeException(exception);
		  }
		 
		  nameNextSide=sidename;
		  this.username.setText(userName);
		  logInBox.setVisible(false);
	}
	
	@FXML
	public void LoginOnAction(){
			user = (UserProfile)Utilities.LoadFile(null, username.getText());
			if(password.getText().equals(user.getPassword())){
				ControllerMain.setUser(user);
				ControllerMain.getLogInView().setLoggedInStatus(true);
				ControllerMain.getBanner().setUsernameLabel();
				ControllerMain.getBanner().setTextToLoggedIn();
				
				if(nameNextSide.equals("favorite")){
					ControllerMain.setProductList(ControllerMain.getStaredProducts());
    				ControllerMain.unSelectCategories();
    				ControllerMain.getBanner().setBanner("start");
				}else if(nameNextSide.equals("list")){
					ControllerMain.displayShoppingListView();
				}else if(nameNextSide.equals("recept")){
					ControllerMain.displayRecipeView();
				}else{
					ControllerMain.displayProfile(user);
				}
			}else{
				wrongPassword.setText("*Fel lösenord!");
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
	
	
	public void setLoggedInStatus(boolean value){
	    isLoggedIn=value;
	}
	    
	public boolean getLoggedInStatus(){
		return isLoggedIn;
	}
	
}
