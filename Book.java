package Collections;

public class Book {
	int id;
	String title;
	String author;
	String category;
	double price;
	int quantity;
	
	public Book(int id ,String title,String author,String category,double price,int quantity) {
		this.id =id;
		this.title = title;
		this.author =author;
		this.category = category;
		this.price=price;
		this.quantity=quantity;
	}
	public int getId() {return id;}
	public String getTitle() {return title;}
	public String getAuthor() {return author;}
	public String getCategory() {return category;}
	public double getPrice() {return price;}
	public int getQuantity() {return quantity;}
}

