package guiProject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * @author Shivaji.Barge
 *
 */
public class IntegerTextField extends TextField {

     private String numericLastKey;
     private int maxLength = 999;
     
     public IntegerTextField() {
          super();
          
          this.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
               public void handle(KeyEvent event) {
                    char ar[] = event.getCharacter().toCharArray();
                    char ch = ar[event.getCharacter().toCharArray().length - 1];
                    /*populating lastkey if it is numeric*/
                    if ((ch >= '0' && ch <= '9')) {
                         numericLastKey = String.valueOf(ch);
                    }
                    
                    if (isValid()) {
                         /* Disable other charater than numeric character. */
                         if (!(ch >= '0' && ch <= '9')) {
                              event.consume();
                         }
                    } else {
                         event.consume();
                    }
               }
          });

          /*Disabling 'invalid sting' past functionality if not numeric */
          this.textProperty().addListener(new ChangeListener<String>() {
               @Override
               public void changed(ObservableValue<? extends String> arg0,String oldValue, String newValue) {
                    if(!isNumeric(newValue)){
                         clear();
                    } else if(!isValid()){
//                         clear();
                    }
               }
               
               /**check for numeric value.
                * @param text
                * @return boolean
                */
               private boolean isNumeric(String text) {
                    return text.matches("-?\\d+(.\\d+)?");
               }
          });
     }

     
     /**Check for valid text or not.
      * @return boolean if not valid then return false else true.
      */
     private boolean isValid() {
          if (getText().length() == 0){
               return true;
          } else if (getText().length() > maxLength-1){
        	  return false;
          }
          try {
               String testText = getText();
               testText = (numericLastKey != null && numericLastKey != "") ? testText + numericLastKey : testText;
               numericLastKey = "";
               Integer.parseInt(testText);
          } catch (NumberFormatException ex) {
               return false;
          }
          return true;
     }
     
     public void setMaxLength(int maxLength){
    	 this.maxLength = maxLength;
     }
}