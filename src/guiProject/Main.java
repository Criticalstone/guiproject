package guiProject;


import java.util.ArrayList;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        primaryStage.setTitle("iMat");

        Scene scene = new Scene(root);
        //Category test setup 
        Pane categoriesPane = (Pane) scene.lookup("#categories");
        categoriesPane.getChildren().add(new Categories());
        
        //Setup test for details
        Pane pane = (Pane) scene.lookup("#centerPane");
        ControllerProductList productList = new ControllerProductList();
        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 1; i < 30;i++){
        	products.add(IMatDataHandler.getInstance().getProduct(i));
        }

        
        
        
        productList.addItem(products);
        pane.getChildren().add(productList);

        //Complete setup
        scene.getStylesheets().add("/res/sample.css");
        primaryStage.setScene(scene);
        ControllerMain.initialize();

        primaryStage.show();
        

    }


    public static void main(String[] args) {

        launch(args);
    }
}
