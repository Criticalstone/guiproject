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
        //Main
        Parent root = FXMLLoader.load(getClass().getResource("fxml/MainView.fxml"));
        primaryStage.setTitle("iMat");

        Scene scene = new Scene(root);
        ControllerMain.initialize();

        //Categories test
        Pane categoriesPane = (Pane) scene.lookup("#categoriesView");
        categoriesPane.getChildren().add(new Categories());

        //Details view test
        Pane detailPane = (Pane) scene.lookup("#detailView");
        ControllerResultList productList = ControllerMain.getProductList();
        
        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 1; i < 30;i++){
        	products.add(IMatDataHandler.getInstance().getProduct(i));
        }
        productList.setItems(products);
        detailPane.getChildren().add(productList);

        //Setup test for banner
        Pane bannerPane = (Pane) scene.lookup("#bannerPane");
        bannerPane.getChildren().add(new Banner());
        
        //Setup test for shoppingcart
        Pane shoppingCartPane = (Pane) scene.lookup("#shoppingCartPane");

        shoppingCartPane.getChildren().add(ControllerMain.getShoppingCart());
        
        //Setup test for checkoutView
        Pane checkoutViewPane = (Pane) scene.lookup("#detailView");
        checkoutViewPane.getChildren().add(new CheckoutView());
        
        //Complete setup
        scene.getStylesheets().add("/res/sample.css");
        primaryStage.setScene(scene);


        primaryStage.show();
        

    }


    public static void main(String[] args) {

        launch(args);
    }
}
