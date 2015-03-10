package guiProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControllerColorScheme implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4425502238485226987L;
	private String name;
	
    private ColorScheme currentColorScheme;
    private ObservableList<String> activeStyleSheets;
    private String defaultSheet = "/res/defaultStyleSheet.css";
    
    public enum ColorScheme {
        DARK("Dark","/res/colorSchemeDark.css"),
        BLUE("Blue","/res/colorSchemeBlue.css"),
        RED("Red","/res/colorSchemeRed.css"),
        PINK("Pink","/res/colorSchemePink.css"),
        LIGHT("Light","/res/colorSchemeLight.css");

        private String colorScheme;
        private String name;

        ColorScheme(String name, String colorScheme) {
            this.colorScheme = colorScheme;
            this.name = name;
        }

        public String getScheme() {
            return colorScheme;
        }
        
        public String toString(){
        	return name;
        }
        

    }
    
    public ControllerColorScheme(String name){
    	this.name = name;
    	setColorScheme(ColorScheme.DARK);
    	
    }
    
    public void setColorScheme(ColorScheme color){
    	List<String> styles = new ArrayList<String>();
    	styles.add(defaultSheet);
    	styles.add(color.getScheme());
    	ObservableList<String> activeStyles = FXCollections.observableArrayList(styles);
    	activeStyleSheets = activeStyles;
    	currentColorScheme = color;
    }
    
    public ObservableList<String> getColorScheme(){
    	return activeStyleSheets;
    }
    
    public String getName(){
    	return name;
    }
    
    public void saveColorScheme(){
    	Utilities.SaveToFile(this, null, name);
    }
    
    public ColorScheme getCurrentColor(){
    	return currentColorScheme;
    }
    
    public List<ColorScheme> getAllSchemes(){
    	List<ColorScheme> toReturn = new ArrayList<ColorScheme>();
    	toReturn.add(ColorScheme.DARK);
    	toReturn.add(ColorScheme.BLUE);
    	toReturn.add(ColorScheme.RED);
    	toReturn.add(ColorScheme.PINK);
    	toReturn.add(ColorScheme.LIGHT);
    	return toReturn;
    }
    
    
}
