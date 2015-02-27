package guiProject;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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
	 * WORK IN PROGRESS DO NOT USE!!!
	 * This method will save the specified object to a file at the specified path.
	 * @param objectToSave The Serializable object to save.
	 * @param path The path to save the object to. Will be set to default home directory if left as null.
	 */
	public void SaveToFile(Serializable objectToSave, String path, String name){
		if (path == null){
			path = System.getProperty("user.home") + "/" + name;
		}
		try{
	   
			FileOutputStream fout = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(objectToSave);
			oos.close();
			System.out.println("Done");

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
