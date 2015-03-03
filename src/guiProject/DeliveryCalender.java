package guiProject;

import java.io.IOException;

import javax.swing.ImageIcon;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class DeliveryCalender extends AnchorPane{
	
	@FXML
	private AnchorPane zerozero;
	@FXML
	private AnchorPane zeroone;
	@FXML
	private AnchorPane zerotwo;
	@FXML
	private AnchorPane zerothree;
	@FXML
	private AnchorPane zerofour;
	
	@FXML
	private AnchorPane onezero;
	@FXML
	private AnchorPane oneone;
	@FXML
	private AnchorPane onetwo;
	@FXML
	private AnchorPane onethree;
	@FXML
	private AnchorPane onefour;
	
	@FXML
	private AnchorPane twozero;
	@FXML
	private AnchorPane twoone;
	@FXML
	private AnchorPane twotwo;
	@FXML
	private AnchorPane twothree;
	@FXML
	private AnchorPane twofour;
	
	
	@FXML
	private Label monday;
	@FXML
	private Label tuesday;
	@FXML
	private Label wednesday;
	@FXML
	private Label thursday;
	@FXML
	private Label friday;
	@FXML
	private Label saturday;
	@FXML
	private Label sunday;
	
	@FXML
	private Label backWeek;
	@FXML
	private Label forwardWeek;
	@FXML
	private Label nowWeek;
	@FXML
	private Label nowWeekDate;

	private int backWeekNbr=1;
	private int firstNbrInWeek=2;
	private int month=4;
	
	public DeliveryCalender(){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/DeliveryCalender.fxml"));

		fxmlLoader.setController(this);
		fxmlLoader.setRoot(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
		
		setBoxes();
//		setWeekDates();
		setWeeks();
	
	}
	
	
	private void setWeeks() {
		backWeek.setText("Vecka " + Integer.toString(backWeekNbr));
		nowWeek.setText("Vecka " + Integer.toString(backWeekNbr+1));
		forwardWeek.setText("Vecka " + Integer.toString(backWeekNbr+2));
		
		int first=firstNbrInWeek;
		nowWeekDate.setText(firstNbrInWeek + " - " + Integer.toString(first+6) + " Månad");
		if(firstNbrInWeek+6>30){
			first=1;
			nowWeekDate.setText(firstNbrInWeek + " - " + Integer.toString(first+1) + " Månad");
			if(firstNbrInWeek+5>30){
				first=1;
				nowWeekDate.setText(firstNbrInWeek + " - " + Integer.toString(first+2) + " Månad");
				if(firstNbrInWeek+4>30){
					first=1;
					nowWeekDate.setText(firstNbrInWeek + " - " + Integer.toString(first+3) + " Månad");
					if(firstNbrInWeek+3>30){
						first=1;
						nowWeekDate.setText(firstNbrInWeek + " - " + Integer.toString(first+4) + " Månad");
						if(firstNbrInWeek+2>30){
							first=1;
							nowWeekDate.setText(firstNbrInWeek + " - " + Integer.toString(first+6) + " Månad");
							if(firstNbrInWeek+1>30){
								first=1;
							nowWeekDate.setText(firstNbrInWeek + " - " + Integer.toString(first+5) + " Månad");
							}				
						}	
					}		
				}	
			}	
		}	
	}

//
//	private void setWeekDates() { 
//		monday.setText(Integer.toString(firstNbrInWeek) + "/" + Integer.toString(month));
//		tuesday.setText(Integer.toString(firstNbrInWeek+1) + "/" + Integer.toString(month));
//		wednesday.setText(Integer.toString(firstNbrInWeek+2) + "/" + Integer.toString(month));
//		thursday.setText(Integer.toString(firstNbrInWeek+3) + "/" + Integer.toString(month));
//		friday.setText(Integer.toString(firstNbrInWeek+4) + "/" + Integer.toString(month));
//		saturday.setText(Integer.toString(firstNbrInWeek+5) + "/" + Integer.toString(month));
//		sunday.setText(Integer.toString(firstNbrInWeek+6) + "/" + Integer.toString(month));
//	}

	@FXML
	private void backOnAction(){
		if(backWeekNbr==1){
			backWeekNbr=52;
		}else{
			backWeekNbr=backWeekNbr-1;
		}
		
		
		
		if(firstNbrInWeek<=8){
			firstNbrInWeek=-firstNbrInWeek+31;
			
		}else{
			firstNbrInWeek=firstNbrInWeek-7;
		}
		
		setBoxes();
//		setWeekDates();
		setWeeks();
	}
	
	
	@FXML
	private void forwardOnAction(){
		if(backWeekNbr==52){
			backWeekNbr=1;
		}else{
			backWeekNbr=backWeekNbr+1;
		}
		
		if(firstNbrInWeek+7>30){
			firstNbrInWeek=firstNbrInWeek+7-30;
		}else{
			firstNbrInWeek=firstNbrInWeek+7;
		}	
		
		setBoxes();
//		setWeekDates();
		setWeeks();
	}
	

	private void setBoxes() {
		zerozero.getChildren().add(new CalenderInfoBox());
		zeroone.getChildren().add(new CalenderInfoBox());
		zerotwo.getChildren().add(new CalenderInfoBox());
		zerothree.getChildren().add(new CalenderInfoBox());
		zerofour.getChildren().add(new CalenderInfoBox());
		
		onezero.getChildren().add(new CalenderInfoBox());
		oneone.getChildren().add(new CalenderInfoBox());
		onetwo.getChildren().add(new CalenderInfoBox());
		onethree.getChildren().add(new CalenderInfoBox());
		onefour.getChildren().add(new CalenderInfoBox());
		
		twozero.getChildren().add(new CalenderInfoBox());
		twoone.getChildren().add(new CalenderInfoBox());
		twotwo.getChildren().add(new CalenderInfoBox());
		twothree.getChildren().add(new CalenderInfoBox());
		twofour.getChildren().add(new CalenderInfoBox());		
	}

}
