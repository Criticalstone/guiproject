package guiProject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
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
	@FXML
	private Label date1;
	@FXML
	private Label date2;
	@FXML
	private Label date3;
	@FXML
	private Label date4;
	@FXML
	private Label date5;
	@FXML
	private Label date6;
	@FXML
	private Label date7;
	@FXML
	private Label time1;
	@FXML
	private Label time2;
	@FXML
	private Label time3;
	@FXML
	private Label time4;
	@FXML
	private Label time5;
	
	private ToggleGroup deliveryButtonGroup;
	private String selectedDelivery;
	
	Date today;
	Calendar calendar;
	private static final DateFormat dateFormat = new SimpleDateFormat("MM/dd");
	
	public DeliveryScheduleComponent(){
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
	            "fxml/DeliveryScheduleComponent.fxml"));
	    fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);
	    
	    try {
	        fxmlLoader.load();
	    } catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }
	    today = Calendar.getInstance().getTime();
	    calendar = new GregorianCalendar();
	    calendar.setTime(today);
	    deliveryButtonGroup = new ToggleGroup();
	    setDayLabels();
	    setDeliverySelectionButtons();

	}

	private void setDeliverySelectionButtons() {
		for (int days = 1; days <= 7; days++){
			for (int hours = 3; hours <= 7; hours++){
				ToggleButton button = new ToggleButton();
				button.getStyleClass().add("main-buttons");
				String price;
				if (hours == 6 || hours == 7){
					price = "59 kr";
				} else {
					price = "29 kr";
				}
				
				button.setText(price);
				button.setMinSize(70, 40);
				button.setToggleGroup(deliveryButtonGroup);
				button.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {
						if (((ToggleButton)event.getSource()).isSelected()){
							String selectedDay;
							switch (GridPane.getColumnIndex((ToggleButton)event.getSource())){
								case 1:
									selectedDay = day1.getText() + " " + date1.getText();
									break;
								case 2:
									selectedDay = day2.getText() + " " + date2.getText();
									break;
								case 3:
									selectedDay = day3.getText() + " " + date3.getText();
									break;
								case 4:
									selectedDay = day4.getText() + " " + date4.getText();
									break;
								case 5:
									selectedDay = day5.getText() + " " + date5.getText();
									break;
								case 6:
									selectedDay = day6.getText() + " " + date6.getText();
									break;
								case 7:
									selectedDay = day7.getText() + " " + date7.getText();
									break;
								default:selectedDay = "unknown";
							}
							
							String selectedTime;
							switch (GridPane.getRowIndex((ToggleButton)event.getSource())){
								case 3:
									selectedTime = time1.getText();
									break;
								case 4:
									selectedTime = time2.getText();
									break;
								case 5:
									selectedTime = time3.getText();
									break;
								case 6:
									selectedTime = time4.getText();
									break;
								case 7:
									selectedTime = time5.getText();
									break;
								default:selectedTime = "unknown";
							}
							selectedDelivery = selectedDay + " kl. " + selectedTime;
						} else {
							selectedDelivery = null;
						}
						
						
					}
					
				});
				this.add(button, days, hours);
			}
		}
	}

	private void setDayLabels() {
	    calendar.add(Calendar.DAY_OF_MONTH, 1);
		date1.setText(dateFormat.format(calendar.getTime()));
		day1.setText(getDay(calendar.get(Calendar.DAY_OF_WEEK)));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		date2.setText(dateFormat.format(calendar.getTime()));
		day2.setText(getDay(calendar.get(Calendar.DAY_OF_WEEK)));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		date3.setText(dateFormat.format(calendar.getTime()));
		day3.setText(getDay(calendar.get(Calendar.DAY_OF_WEEK)));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		date4.setText(dateFormat.format(calendar.getTime()));
		day4.setText(getDay(calendar.get(Calendar.DAY_OF_WEEK)));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		date5.setText(dateFormat.format(calendar.getTime()));
		day5.setText(getDay(calendar.get(Calendar.DAY_OF_WEEK)));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		date6.setText(dateFormat.format(calendar.getTime()));
		day6.setText(getDay(calendar.get(Calendar.DAY_OF_WEEK)));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		date7.setText(dateFormat.format(calendar.getTime()));
		day7.setText(getDay(calendar.get(Calendar.DAY_OF_WEEK)));
	}
	
	
	private String getDay(int i){
		switch (i){
		case 1: return "Söndag";
		case 2: return "Måndag";
		case 3: return "Tisdag";
		case 4: return "Onsdag";
		case 5: return "Torsdag";
		case 6: return "Fredag";
		case 7: return "Lördag";
		default: return "Unknown";
		}
		
	}
	
	public int getDeliveryCost(){
		String[] temp = ((ToggleButton)deliveryButtonGroup.getSelectedToggle()).getText().split(" ");
		return Integer.parseInt(temp[0]);
	}
	
	public String getDeliveryTime(){
		return selectedDelivery;
	}
	
}
