package Collections;

public class LibraryThread extends Book implements Runnable {
	private Library library;
	private Book book;
	
	public LibraryThread(Library library,Book book) {
		super(book.getId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getPrice(), book.getQuantity() );
		this.library = library;
		this.book =book;
	}
	
	@Override
	public void run() {
		try {
			library.addBook(book);
			System.out.println("Book Added:"+ book.getTitle());
		} catch (Exception e) {
			System.err.println("Error adding book:" + e.getMessage());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try {
    	   Library library = new Library();
    	   Thread t1 = new Thread(new LibraryThread(library,new Book(3,"DSA","Author C","Programming",400.0,8)));
    	   Thread t2 = new Thread(new LibraryThread(library,new Book(4,"Networking","Author D","Education",700.0,3)));
    	   t1.start();
    	   t2.start();
       } catch(Exception e) {
    	   System.err.println("Error:"+ e.getMessage());
       }
	}

}
