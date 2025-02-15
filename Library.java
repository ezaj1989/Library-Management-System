package Collections;

import java.util.ArrayList;
import java.util.List;

class Library {
		private List<Book> books = new ArrayList<>();
		
		public void addBook(Book book) {
			books.add(book);
		}

		public Book getBook(int id) throws Exception {
			for(Book book : books) {
				if (book.getId() == id) {
					return book;
				}
			}
			throw new Exception("Book with ID"+ id +" not found.");
		}
		public static void main(String[] args) {
			try {
				Library library = new Library();
				library.addBook(new Book(1,"Java Programming","Author A","Programming",500.0,10));
				library.addBook(new Book(2,"python Programming","Author B","Programming",600.0,5));
				
				Book book = library.getBook(1);
				if (book !=null) {
					System.out.println("Book Details:"+ book.getTitle()+","+ book.getAuthor());	
				}
			}catch (Exception e) {
					System.err.println("Error:"+ e.getMessage());
				}
			
		}
	}
