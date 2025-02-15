package JDBC;

import java.sql.*;
public class DatabaseConnection {
	String URL = "jdbc:mysql://localhost:3306/Library_db";
    String USER = "root";
    String PASSWORD = "Ezaj@2002";
    
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public void addBook() {
        int id = 103;
        String title = "MindHunter";
        String category = "Nobel";
        int price=1500;
        int quantity=100;
        String query = "INSERT INTO books (id, title, category, price, quantity) VALUES ('" + id + "', '" + title + "', '" + category + "','" + price + "','" + quantity + "')";
        try
        {
        	Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Book added: " + title);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void getAllBook() {
        String query = "SELECT * FROM books";
        try
        {
        	Connection connection = getConnection();
            Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Library:");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " - " +
                        resultSet.getString("title") + " - " +
                        resultSet.getString("category") + " - " +
                        resultSet.getInt("price") + " - " +
                        resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void deleteBook() {
        int id = 103;
        String title="MindHunter";
        String query = "DELETE FROM books WHERE id = " + id;
        try
        {
        	Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Book deleted id: " + id+ "\nTitle of Book: "+ title);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
		DatabaseConnection db=new DatabaseConnection();
		System.out.println("Adding Books:");
	       db.addBook();
	    System.out.println("Printing Books:\n");   
	       db.getAllBook();
	       //db.updateBook();
	       //db.getAllBook();
	    System.out.println("Deleting Books:\n");
	       db.deleteBook();
	       db.getAllBook();
	}
}
