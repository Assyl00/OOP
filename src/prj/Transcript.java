package prj;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Transcript {	
	private HashMap<Course, TypeMark> marks = new HashMap<>();
	private double gpa;
	
	public Transcript () {};
	
	public void setGpa(TypeMark tp) {
		switch(tp) {
			case A:
				gpa = 4.00;
				break;
			case A_MINUS:
				gpa = 3.67;
				break;
			case B_PLUS:
				gpa = 3.33;
				break;
			case B:
				gpa = 3.00;
				break;
			case B_MINUS:
				gpa = 2.67;
				break;
			case C_PLUS:
				gpa = 2.33;
				break;
			case C:
				gpa = 2.00;
				break;
			case C_MINUS:
				gpa = 1.67;
				break;
			case D_PLUS:
				gpa = 1.33;
				break;
			case D:
				gpa = 1.00;
				break;
			case F:
				gpa = 0.00;
				break;
		}
//		for(Map.Entry<Course, TypeMark> mp : marks.entrySet()) {
//			if(mp.getValue().equals(TypeMark.A)) {
//				gpa = 4.00;
//			}
//			else if(mp.getValue().equals(TypeMark.A_MINUS)) {
//				gpa = 3.67;
//			}
//			else if(mp.getValue().equals(TypeMark.B_PLUS)) {
//				gpa = 3.33;
//			}
//			else if(mp.getValue().equals(TypeMark.B)) {
//				gpa = 3.00;
//			}
//			else if(mp.getValue().equals(TypeMark.B_MINUS)) {
//				gpa = 2.67;
//			}
//			else if(mp.getValue().equals(TypeMark.C_PLUS)) {
//				gpa = 2.33;
//			}
//			else if(mp.getValue().equals(TypeMark.C)) {
//				gpa = 2.00;
//			}
//			else if(mp.getValue().equals(TypeMark.C_MINUS)) {
//				gpa = 1.67;
//			}
//			else if(mp.getValue().equals(TypeMark.D_PLUS)) {
//				gpa = 1.33;
//			}
//			else if(mp.getValue().equals(TypeMark.D)) {
//				gpa = 1.00;
//			}
//			else if(mp.getValue().equals(TypeMark.F)) {
//				gpa = 0.00;
//			}
//		}
	}
	
	Vector<String> tr = new Vector<>();
	public Vector<String> getCourseAndMark() {
		
//		for(Course c : marks.keySet()) {
////			this.setGpa(marks.get(c));
//			return c.getName() + " " + marks.get(c) + " "; 
//		}
		
		for(Map.Entry<Course, TypeMark> mp : marks.entrySet()) {
			this.setGpa(mp.getValue());
			String res = mp.getKey().getName() + " " + mp.getValue() + " " + gpa;
			tr.add(res);
			return tr;
		}
		return null;
	}
	
//	public void getGpa() {
//		for(Map.Entry<Course, TypeMark> mp : marks.entrySet()) {
//			
//		}
//	}
	
//	public String getCourseAndMark (Course course, MarkingPeriod mp) {
//		
//		if (course.marks[mp] <= 100 && course.marks[mp] >= 95) {
//			mark = "A";
//		} else if (course.marks[mp] <= 94 && course.marks[mp] >= 90) {
//			mark = "A-";
//		} else if ((course.marks[mp] <= 89) && (course.marks[mp] >= 85)) {
//			mark = "B+";
//		} else if ((course.marks[mp] <= 84) && (course.marks[mp] >= 80)) {
//			mark = "B";
//		} else if (course.marks[mp] <= 79 && course.marks[mp] >= 75) {
//			mark = "B-";
//		} else if (course.marks[mp] <= 74 && course.marks[mp] >= 70) {
//			mark = "C+";
//		} else if (course.marks[mp] <= 69 && course.marks[mp] >= 65) {
//			mark = "C";
//		} else if (course.marks[mp] <= 64 && course.marks[mp] >= 60) {
//			mark = "C-";
//		} else if (course.marks[mp]<= 59 && course.marks[mp] >= 55) {
//			mark = "D+";
//		} else if (course.marks[mp] <= 54 && course.marks[mp] >= 50) {
//			mark = "D";
//		} else {
//			mark = "F";
//		}
//		return mark;
//	}
//	
	
	public HashMap<Course, TypeMark> getMarks() {
		return marks;
	}
 
	public void setMarks(HashMap<Course, TypeMark> marks) {
		this.marks = marks;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

}
