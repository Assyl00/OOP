package prj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Vector;

public class TeacherTester {

	public static void main(String[] args, Teacher t) throws NumberFormatException, IOException, ClassNotFoundException {
		Database db = Database.getInstance();
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Hey, teacher!");
		
		main:while(true) {
				System.out.println("Choose what operation do you want to do:" + "\n1.Add course file "
						+ "\n2.Remove course file "
						+ "\n3.Put marks "
						+ "\n4.View course students"
						+ "\n5.Send request"
						+ "\n6.Send message"
						+ "\n7.Back");
				int chosen = Integer.parseInt(bfr.readLine());
				if(chosen == 1) {
					System.out.println("Choose course:");
					for(int i = 0; i < t.getCourses().size(); i++) {
						System.out.println(1 + i + ")" + t.getCourses().get(i));
					}
					int in = Integer.parseInt(bfr.readLine()) - 1;
			        Course course = t.getCourses().get(in);
			        System.out.println("Write title of file:");
			        String title = bfr.readLine();
			        System.out.println("Write body of file:");
			        String body = bfr.readLine();
			        t.addCourseFile(course, title, body);
			        System.out.println("File was succesfully added");
				}
				else if(chosen == 2) {
					System.out.println("Choose course:");
					for(int i = 0; i < t.getCourses().size(); i++) {
						System.out.println(1 + i + ")" + t.getCourses().get(i));
					}
					int in = Integer.parseInt(bfr.readLine()) - 1;
			        Course course = t.getCourses().get(in);
			        
			        
					System.out.println("Choose what file you want to delete: ");
					for(int i = 0; i < course.getCourseFiles().size(); i++) {
						System.out.println(1 + i + ")" + course.getCourseFiles().get(i));
					}
					int in2 = Integer.parseInt(bfr.readLine()) - 1;
			        CourseFile cf = course.getCourseFiles().get(in2);
					t.removeCourseFiles(cf);
					System.out.println(cf.toString());
					
					System.out.println("File was succesfully removed");
				}
				else if(chosen == 3) {
					System.out.println("Choose course:");
					for(int i = 0; i < t.getCourses().size(); i++) {
						System.out.println(1 + i + ")" + t.getCourses().get(i));
					}
					int in = Integer.parseInt(bfr.readLine()) - 1;
			        Course course = t.getCourses().get(in);
			        
			        System.out.println("Choose student:");
			        for(int i = 0; i < course.getStudents().size(); i++) {
			        	System.out.println(1 + i + ")" + course.getStudents().get(i));
			        }
			        int in2 = Integer.parseInt(bfr.readLine()) - 1;
					Student student = course.getStudents().get(in2);
					
					System.out.println("Choose mark: \n1)A \n2)A- \n3)B+ \n4)B \n5)B- \n6)C+");
					int inmark = Integer.parseInt(bfr.readLine());
					TypeMark mark = null;
					if(inmark == 1)
						mark = TypeMark.A;
					if(inmark == 2)
						mark = TypeMark.A_MINUS;
					if(inmark == 3)
						mark = TypeMark.B_PLUS;
					if(inmark == 4)
						mark = TypeMark.B;
					if(inmark == 5)
						mark = TypeMark.B_MINUS;
					if(inmark == 6)
						mark = TypeMark.C_PLUS;
					t.putMarks(course, student, mark);
					System.out.println("You put mark");
				}
				else if(chosen == 4) {
					System.out.println("Choose course:");
					for(int i = 0; i < t.getCourses().size(); i++) {
						System.out.println(1 + i + ")" + t.getCourses().get(i));
					}
					int in = Integer.parseInt(bfr.readLine()) - 1;
			        Course course = t.getCourses().get(in);
			        t.sortStudents(course);
			        System.out.println(t.viewCourseStudents(course));
				}
				else if(chosen == 5) {
					System.out.println("Choose user to send request:");
					for(int i = 0; i < db.users.size(); i++) {
						System.out.println(1 + i + ")" + db.users.get(i));
					}
					int in = Integer.parseInt(bfr.readLine()) - 1;
					User userTo = db.users.get(in);
					
					System.out.println("Write request's title");
					String title = bfr.readLine();
					System.out.println("Write request's body");
					String body = bfr.readLine();
					Request req = new Request(title, body, false);
					System.out.println(t.sendRequest(userTo, req));
				}
				else if(chosen == 6) {
					System.out.println("Choose user to send message:");
					for(int i = 0; i < db.users.size(); i++) {
						System.out.println(1 + i + ")" + db.users.get(i));
					}
					int in = Integer.parseInt(bfr.readLine()) - 1;
					User userTo = db.users.get(in);
					
					System.out.println("Write message");
					String body = bfr.readLine();
					System.out.println(t.sendMessage(userTo, body));
				}
				else if(chosen == 7) {
					Auth.main(args);
				}
		}
	}

}
