package guiProject;

import guiProject.interfaces.IFProductList;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import se.chalmers.ait.dat215.project.ShoppingItem;

public class SavedShoppingList implements IFProductList<ShoppingItem>{

	private static final long serialVersionUID = -4789214486011266428L;
	private List<ShoppingItem> productList;
	private String name;
    private Date timeStamp;
	
	public SavedShoppingList(String name){
		this.name = name;
        this.timeStamp = new Date();
		productList = new ArrayList<>();
	}

	@Override
	public boolean containProduct(ShoppingItem p) {
		return productList.contains(p);
	}

    public Date getTimeStamp(){
        return (Date)timeStamp.clone();
    }

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void addProduct(ShoppingItem p) {
		productList.add(p);
		
	}

	@Override
	public void removeProduct(ShoppingItem p) {
		for (ShoppingItem shop: productList){
			System.out.println(shop.getProduct().getName());
			if (p.getProduct().equals(shop.getProduct())){
				productList.remove(shop);
				break;
			}
		}

		
	}

	@Override
	public List<ShoppingItem> getProducts() {
		return new ArrayList<ShoppingItem>(productList);
	}


	@Override
	public void addList(List<ShoppingItem> products) {
		productList.addAll(products);
	}


	@Override
	public void removeProductList(List<ShoppingItem> products) {
		productList.removeAll(products);
		
	}
	
}
