package prj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

public class ManagerTester {

	public static void main(String[] args, Manager m1) throws IOException, ClassNotFoundException {
		Database db = Database.getInstance();
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//		Manager m1 = new Manager("Manager", "Managerova", "m_man", "admin", ManagerType.OR);
//		Vector<Student> students;
	    Student s1 = new Student("Aidana", "Ospan", "ai_ospan", "aidana");
	    
	    s1.setFaculty(Faculty.FIT);
	    s1.setYearsOfStudy(2);
	    
	    Teacher t1 = new Teacher("Pakita","Shamoi", "p_shamoi","shm");
	    Teacher t2 = new Teacher("Zhomart","Aldamuratov", "zh_al","akt");
	    db.users.add(t1);
	    db.users.add(t2);
	    db.users.add(s1);
		db.users.add(m1);
		
//		try {
			while(true){
				System.out.println("\n 1) Add course for registration"
						+ "\n 2) Add teacher to the course "
						+ "\n 3) View teachers  "
						+ "\n 4) View students  "
						+ "\n 5) Send message "
						+ "\n 6) Add news  "
						+ "\n 7) Remove news  "
						+ "\n 8) View requests" 
						+ "\n 9) Set status"
						+ "\n 10) Get rate of teacher"
						+ "\n 11) View info about user"
						+ "\n 12) Approve student's registration"
						+ "\n 13) Back");
				int choice = (Integer.parseInt(bfr.readLine()));
				if(choice==1){
					while(true) {
						Course c = new Course();
						System.out.println("Enter name: ");
						String name= bfr.readLine();
						c.setName(name);
						System.out.println("Choose one of the faculties: \n1) FIT \n2) BS "
								+ "\n3)SMC \n4)FEOGI \n5)ISE \n6)SCE \n7)KMA \n8)FGGE");
						int choiceFaculty = (Integer.parseInt(bfr.readLine()));
						if(choiceFaculty==1)
							c.setFaculty(Faculty.FIT);
						if(choiceFaculty==2)
							c.setFaculty(Faculty.BS);
						if(choiceFaculty == 3)
							c.setFaculty(Faculty.SMC);
						if(choiceFaculty == 4)
							c.setFaculty(Faculty.FEOGI);
						if(choiceFaculty == 5)
							c.setFaculty(Faculty.ISE);
						if(choiceFaculty == 6)
							c.setFaculty(Faculty.SCE);
						if(choiceFaculty == 7)
							c.setFaculty(Faculty.KMA);
						if(choiceFaculty == 8)
							c.setFaculty(Faculty.FGGE);
						System.out.println("Write year of study:");
						int n = Integer.parseInt(bfr.readLine());
						c.setYearOfStudy(n);
						
						System.out.println("Write credits of course:");
						int cr = Integer.parseInt(bfr.readLine());
						c.setCredits(cr);
						
						m1.addCourseToRegistration(c);
						System.out.println("Course was succesfuly added");
						break;
						}
				}
				else if (choice==2){
					System.out.println("Choose course:");
					for(int i = 0 ; i < db.courses.size(); i++) {
						System.out.println(1 + i + ")" + db.courses.get(i));
					}
					int in = Integer.parseInt(bfr.readLine()) - 1;
			        Course course = db.courses.get(in);
			        
			        System.out.println("Choose teacher:");
			        for(int i = 0; i < db.users.size(); i++) {
			        	User t = db.users.get(i);
			        	if(t instanceof Teacher) {
			        		System.out.println(1 + i + ")" + t.getName() + " " + t.getSurname());
			        	}
			        }
			        int in2 = Integer.parseInt(bfr.readLine()) - 1;
			        Teacher teacher = (Teacher) db.users.get(in2);
			        
			        System.out.println("Choose lesson type: \n1)Lecture \n2)Practice \n3)Lecture and practice");
			        int intype = Integer.parseInt(bfr.readLine());
			        LessonType type = null;
			        if(intype == 1)
			        	type = LessonType.LECTURE;
			        if(intype == 2)
			        	type = LessonType.PRACTICE;
			        if(intype == 3)
			        	type = LessonType.PRACTICEANDLECTURE;
			        
			        m1.assignTeachersForCourses(course, teacher, type);
			        System.out.println("Teaher was assigned to course");
//					for(User t: db.users) {
//						System.out.println(t.toString());
//					}
//					System.out.println("Enter id: ");
//					String id=bfr.readLine();
//					System.out.println("Choose course(name): ");
//					Vector<Course> courses = db.courses;
//					int i = 1;
//					for(Course cr: courses) {
//						System.out.println(" " + i + " - " + cr.getName() + "  Credits: " + cr.getCredits());
//						i++;}
//					Scanner crse = new Scanner(System.in); 
//					for (Course s: courses)		
//						if (crse.equals(courses)) {
//							for(Teacher tk: db.teachers) 
//								if(tk.getId().equals(id)) {
//									m1.assignTeachersForCourses(s, t1,LessonType.LECTURE);	
//								}	
//						}
				}
				else if (choice==3){
					System.out.println("All teachers:");
					for(User t: db.users) {
						if(t instanceof Teacher) {
							System.out.println("\n" + t.toString());
						}
					}
//					break;
				}
				else if (choice==4){
					System.out.println("All students:");
					for(User s: db.users) {
						if(s instanceof Student) 
							System.out.println("\n" + s.toString());
					}
				}
				else if(choice == 5) {
					System.out.println("Choose user to send message:");
					for(int i = 0; i < db.users.size(); i++) {
						System.out.println(1 + i + ")" + db.users.get(i));
					}
					int in = Integer.parseInt(bfr.readLine()) - 1;
					User userTo = db.users.get(in);
					
					System.out.println("Write message");
					String body = bfr.readLine();
					System.out.println(m1.sendMessage(userTo, body));
				}
				else if(choice == 6) {
					News n = new News();
					
					System.out.println("Enter title: ");
					String title = bfr.readLine();
					
					System.out.println("Enter text for news: ");
					String body = bfr.readLine();
					
					n.setTitle(title);
					n.setBody(body);
					
					java.util.Date date=new java.util.Date();     
					n.setDate(date);
					
					m1.addNews(n);
					System.out.println(db.news.toString());
					
				}
				else if (choice==7) {
					for(int i = 0; i < db.news.size(); i++) {
						System.out.println(1 + i + ")" + db.news.get(i));
					}
					int in = Integer.parseInt(bfr.readLine()) - 1;
			        News news = db.news.get(in);
			        m1.removeNews(news);
			        System.out.println("News was removed");
				}
				else if(choice==8) {
					System.out.println(m1.viewAllRequests());
				}
				else if(choice == 9) {
					System.out.println("Write status:");
					String status = bfr.readLine();
					System.out.println(m1.setStatus(status));
				}
				else if(choice == 10) {
					System.out.println("Choose teacher:");
					for(int i = 0; i < db.users.size(); i++) {
			        	User t = db.users.get(i);
			        	if(t instanceof Teacher) {
			        		System.out.println(1 + i + ")" + t.getName() + " " + t.getSurname());
			        	}
			        }
			        int in2 = Integer.parseInt(bfr.readLine()) - 1;
			        Teacher teacher = (Teacher) db.users.get(in2);
			        
			        System.out.println(m1.getRateOfTeacher(teacher));
				}
				else if(choice == 11) {
					System.out.println("Choose student:");
					for(int i = 0; i < db.users.size(); i++) {
						User s = db.users.get(i);
						if(s instanceof Student) {
							System.out.println(1 + i + ")" + s.getName() + " " + s.getSurname());
						}
					}
					int in = Integer.parseInt(bfr.readLine()) - 1;
					User u = db.users.get(in);
					
					System.out.println(m1.viewInfoAboutUser(u));
				}
				else if(choice == 12) {
					System.out.println("Choose students:");
					for(int i = 0; i < db.users.size(); i++) {
						User s = db.users.get(i);
						if(s instanceof Student)
							System.out.println(1 + i + ")" + s.getName() + " " + s.getSurname());
					}
					int in = Integer.parseInt(bfr.readLine()) - 1;
					Student s = (Student) db.users.get(in);
					
					System.out.println("Choose course:");
					for(int i = 0 ; i < db.coursesForRegistration.size(); i++) {
						System.out.println(1 + i + ")" + db.coursesForRegistration.get(i));
					}
					int in2 = Integer.parseInt(bfr.readLine()) - 1;
			        Course course = db.coursesForRegistration.get(in2);
					m1.approveStudentRegistration(s, course);
					System.out.println("Approved");
				}
				else if(choice == 13) {
					Auth.main(args);
				}
				
			}
//		}
//		finally{
//			System.out.println("");
//		}
	
	}
}


