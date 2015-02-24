package guiProject;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class Utilities {
	
	static IMatDataHandler iMatDH = IMatDataHandler.getInstance();
	
	public static Image getProductImage(Product p, Dimension d){
		BufferedImage img = (BufferedImage)iMatDH.getImageIcon(p, d).getImage();
		WritableImage fxImg = new WritableImage((int)d.getWidth(), (int)d.getHeight());
		SwingFXUtils.toFXImage(img, fxImg);
		return fxImg;
	}
	
	public static String zeroPappedPrice(Double price){
		String priceString = ((Double)price).toString();
		return priceString;
	}
}
