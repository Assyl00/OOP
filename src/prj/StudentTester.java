package prj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentTester {

	public static void main(String[] args, Student student) throws IOException, NumberFormatException, ClassNotFoundException {
		Database db = Database.getInstance();
		System.out.println("Hey, student!");
	    boolean active = true;
	    while(active) {
	            System.out.println("Choose what you want to do: \n"
	            + "1: Register for course\n"
	            + "2: View Courses\n"
	            + "3: GetTranscript\n"
	            + "4: See news\n"
	            + "5: Rate teachers\n" 
	            + "6: Back\n");
	            BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
	            String choise = bfr.readLine(); 
	            switch (choise) {
	                case "1": 
		                  System.out.println("Choose course: ");
//		                  String courseName = bfr.readLine();
//		                  for(Course cn: Database.getInstance().courses) {
//		                    if( cn.getName().equals(courseName)) {
//		                      student.registerForCourse(cn);
//		                    }
//		                  }
		                  for(int i = 0; i < Database.getInstance().coursesForRegistration.size(); i++) {
		                	  System.out.println(1+i+")" + Database.getInstance().coursesForRegistration.get(i));
		                  }
		                  int in = Integer.parseInt(bfr.readLine()) - 1;
					      Course course = Database.getInstance().coursesForRegistration.get(in);
					      student.registerForCourse(course);
		                  break;
	                case "2": 
	                	System.out.println("All your courses: ");
	                	System.out.println(student.viewCourses(student).toString());
	    
	                  break;
	                case "3":
	                	System.out.println("Your transcript: ");
	                	System.out.println(student.getTranscript().getMarks());
	                	break;
	                case "4":
	                	System.out.println("All news:");
	                	System.out.println(student.viewNews());
	                	break;
	                case "5":
	                	System.out.println("Choose what teacher you want to rate:");
	                	for(int i = 0; i < db.users.size(); i++) {
	                		User t = db.users.get(i);
							if(t instanceof Teacher) {
								System.out.println(1+ i + ")" + t.getName() + " " + t.getSurname());
							}
						}
	                	int in2 = Integer.parseInt(bfr.readLine()) - 1;
				        Teacher teacher = (Teacher) db.users.get(in2);
				        
				        System.out.println("Write your mark:");
				        double point = Double.parseDouble(bfr.readLine());
				        student.rateTeacher(teacher, point);
	                	break;
	                case "6":
	                	Auth.main(args);
	                default:
	                  active = false;
	                  break;
	            }
	        }
	  }
	}

