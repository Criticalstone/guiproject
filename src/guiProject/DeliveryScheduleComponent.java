package guiProject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class DeliveryScheduleComponent extends GridPane{
	@FXML
	private Label day1;
	@FXML
	private Label day2;
	@FXML
	private Label day3;
	@FXML
	private Label day4;
	@FXML
	private Label day5;
	@FXML
	private Label day6;
	@FXML
	private Label day7;
	
	Date today;
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public DeliveryScheduleComponent(){
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
	            "fxml/DerliveryScheduleComponent.fxml"));
	    fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);
	    
	    try {
	        fxmlLoader.load();
	    } catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }
	    today = Calendar.getInstance().getTime();
	    setDayLabels();
	    setDeliverySelectionButtons();

	}

	private void setDeliverySelectionButtons() {
		// TODO Auto-generated method stub
		
	}

	private void setDayLabels() {

		
	    Calendar calendar = new GregorianCalendar();
	    calendar.setTime(today);
	    
	    calendar.add(Calendar.DAY_OF_MONTH, 1);
		day1.setText(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, 2);
		day2.setText(dateFormat.format(calendar.getTime()));;
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		day3.setText(dateFormat.format(calendar.getTime()));;
		calendar.add(Calendar.DAY_OF_MONTH, 4);
		day4.setText(dateFormat.format(calendar.getTime()));;
		calendar.add(Calendar.DAY_OF_MONTH, 5);
		day5.setText(dateFormat.format(calendar.getTime()));;
		calendar.add(Calendar.DAY_OF_MONTH, 6);
		day6.setText(dateFormat.format(calendar.getTime()));;
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		day7.setText(dateFormat.format(calendar.getTime()));;
	}
}
