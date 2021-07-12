

import java.io.*;
import java.util.*;

class Database implements Serializable{
	
	private static final Database instance = new Database();
	
	// fields 
	public Vector<User> users = new Vector<>();
	public Vector<Admin> admins = new Vector<>();
	public Vector<Student> students = new Vector<>();
	public Vector<Teacher> teachers = new Vector<>();
	public Vector<Manager> managers = new Vector<>();
	
	public Vector<Course> courses = new Vector<>();
	public HashMap<Course, Student> listOfCoursesAndStudents = new HashMap<>();
    public Vector<Course> coursesForRegistration = new Vector<>();
    
    public Vector<News> news = new Vector<>();
    public HashMap<News, String> comments = new HashMap<>();
    
    public Vector<Book> books = new Vector<>();
    
    public Vector<Message> messages = new Vector<>();
    public Vector<Request> requests = new Vector<>();
    
    public MarkingPeriod status;
    
    static public ObjectOutputStream oos;
    static public ObjectInputStream ois;

    
    Database(){}
    
    public static Database getInstance() {
    	if(instance == null)
    		return new Database();
    	return instance;
    }
    
//    public User getUser(String name) {
//		for(User u: users) {
//			if(u.getName().equals(name)) {
//				return u;
//			}
//		}
//		return null;
//	}
    
    public Vector<User> getUsers(){
        return this.users;
    }
    
    public void serialUsers() throws FileNotFoundException, IOException {
    	oos = new ObjectOutputStream(new FileOutputStream("users.out"));
    	oos.writeObject(users);
    	oos.close();
    }
    
    public void deserialUsers() throws FileNotFoundException, IOException, ClassNotFoundException {
    	ois = new ObjectInputStream(new FileInputStream("users.out"));
    	users = (Vector<User>) ois.readObject();
    }
    
    public void serialCourses() throws FileNotFoundException, IOException {
    	oos = new ObjectOutputStream(new FileOutputStream("courses.out"));
    	oos.writeObject(courses);
    	oos.close();
    }
    
    public void deserialCourses() throws FileNotFoundException, IOException, ClassNotFoundException {
    	ois = new ObjectInputStream(new FileInputStream("courses.out"));
    	courses = (Vector<Course>) ois.readObject();
    }
    
    public void serialNews() throws FileNotFoundException, IOException {
    	oos = new ObjectOutputStream(new FileOutputStream("news.out"));
    	oos.writeObject(news);
    	oos.close();
    }
    
    public void deserialNews() throws FileNotFoundException, IOException, ClassNotFoundException {
    	ois = new ObjectInputStream(new FileInputStream("news.out"));
    	news = (Vector<News>) ois.readObject();
    }
    
}
