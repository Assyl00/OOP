package prj;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Auth {
	
	public static void main(String[] args) throws ClassNotFoundException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, String> students = new HashMap<String, String>();
		
	    students.put("Arystan", "hello");
	    students.put("Aidana", "bye");
	    
	    Admin a1 = new Admin("Adm", "Adm", "a.adm", "admin");
	    Teacher t1 = new Teacher("T1", "T1", "t.tech", "tc");
	    Manager m1 = new Manager("M1", "M1", "m.mng", "mng", ManagerType.OR);
	    Student s1 = new Student("Aidana", "Ospan", "ai_ospan", "aidana");
	    Librarian l1 = new Librarian("Ainur", "Askarova", "l.lib", "lib");
	    Course c1 = new Course("OOP", t1, Faculty.FIT, 2, t1, 3);
	    m1.assignTeachersForCourses(c1, t1, LessonType.PRACTICEANDLECTURE);
	    c1.getStudents().add(s1);
	    Database.getInstance().courses.add(c1);
	    Database.getInstance().users.add(a1);
	    Database.getInstance().users.add(t1);
	    Database.getInstance().users.add(s1);
	    Database.getInstance().users.add(m1);
	    Database.getInstance().users.add(l1);
	    
	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter login");
	    String userName = myObj.nextLine();  // Read user input
	    System.out.println("Enter password");
	    String password = myObj.nextLine();
	    if(a1.getLogin().equals(userName) && a1.getPassword().equals(password)) {
//	    	currentUser = a1;
	    	AdminTester.main(args, a1);
	    }
	    else {
		    for(User u : Database.getInstance().users) {
		    	if(u.getLogin().equals(userName) && u.getPassword().equals(password)) {
		    		Database.getInstance().logs.add(userName + " " + new Date());
		    		if(u instanceof Admin) {
		    			Admin a = (Admin)u;
			    		AdminTester.main(args, a);
		    		}
		    		else if(u instanceof Teacher) {
		    			Teacher t = (Teacher) u;
		    			TeacherTester.main(args, t);
		    		}
		    		else if(u instanceof Student) {
		    			Student s = (Student) u;
		    			StudentTester.main(args, s);
		    		}
		    		else if(u instanceof Manager) {
		    			Manager m = (Manager) u;
		    			ManagerTester.main(args, m);
		    		}
		    		else if(u instanceof Librarian) {
		    			Librarian l = (Librarian) u;
		    			LibrarianTester.main(args, l);
		    		}
		    	}
		    }
	    }
	}

}
