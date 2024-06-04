package snackMarket.model;

public class CartItem {
	Snack snack;
	int snackId;
	int quantity;
	
	public CartItem(Snack snack) {
		this.snack = snack;
		this.snackId = snack.getSnackId();
		this.quantity = 1;
	}
	
	public Snack getSnack() {
		return snack;
	}
	public void setSnack(Snack snack) {
		this.snack = snack;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void addQuantity(int quantity) {
		this.quantity += quantity;
		
	}

	@Override
	public String toString() {
		return snack.getSnackId() + ", " + snack.getTitle() + ", " + quantity + "개, " + getPrice() + "원";
	}

	public int getPrice() {
		return quantity * snack.getPrice();
	}
	
	
}