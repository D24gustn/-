package snackMarket.model;

import java.util.ArrayList;

public class Cart {
	//private CartItem[] itemList = new CartItem[64];
	private ArrayList<CartItem> itemList = new ArrayList<>();
	//private int numItems = 0;

	public boolean isEmpty() {
		return itemList.isEmpty();
	}

	public ArrayList<CartItem> getItemList() {
		return itemList;
	}

	public int getNumItems() {
		return itemList.size();
	}

	public String getItemInfo(int index) {
		return itemList.get(index).toString();
	}

	public void addItem(Snack snack) {
		
		CartItem item = getCartItem(snack);
		if (item == null) {
			itemList.add(new CartItem(snack));
		}
		else {
			item.addQuantity(1);
		}
	}
	
	private CartItem getCartItem(Snack snack) {
		
		for (CartItem item : itemList) {
			if (item.getSnack() == snack) return item;
		}
		
		return null;
	}
	
	private CartItem getCartItem(int snackId) {
		for (CartItem item : itemList) {
			if (item.snackId == snackId) return item;
		}
		return null;
	}
	

	public void resetCart() {
		itemList.clear();
	}

	public boolean isValidItem(int snackId) {
		for (CartItem item : itemList) {
			if (item.snackId == snackId) return true;
		}
		return false;
	}

	public void deleteItem(int snackId) {
		CartItem item = getCartItem(snackId);
		itemList.remove(item);
	}

	public void updateQuantity(int snackId, int quantity) {
		
		if (quantity == 0)
			deleteItem(snackId);
		else {
			CartItem item = getCartItem(snackId);
			item.setQuantity(quantity);
		}
		
	}

	public int getTotalPrice() {
		int totalPrice = 0;
		for (CartItem item : itemList) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}
	
}