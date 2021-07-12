package prj;



public class Book {
	String title;
	String author;
//	int number;
	
	Book(){}
	
	Book(String title, String author){
		this.title = title;
		this.author = author;
	}

	//getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + "]";
	}
	
	
}
