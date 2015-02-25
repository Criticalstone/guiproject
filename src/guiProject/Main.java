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

        Pane categoriesPane = (Pane) scene.lookup("#categoriesView");
        categoriesPane.getChildren().add(new Categories());

        Pane detailPane = (Pane) scene.lookup("#detailView");
        ControllerProductList productList = new ControllerProductList();
        productList.addItem(IMatDataHandler.getInstance().getProduct(43));
        detailPane.getChildren().add(productList);

        //Setup test for banner
        Pane bannerPane = (Pane) scene.lookup("#bannerPane");
        bannerPane.getChildren().add(new Banner());
        
        //Setup test for shoppingcart
        Pane shoppingCartPane = (Pane) scene.lookup("#shoppingCartPane");
        shoppingCartPane.getChildren().add(new ShoppingCart());

        //Complete setup
        scene.getStylesheets().add("/res/sample.css");
        primaryStage.setScene(scene);
        ControllerMain.initialize(productList);

        primaryStage.show();
        

    }


    public static void main(String[] args) {

        launch(args);
    }
}
