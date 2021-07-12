

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Student extends User implements CommentNews, ISendRequest {
    

    // fields
	private Faculty faculty;
    private Integer yearsOfStudy;
    private Transcript transcript = new Transcript(); 
    public Vector<Course> courses = new Vector<>();
    public Vector<Book> books = new Vector<>();
    private Course course;
    private Set<CourseFile> courseFile;
    private Librarian library;
    public int credits;
    public HashMap<Course, TypeMark> marks = new HashMap<>();
    public Vector<Course> registrationCourses = new Vector<>();
    
    
    Student() {}
    
    Student(String name, String surname, String login, String password){
    	super(name, surname, login, password);
//    	this.position = position;
//    	this.coursesAndLessonTypes = coursesAndLessonTypes;
//    	this.course = course;
    }
    
    Student(String id){
    	super(id);
    }
    
    Student(String name, String surname){
    	super(name, surname);
    }
    // main methods

    public String viewCourseTeacher(Course course) {
    	
		if (course.getLectureTeacher() == course.getPracticeTeacher()) {
        	return "Lecture and Practice teacher: " + course.getLectureTeacher();
        }
        else {
        	return "Lecture teacher: "  + course.getLectureTeacher() + "/n" +
        		   "Practice teacher: " + course.getPracticeTeacher(); 
        }
    	
        
    }

    public Vector<CourseFile> viewCourseFiles(Course course) {
    	
        return course.getCourseFiles();
    }

    public HashMap<Course, TypeMark> viewMarks(Course course) {
    	return marks;
    }

    public void rateTeacher(Teacher teacher, Double point) {
    	teacher.points.add(point);
    }

    public void registerForCourse(Course course) {
       registrationCourses.add(course);
    }
    
//    public void generateId(User user) {
//    	super.generateId(user);
//    }
    
	@Override
	public String sendRequest(User userTo, Request req) {
		if(userTo instanceof Manager) {
			for(Request r : Database.getInstance().requests) {
				if(!r.equals(req)) {
					Database.getInstance().requests.add(req);
					return "You succesfully send request";
				}
			}
			return "You already send this request";
		}
		return "You are not allowed to send request to this user, please send your request to Manager";
		
	}
	
	public String viewTranscript() {
		return this.transcript.getCourseAndMark();
	}

    //getters and setters
    public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public HashMap<Course, TypeMark> getMarks() {
		return marks;
	}

	public void setMarks(HashMap<Course, TypeMark> marks) {
		this.marks = marks;
	}

	public void setCourseFile(Set<CourseFile> courseFile) {
		this.courseFile = courseFile;
	}
	
	public Transcript getTranscript() {
        return this.transcript;
    }
	
	Faculty getFaculty() {
        return this.faculty;
    }
    
    void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    public int getYearsOfStudy () {
        return this.yearsOfStudy ;
    }

    public void setYearsOfStudy (Integer yearsOfStudy ) {
        this.yearsOfStudy  = yearsOfStudy ;
    }

    

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }
    
    public Vector<Course> getCourses() {
        return this.courses;
    }
    
    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }
    
    public Vector<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Vector<Book> books) {
        this.books = books;
    }
    
    public Librarian getLibrary() {
        return this.library;
    }

    public void setLibrary(Librarian library) {
        this.library = library;
    }
    
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<CourseFile> getCourseFile() {
        return this.courseFile;
    }
    

	public Vector<Course> getRegistrationCourses() {
		return registrationCourses;
	}

	public void setRegistrationCourses(Vector<Course> registrationCourses) {
		this.registrationCourses = registrationCourses;
	}

	@Override
	public void commentNews(News news, String comment) {
		Database.getInstance().comments.put(news, comment);
	}


	// default methods 
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
//		result = prime * result + ((yearsOfStudy == 0) ? 0 : yearsOfStudy.hashCode());
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
		return super.toString() + " Student [id=" + id + ", faculty=" + faculty + ", yearsOfStudy=" + yearsOfStudy + "]";    
    }

}
