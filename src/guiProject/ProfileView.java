package guiProject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.swing.Timer;

import Archive.TestFileChooser;

/**
 * Created by kritt on 2015-03-03.
 */
public class ProfileView extends GridPane{
	
	private UserProfile profile;
	@FXML
	private Label labelName;
	//User info fields
    @FXML
    private TextField textFirstName;
    @FXML
    private TextField textLastName;
    @FXML
    private TextField textAdress;
    @FXML
    private TextField textPostalCode;
    @FXML
    private TextField textTown;
    @FXML
    private TextField textTel;
    @FXML
    private TextField textEmail;
    @SuppressWarnings("rawtypes")
	@FXML
    private ChoiceBox comboPaymentOpt;
    @FXML
    private CheckBox checkCardSave;
    
    //Card info
    @SuppressWarnings("rawtypes")
	@FXML
    private ChoiceBox comboCard;
    @FXML
    private TextField textNum1;
    @FXML
    private TextField textNum2;
    @FXML
    private TextField textNum3;
    @FXML
    private TextField textNum4;
    @FXML
    private TextField textExpir1;
    @FXML
    private TextField textExpir2;
    @FXML
    private TextField textCardName;
    @FXML
    private TextField textCVC;
    
    @FXML
    private Button buttonSave;
    @FXML
    private VBox changePasswordBox;
    @FXML
    private PasswordField currentPassword;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField repeatPassword;
    @FXML
    private Label wrongMessage;
    @FXML
    private Label correctMessage;
    @FXML
    private CheckBox deleteProfile;
    @FXML
    private Button deleteProfileButton;
    @FXML
    private Label profileSavedMessage;
    @FXML 
    private IntegerTextField test;
//    @FXML
//    private ImageView profileImage;
	
