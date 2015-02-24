package guiProject;


import se.chalmers.ait.dat215.project.IMatDataHandler;
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
        Pane detailsPane = (Pane) scene.lookup("#centerPane");
        ControllerProductList productList = new ControllerProductList();
        productList.addItem(IMatDataHandler.getInstance().getProduct(43));
        detailsPane.getChildren().add(productList);
        
        //Setup test for banner
        Pane bannerPane = (Pane) scene.lookup("#bannerPane");
        bannerPane.getChildren().add(new Banner());
        
        //Setup test for shoppingcart
        Pane shoppingCartPane = (Pane) scene.lookup("#shoppingCartPane");
        shoppingCartPane.getChildren().add(new ShoppingCart());

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
