
/**
 * Kod tagen 
 * från http://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
 */


package Archive;

import guiProject.ControllerMain;

import java.io.File;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
public final class TestFileChooser extends Application {
 
    public void start(Stage stage){
        stage.setTitle("File Chooser Sample");
 
        FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            System.out.println(file.getName());   
            Image im= new Image(file.getName());
            System.out.println(im);
//            ControllerMain.getUser().setImage(im);
        }
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
    
      private static void configureFileChooser(final FileChooser fileChooser){                           
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
            new File(System.getProperty("user.home"))
        ); 
    }     
}