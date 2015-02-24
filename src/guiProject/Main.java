package guiProject;

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
        Pane categoriesPane = (Pane) scene.lookup("#categories");
        categoriesPane.getChildren().add(new Categories());

        scene.getStylesheets().add("/res/sample.css");

        primaryStage.setScene(scene);
        ControllerMain.initialize();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
