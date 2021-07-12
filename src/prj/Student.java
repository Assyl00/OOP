package prj;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Student extends User implements ISendRequest {
    

    // fields
	private Faculty faculty;
    private Integer yearsOfStudy;
    private Transcript transcript = new Transcript(); 
    public Vector<Course> courses = new Vector<>();
    public Vector<Book> books = new Vector<>();
//    private Course course;
    private Set<CourseFile> courseFile;
//    private Librarian library;
    public int credits = 0;
//    public HashMap<Course, TypeMark> marks = new HashMap<>();
    public Vector<Course> registrationCourses = new Vector<>();
    
    
    Student() {}
    
    Student(String name, String surname, String login, String password){
    	super(name, surname, login, password);
    }
    
    Student(String id){
    	super(id);
    }
    
    Student(String name, String surname){
    	super(name, surname);
    }
    
    // main methods

    /** 
     * a method to view the teacher of specific course
     * @param course is the course which teacher student want to see
     * */
    public String viewCourseTeacher(Course course) {
    	
		if (course.getLectureTeacher() == course.getPracticeTeacher()) {
        	return "Lecture and Practice teacher: " + course.getLectureTeacher();
        }
        else {
        	return "Lecture teacher: "  + course.getLectureTeacher() + "/n" +
        		   "Practice teacher: " + course.getPracticeTeacher(); 
        }
    	
        
    }

    /** a method to see all course files 
     * @param course is a course which course files student want to see
     * 
     * */
    public Vector<CourseFile> viewCourseFiles(Course course) {
    	
        return course.getCourseFiles();
    }

    /** a method to rate teacher
     * @param teacher is a teacher student want to rate
     * @param point is the rating student want to give that teacher
     * 
     * */
    public void rateTeacher(Teacher teacher, Double point) {//tester
    	if(point <= 5)
    		teacher.points.add(point);
    }

    /** a method to register for course
     * @param course is the course for which student want to register
     * 
     * */
    public void registerForCourse(Course course) {
       registrationCourses.add(course);
    }
    

    /** a method to send the requests
     * @param userTo is the user, who is going to receive the request
     * @param req is the Request that user is going to receive
     * 
     * */
	@Override
	public String sendRequest(User userTo, Request req) {
		if(userTo instanceof Manager) {
			Database.getInstance().requests.add(req);
			return "You succesfully send request";
		}
		return "You are not allowed to send request to this user, please send your request to Manager";
		
	}
	
	/** a method to see all courses
     * @param student is a student which courses student want to see
     * 
     * */
	public Vector<Course> viewCourses(Student student){
		return student.courses;
	}

    //getters and setters
    public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Transcript getTranscript() {
        return this.transcript;
    }
	
	public Faculty getFaculty() {
        return this.faculty;
    }
    
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    public int getYearsOfStudy () {
        return this.yearsOfStudy ;
    }

    public void setYearsOfStudy (Integer yearsOfStudy ) {
        this.yearsOfStudy  = yearsOfStudy ;
    }

    
    public Vector<Book> getBooks() {
        return this.books;
    }


	public Vector<Course> getRegistrationCourses() {
		return registrationCourses;
	}

	public void setRegistrationCourses(Vector<Course> registrationCourses) {
		this.registrationCourses = registrationCourses;
	}

	// default methods 
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (faculty != other.faculty)
			return false;
		else
			return other.yearsOfStudy == this.yearsOfStudy;
	}
	
    @Override
	public String toString() {
		return "Student " + super.toString() + "[faculty=" + faculty + ", yearsOfStudy=" + yearsOfStudy + "]";    
    }

}
