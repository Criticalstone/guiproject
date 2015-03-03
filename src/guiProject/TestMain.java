package guiProject;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestMain extends Application {
	
	  @FXML
	   private static HBox hBox;
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
    public void start(Stage primaryStage) throws Exception{	
		//Setup FXML
		Parent root = FXMLLoader.load(getClass().getResource("fxml/TotalLogInView.fxml"));
		primaryStage.setTitle("iMat");
		Scene scene = new Scene(root);
    
    
		//Initialize main panels.
		hBox = (HBox) scene.lookup("#hBox");
		
		//hBox.getChildren().add(new LogInView());
		hBox.getChildren().add(new CreateNewProfile());
	
  		//Complete setup
  		scene.getStylesheets().add("/res/sample.css");
  		scene.getStylesheets().add("/res/CategoriesMenuItem.css");
  		primaryStage.setScene(scene);

  		primaryStage.show();
	}


}
