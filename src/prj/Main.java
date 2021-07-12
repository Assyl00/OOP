package prj;

import java.util.Date;

public class Main {

	

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Student s1 = new Student("Name1", "Surname1", "abc", "abc");
		Student s2 = new Student("AName1", "Surname1", "abc", "abc");
		Teacher t1 = new Teacher("T1", "T1", "teach", "teach");
		Manager m1 = new Manager("M1", "M1", "man1", "man1", ManagerType.OR);
		Admin a1 = new Admin("A1", "A1", "adm1", "adm1");
		
		Course c1 = new Course("OOP", t1, Faculty.FIT, 2, t1, 3);
		Course c2 = new Course("Web", t1, Faculty.BS, 2, t1, 3);
		
	
		//		Database.students.add(s1);
//		Database.students.toString();
		
		Database.getInstance().users.add(s1);
		a1.addUser("Student", "Stud2", "dzhanaeva");
		a1.addUser("Teacher", "Pakita", "Pakita");
		a1.update("123", null, "Aaa", null, "bcd");
		
		
		
		for(User u : Database.getInstance().users) {
			System.out.println(u.toString());
		}
		
		s1.registerForCourse(c1);
		s2.registerForCourse(c1);
		m1.approveStudentRegistration(s1, c1);
		m1.approveStudentRegistration(s2, c1);
		t1.sortStudents(c1);
		System.out.println(t1.viewCourseStudents(c1));
		//messages
		System.out.println(s1.sendMessage(m1, "blbkb ckb"));
		System.out.println(m1.viewMessage());
		
		//books
		Librarian l1 = new Librarian("l1", "l1");
		Book b1 = new Book("OOP", "Dan");
		l1.addBooks(b1, 2);
		System.out.println(l1.giveBook(b1, t1));
		for(Book b : s1.books) {
			System.out.println(b.toString());
		}
		l1.addBooks(b1, 3);
		System.out.println(l1.getBooks());
		
		//news
		News n1 = new News("n1title", "n1body", new Date());
		m1.addNews(n1);
		m1.removeNews(n1);
		System.out.println(s1.viewNews());
		
		//request
		Request req = new Request("Req1", "nbkbkb");
//		System.out.println(m1.viewRequest(Database.getInstance().requests.elementAt(0)));
		System.out.println(s1.sendRequest(m1, req));
		System.out.println(m1.sendRequest(a1, req));
		System.out.println(m1.sendRequest(a1,req));
//		System.out.println(a1.viewAllRequests());
		System.out.println(a1.assignRequest(req));
		System.out.println(m1.viewAllRequests());
		//doesnt work properly
		
		//transcript
		m1.setStatus(MarkingPeriod.FIRST_ATT);
//		t1.putMarks(c1, s1, TypeMark.A);
		t1.putMarks(c2, s1, TypeMark.A_MINUS);
		t1.putMarks(c1, s1, TypeMark.A);
		System.out.println(s1.viewTranscript());
		System.out.println(s1.getTranscript().getMarks());
		
	}

}
