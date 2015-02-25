package guiProject;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.Product;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCart extends ListView<Product>{

    private HashMap<Product, Integer> productList;
    private ListView<ShoppingCartItem> list;

    public ShoppingCart() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "fxml/ShoppingCart.fxml"));

        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        productList = new HashMap<>();
        list = new ListView<>();
        updateList();

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public int getQtyOfProduct(Product p){
        if(productList.containsKey(p))
            return productList.get(p);
        else
            return 0;

    }

    public void addProduct(Product p, int quantityDiff){
        int newQuantity = productList.get(p)+quantityDiff;
        if(!productList.containsKey(p)){
            productList.put(p, quantityDiff);
        }else{
            productList.replace(p, newQuantity);
        }
        updateList();
    }

    public void updateList(){
        List<ShoppingCartItem> itemList = list.getItems();
        itemList.clear();
        for(Product p: productList.keySet()){
            ShoppingCartItem item = new ShoppingCartItem(p.getName(), productList.get(p), Utilities.getProductImage(p, new Dimension(50, 50)));
            itemList.add(item);
        }
    }
}