    public ProfileView(UserProfile user) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/ProfileView.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        test.setMaxLength(2);
          this.profile = user;
          correctMessage.setVisible(false);
          profileSavedMessage.setVisible(false);
          setupChoiceBoxes();
          loadInfo();
    }


    @SuppressWarnings("unchecked")
	private void setupChoiceBoxes() {
    	comboPaymentOpt.setItems(FXCollections.observableArrayList("","Kredit-/Kontokort", "PayPal", "Direktbank", "Faktura"));
    	comboCard.setItems(FXCollections.observableArrayList("","MasterCard", "Visa", "Maestro"));
		
	}

	@FXML
    private void saveOnAction(ActionEvent event){
        setInfoToCustomer();
        labelName.setText(profile.getFirstName() + " " + profile.getLastName());
        ControllerMain.getLogInView().setLoggedInStatus(true);
        profileSavedMessage.setVisible(true);
    }

    @SuppressWarnings("unchecked")
	public void loadInfo(){
  
	    	labelName.setText(profile.getFirstName() + " " + profile.getLastName());;
	    	//User info fields
	    	textFirstName.setText(profile.getFirstName());;
	    	textLastName.setText(profile.getLastName());;
	    	textAdress.setText(profile.getAdress());;
	    	textPostalCode.setText(profile.getPostalCode());
	    	textTown.setText(profile.getTown());
	    	textTel.setText(profile.getPhone());
	    	textEmail.setText(profile.getEmail());;
	    	comboPaymentOpt.setValue(profile.getPaymentOption());
	        
	        //Card info
	    	comboCard.setValue(profile.getCard().getCardType());
	    	if(profile.getCard().getCardNo().length()==16){
	    		textNum1.setText(profile.getCard().getCardNo().substring(0, 3));
		    	textNum2.setText(profile.getCard().getCardNo().substring(4, 7));
		    	textNum3.setText(profile.getCard().getCardNo().substring(8, 11));
		    	textNum4.setText(profile.getCard().getCardNo().substring(12, 16));
	    	}
	    	textExpir1.setText(profile.getCard().getExpiryYear());
	    	textExpir2.setText(profile.getCard().getExpiryMonth());
	    	textCardName.setText(profile.getCard().getCardHolder());
	    	textCVC.setText(profile.getCard().getCvc());
	    	
	    	
	//        Customer customer = ControllerMain.getCustomer();
	//        textName.setText(customer.getFirstName() + " " + customer.getLastName());
	//        System.out.println(customer.getLastName());
	//        textAdress.setText(customer.getAddress());
	//        textPostalCode.setText(customer.getPostCode());
	//        textPostal.setText(customer.getPostAddress());
	//        textTel.setText(customer.getMobilePhoneNumber());
	//        textEmail.setText(customer.getEmail());
	    	
	    	
   
    }

    @SuppressWarnings("unchecked")
	public void setInfoToCustomer(){
	    	profile.setFirstName(textFirstName.getText());
	    	profile.setLastName(textLastName.getText());
	    	profile.setAdress(textAdress.getText());
	    	profile.setPostalCode(textPostalCode.getText());
	    	profile.setTown(textTown.getText());
	    	profile.setPhone(textTel.getText());
	    	profile.setEmail(textEmail.getText());
	    	profile.setPaymentOption(comboPaymentOpt.getValue().toString());
	    	
	    	if(checkCardSave.isSelected()){
	    		profile.setCard(new CreditCard((String)comboCard.getValue(), (textNum1.getText()+textNum2.getText()+textNum3.getText()+textNum4.getText()), textCardName.getText(), textExpir1.getText(), textExpir2.getText(), textCVC.getText()));
	    	}
	    	
	    	Utilities.SaveToFile(profile, null, profile.getUsername());
	    	
	    	
	    	
	    	
	    	
	//        Customer customer = ControllerMain.getCustomer();
	//        customer.setFirstName(textFirstName.getText());
	//        customer.setLastName(textLastName.getText().);
	//        customer.setAddress(textAdress.getText());
	//        customer.setPostCode(textPostalCode.getText());
	//        customer.setPostAddress(textPostal.getText());
	//        customer.setMobilePhoneNumber(textTel.getText());
	//        customer.setEmail(textEmail.getText());
    	
    }
    
    @FXML
    public void ChangePasswordOnAction(){
    	if(changePasswordBox.isVisible()){
    		cleanBox();
    	}else{
    		changePasswordBox.setVisible(true);
    	}
    }

    
    @FXML
    public void SavePasswordOnAction(){
    	if(profile.getPassword().equals(currentPassword.getText()) && newPassword.getText().equals(repeatPassword.getText())&& repeatPassword.getText().length()!=0 ){ /*kontotslösenord jämförs med inskrivet nuvarande lösenord && nyttlösenord jämförs med upprepat lösenord(ser om samma)*/
    		if(profile.getPassword().equals(newPassword.getText())){
    			wrongMessage.setText("*Samma lösenord som innan");
        		wrongMessage.setVisible(true);
    		}else{
    			correctMessage.setVisible(true);  //få bort texten?
    			profile.setPassword(newPassword.getText());
    			cleanBox();
    			Utilities.SaveToFile(profile, null, profile.getUsername());       /*sparar ner det nya lösenordet. Rutan försvinner och en liten text kommer upp att det är genomfört(försvinner seda)*/
    		}
    	}else if(!profile.getPassword().equals(currentPassword.getText())){/*om kontolösenord och nuvarande lösenord ej överstämmer*/
    		wrongMessage.setText("*Ej korrekt nuvarande lösenord");
    		wrongMessage.setVisible(true);  /*sätter upp en label som står att det är ej korrekt nuvarande lösenord*/		
    	}else if(repeatPassword.getText().length()==0 && newPassword.getText().length()==0){  /*något av de två sista fälten är tomma*/
    		wrongMessage.setText("*Skriv in ett nytt lösenord");
    		wrongMessage.setVisible(true); /*du måste skriva in ett nytt lösenord*/
    	}else{
    		wrongMessage.setText("*Nya lösenord ej samma"); /*sätter upp en label, nya lösenordet överstämmer inte*/
    	}
    }
    
    public void cleanBox(){
    	changePasswordBox.setVisible(false);
    	currentPassword.clear();
    	newPassword.clear();
    	repeatPassword.clear();
    	wrongMessage.setVisible(false);
    }
    
    @FXML
    public void DeleteProfilOnAction(){
    	Utilities.DeleteSpecificProfil(null, ControllerMain.getUser().getUsername());
    	ControllerMain.getLogInView().setLoggedInStatus(false);
    	ControllerMain.getBanner().setTextToLoggedIn();
    	ControllerMain.displayLoginView("");	
    }
    
    @FXML
    public void ActivateDeleteProfile(){
    	if(deleteProfile.isSelected()){
    		deleteProfileButton.setDisable(false);
    	}else{
    		deleteProfileButton.setDisable(true);
    	}
    }
    
    
    @FXML 
    public void RegretOnAction(){
    	loadInfo();	
    }
    
//    @FXML  //Användes för att försöka ladda upp profilbild
//    public void ChangeProfileOnAction(){
//    	Stage stage = new Stage();
//    	TestFileChooser file= new TestFileChooser();
//    	file.start(stage);	
//    }
    
//    public void setProfileImage(File file){  	
//    	try{
//    		Image me=ControllerMain.getUser().getImage();
////    		Image me = new Image(" file:// " + file.toString());
//    		profileImage.setImage(me);
//    	}catch (NullPointerException ex){
//    		System.out.println("Fel2");
//    	}
//    }
}
