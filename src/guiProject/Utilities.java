package guiProject;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
/**
 * Utilities are a collection of methods that available all throughout the application for any method to call in order to modify it's data, such as cleaning up text fields from unwanted data.
 * @author Anton
 *
 */
public class Utilities {

	
	static IMatDataHandler iMatDH = IMatDataHandler.getInstance();
	
	public static Image getProductImage(Product p, Dimension d){
		BufferedImage img = (BufferedImage)iMatDH.getImageIcon(p, d).getImage();
		WritableImage fxImg = new WritableImage((int)d.getWidth(), (int)d.getHeight());
		SwingFXUtils.toFXImage(img, fxImg);
		return fxImg;
	}
	
	public static String zeroPaddedPrice(Double price){
		String priceString = ((Double)price).toString();
		if (priceString.indexOf(".") == priceString.length()-2){
			priceString = priceString+"0";
		}
		return priceString;
	}
	
	public static String removeAllButNumbers(String s){
		String value = s.replaceAll("[^0-9]","");
		return value;
	}
	
	/**
	 * This method will save the specified object to a file at the specified path.
	 * @param objectToSave The Serializable object to save.
	 * @param path The path to save the object to. Will be set to default home directory/.dat215/savedFilesGrp24 if left as null.
	 */
	public static void SaveToFile(Serializable objectToSave, String path, String name){
		
		if (path == null){			
			new File(System.getProperty("user.home") + "/.dat215/savedFilesGrp24").mkdirs();
			path = System.getProperty("user.home") + "/.dat215/savedFilesGrp24";
		}
		try{
	   
			FileOutputStream fout = new FileOutputStream(path + "/" + name);
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(objectToSave);
			oos.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * Loads the specified file into a Serializable object.
	 * @param path The path to the file to load
	 * @return the loaded file, or if none was found, null.
	 */
	public static Serializable LoadFile(String path, String name){
		if (path == null){
			path = System.getProperty("user.home") + "/.dat215/savedFilesGrp24";
		}
		try{
			FileInputStream fin = new FileInputStream(path + "/" + name);
			ObjectInputStream ois = new ObjectInputStream(fin);
			Object toReturn= ois.readObject();
			ois.close();
			return (Serializable)toReturn;
		}catch(Exception ex){
			return null;
		}
		
		
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
	
}
