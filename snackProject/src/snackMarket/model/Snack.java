package snackMarket.model;

public class Snack {
	private int snackId;
	private String title;
	private String author;
	private String publisher;
	private int price;
	
	public Snack(int snackId, String title, String author, String publisher, int price) {
		this.snackId = snackId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	public int getSnackId() {
		return snackId;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return snackId + ", " + title + ", " + author + ", " + publisher
				+ ", " + price + "원";
	}
}