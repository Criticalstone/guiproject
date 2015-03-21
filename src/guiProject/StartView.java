package guiProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.Interpolator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class StartView extends GridPane {
	@FXML
	private Label recipeLabel1;
	@FXML
	private Label recipeLabel2;
	@FXML
	private Label recipeLabel3;
	@FXML
	private Label recipeLabel4;
	@FXML
	private Label recipeLabel5;
	@FXML
	private Label recipeLabel6;
	@FXML
	private Label recipeLabel7;
	@FXML
	private Label recipeLabel8;
	@FXML
	private Label recipeLabel9;
	@FXML
	private ImageView recipeImg1;
	@FXML
	private ImageView recipeImg2;
	@FXML
	private ImageView recipeImg3;
	@FXML
	private ImageView recipeImg4;
	@FXML
	private ImageView recipeImg5;
	@FXML
	private ImageView recipeImg6;
	@FXML
	private ImageView recipeImg7;
	@FXML
	private ImageView recipeImg8;
	@FXML
	private ImageView recipeImg9;
	@FXML
	private AnchorPane imgSlider;
	
    private final double IMG_WIDTH = 980;
    private final double IMG_HEIGHT = 500;
    
    private final int SLIDE_FREQ = 4;
    private final int NUM_OF_IMGS = 3;
    HBox imgContainer = new HBox();
	
	public StartView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/StartView.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        setSlide();

    }
	
	private void setSlide(){
        ImageView img1 = new ImageView(new Image(getClass().getResourceAsStream("../res/startView/start.png")));
        ImageView img2 = new ImageView(new Image(getClass().getResourceAsStream("../res/startView/start2.jpg")));
        ImageView img3 = new ImageView(new Image(getClass().getResourceAsStream("../res/startView/start3.jpg")));
        imgContainer.getChildren().addAll(img1, img2, img3);
        startAnimation(imgContainer);
        imgSlider.getChildren().add(imgContainer);
	}
	
	
	
   private void startAnimation(final HBox hbox) {
	   
        EventHandler<ActionEvent> slideAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1.5), hbox);
            trans.setByX(-IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };
 
        EventHandler<ActionEvent> resetAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1), hbox);
            trans.setByX((NUM_OF_IMGS - 1) * IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };
 
        List<KeyFrame> keyFrames = new ArrayList<>();
        for (int i = 1; i <= NUM_OF_IMGS; i++) {
            if (i == NUM_OF_IMGS) {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), resetAction));
            } else {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), slideAction));
            }
        }
        Timeline anim = new Timeline(keyFrames.toArray(new KeyFrame[NUM_OF_IMGS]));
 
        anim.setCycleCount(Timeline.INDEFINITE);
        anim.playFromStart();
    }
	
	public void setRecipe(){
		int i = 1;
		for(String r: ControllerMain.getRandRecipe()){
			if(i==9){
				recipeLabel9.setText(r);
				i++;
			}else if(i==8){
				recipeLabel8.setText(r);
				i++;
			}else if(i==7){
				recipeLabel7.setText(r);
				i++;
			}else if(i==6){
				recipeLabel6.setText(r);
				i++;
			}else if(i==5){
				recipeLabel5.setText(r);
				i++;
			}else if(i==4){
				recipeLabel4.setText(r);
				i++;
			}else if(i==3){
				recipeLabel3.setText(r);
				i++;
			}else if(i==2){
				recipeLabel2.setText(r);
				i++;
			}else if(i==1){
				recipeLabel1.setText(r);
				i++;
			}
		}
		
		for(Recipe r: ControllerMain.getRecipeSet()){
			if(recipeLabel1.getText().equals(r.getName())){
				recipeImg1.setImage(r.getImage());
			}else if(recipeLabel2.getText().equals(r.getName())){
				recipeImg2.setImage(r.getImage());
			}else if(recipeLabel3.getText().equals(r.getName())){
				recipeImg3.setImage(r.getImage());
			}else if(recipeLabel4.getText().equals(r.getName())){
				recipeImg4.setImage(r.getImage());
			}else if(recipeLabel5.getText().equals(r.getName())){
				recipeImg5.setImage(r.getImage());
			}else if(recipeLabel6.getText().equals(r.getName())){
				recipeImg6.setImage(r.getImage());
			}else if(recipeLabel7.getText().equals(r.getName())){
				recipeImg7.setImage(r.getImage());
			}else if(recipeLabel8.getText().equals(r.getName())){
				recipeImg8.setImage(r.getImage());
			}else if(recipeLabel9.getText().equals(r.getName())){
				recipeImg9.setImage(r.getImage());
			}
		}
	}
	
	public void recipeEvent(MouseEvent e){
		if(e.getSource().equals(recipeImg1)){
			ControllerMain.displayRecipeView(recipeLabel1.getText());
		}else if(e.getSource().equals(recipeImg2)){
			ControllerMain.displayRecipeView(recipeLabel2.getText());
		}else if(e.getSource().equals(recipeImg3)){
			ControllerMain.displayRecipeView(recipeLabel3.getText());
		}else if(e.getSource().equals(recipeImg4)){
			ControllerMain.displayRecipeView(recipeLabel4.getText());
		}else if(e.getSource().equals(recipeImg5)){
			ControllerMain.displayRecipeView(recipeLabel5.getText());
		}else if(e.getSource().equals(recipeImg6)){
			ControllerMain.displayRecipeView(recipeLabel6.getText());
		}else if(e.getSource().equals(recipeImg7)){
			ControllerMain.displayRecipeView(recipeLabel7.getText());
		}else if(e.getSource().equals(recipeImg8)){
			ControllerMain.displayRecipeView(recipeLabel8.getText());
		}else if(e.getSource().equals(recipeImg9)){
			ControllerMain.displayRecipeView(recipeLabel9.getText());
		}
	}
	
	public void recipeMouseEntered(MouseEvent e){
		setCursor(Cursor.HAND);
	}
	
	public void recipeMouseExited(MouseEvent e){
		setCursor(Cursor.DEFAULT);
	}

}
