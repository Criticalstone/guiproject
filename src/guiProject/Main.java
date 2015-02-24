package guiProject;


import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ViewProductResultList.fxml"));

        Scene scene = new Scene(root);
        
        AnchorPane pane = (AnchorPane) scene.lookup("#paneResultList");


        pane.getChildren().add(new ControllerProductCardPane(IMatDataHandler.getInstance().getProduct(43)));

        
        primaryStage.setTitle("iMat");
        primaryStage.setScene(scene);
        primaryStage.show();
        

    }


    public static void main(String[] args) {

        launch(args);
    }
}
