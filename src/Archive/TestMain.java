package Archive;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import guiProject.CreateNewProfile;
import guiProject.LogInView;
import guiProject.Utilities;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestMain {
	
	  @FXML
	   private static HBox hBox;
	  
	public static void main(String[] args){
	
		deleteFiles();
	}
	

	
	public static List<String> getSavedFiles(String path){
		List<String> toReturn = new ArrayList<String>();
		if (path == null){
			new File(System.getProperty("user.home") + "/.dat215/savedFilesGrp24").mkdirs();
			path = System.getProperty("user.home") + "/.dat215/savedFilesGrp24";
		}
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

	    for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				toReturn.add(listOfFiles[i].getName());
			} 
	    }
	    return toReturn;
	}
	
	public static void deleteFiles(){
		List<String> list = getSavedFiles(null); 
		for(int i=0; i<=getSavedFiles(null).size(); i++){
			File file=new File(System.getProperty("user.home") + "/.dat215/savedFilesGrp24" +"/" + list.get(i));
			file.delete();
		}
	}
	
		
	}

