package guiProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        primaryStage.setTitle("iMat");

        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("T1"); tab1.setContent(new Rectangle(200, 200, Color.LIGHTGREEN));
        Tab tab2 = new Tab("T2"); tab2.setContent(new Rectangle(200, 200, Color.LIGHTSTEELBLUE));
        tabPane.getTabs().addAll(tab1, tab2);
        tabPane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        // layout the stage.
        StackPane layout = new StackPane();
        layout.getChildren().add(tabPane);
        layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("/res/sample.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
