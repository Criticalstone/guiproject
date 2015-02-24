package guiProject;


import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainView.fxml"));

        Scene scene = new Scene(root);
        
        Pane pane = (Pane) scene.lookup("#centerPane");
        ControllerProductList productList = new ControllerProductList();
        

        productList.addItem(IMatDataHandler.getInstance().getProduct(43));

        pane.getChildren().add(productList);

        
        primaryStage.setTitle("iMat");
        primaryStage.setScene(scene);
        primaryStage.show();
        

    }


    public static void main(String[] args) {

        launch(args);
    }
}
