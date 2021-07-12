package prj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;

public class LibrarianTester {

	public static void main(String[] args, Librarian l) throws NumberFormatException, IOException, ClassNotFoundException {
		Database db = Database.getInstance();
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//		  Librarian l = new Librarian("Ainur", "Askarova");
		//  Vector<Book> books = Database.books;
		  try {
		   while(true){
		    System.out.println("\n 1)Add book  \n 2)Give book \n 3)Back");
		    int choice = (Integer.parseInt(bfr.readLine()));
		    if(choice == 1){
				      Book book = new Book();
				      System.out.println("Enter name: ");
				      String name= bfr.readLine();
				      book.setTitle(name);
				      System.out.println("Enter author: ");
				      String author= bfr.readLine();
				      book.setAuthor(author);
				      l.addBooks(book, 1);
				      System.out.println(book.toString());
		    }
		    else if (choice ==2) {
//		    	
//		//		     Student s = new Student();
//		    	 System.out.println("Choose book:");
//			     for(int i = 0; i < l.getBooks().values().size(); i++) {
//			    	 System.out.println(1 + i + ")" + l.getBooks().get(i));
//			     }
//			     int in = Integer.parseInt(bfr.readLine()) - 1;
//			     Book book = l.getBooks().get(in);
//			     System.out.println("Choose user: ");
//			     for(int i = 0; i < db.users.size(); i++) {
//			    	 System.out.println(1 + i + ")" + db.users.get(i));
//			     }
//			     int in2 = Integer.parseInt(bfr.readLine()) - 1;
//			     User user = db.users.get(in2);
//			     
//			     l.giveBook(book, user);
//			     System.out.println("You gave book");
//				     
		    }
		    else if(choice == 3) {
		    	Auth.main(args);
		    }
		   }
		  }
		  finally {
			    System.out.println("");
			   }
	}

}
