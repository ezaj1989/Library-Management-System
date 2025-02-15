package FileHandling;

import Collections.Book;
import java.io.*;
public class FileManager extends Book {
	public  FileManager(int id, String title,String author,String category,double price,int quantity) {
		   super(id,title,author,category,price,quantity);
		  }
		  
		  public void  writeToFile(Object obj, String filename) throws IOException {
			  try (ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(filename))) {
				  oos.writeObject(obj);
			  } catch (IOException e) {
				  throw new IOException("Error writing to file:"+e.getMessage());
			  }
		  }
		  
		  
		  public Object readFromFile(String filename) throws IOException,ClassNotFoundException{
			  try (ObjectInputStream ois =new ObjectInputStream(new FileInputStream(filename))){
				  return ois.readObject();
			  }catch (IOException | ClassNotFoundException e) {
				  throw e;
			  }
		  }
		    
			public static void main(String[] args) {
				// TODO Auto-generated method stub
		          try {
		        	  Member member1= new Member(1,"ezaj", "ezaj@example.com");
		        	  Member member2= new Member(2,"ali", "ali@example.com");
		        	  Member member3= new Member(3,"roy", "roy@example.com");
		        	  
		        	  FileManager fileManager = new FileManager(0,"","","",0.0,0);
		        	  
		        	  fileManager.writeToFile(new Member[] {member1,member2,member3},"C:\\Users\\ezaja\\OneDrive\\Desktop\\wipro Assignment\\FHOfile\\member.txt");
		        	  Member[] members = (Member[]) fileManager.readFromFile("C:\\Users\\ezaja\\OneDrive\\Desktop\\wipro Assignment\\FHOfile\\member.txt");
		        	  
		        	  for (Member member : members) {
		        		  System.out.println("Member ID:"+ member.getId()+",Name:"+member.getName()+",Email:"+ member.getEmail());
		        	  }
		          } catch (IOException | ClassNotFoundException e) {
		        	  System.err.println("Getting Error :"+ e.getMessage());
		          }
			}

}
