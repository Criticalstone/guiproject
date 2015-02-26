package guiProject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


/**
 * Created by kritt on 2015-02-25.
 */
public class ShoppingCartItem extends ListCell<String>{

    public String name;
    HBox pane = new HBox();
    Button button = new Button("hej");

    public ShoppingCartItem() {
        super();
        /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/ShoppingCartItem.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);*/

        pane.getChildren().addAll(button, button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println((event.getSource().toString()));
            }
        });

        /*try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }*/
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
    }
}
