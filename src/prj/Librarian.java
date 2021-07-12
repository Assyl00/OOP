package prj;



import java.util.HashMap;

public class Librarian extends User{
    private HashMap<Book, Integer> books = new HashMap<>();
//    private Book book;
    
    Librarian(String name, String surname, String login, String password){
    	super(name, surname, login, password);
    }
    
    Librarian(String name, String surname){
    	super(name, surname);
    }
    
    // main methods
    /**
     * method to give book to teacher or student
     * @param book is book that you want to give book
     * @param user is user whom you want to give book
     * */
    public String giveBook(Book book, User user) {
    	if(user instanceof Student) {
    		Student s = (Student)user;
	    	if (books.get(book) != 0) { 
	    		books.put(book, books.get(book) - 1);
	    		
	    		s.books.add(book);
	    		return "Student get book!"; 
	    	}
    	}
	    else if(user instanceof Teacher) {
	    	Teacher t = (Teacher)user;
	    	if (books.get(book) != 0) { 
	    		books.put(book, books.get(book) - 1);
	    		
	    		t.books.add(book);
	    		return "Teacher get book!"; 
	    	}
	    }
    	return "You can not give book to this user";
    }
    
    /**
     * method to add new books
     * @param book is book that you want to add
     * @param i is quantity of book
     * */
    public void addBooks(Book book, int i) {
    	if ( !books.containsKey(book) ) {
    		books.put(book, i);
    		
    	}
    	else {
    		books.put(book, books.get(book) + i);
    	}
    	
    }
    
    // getters and setters
    public HashMap<Book, Integer> getBooks() {
        return this.books;
    }

    
    
}
