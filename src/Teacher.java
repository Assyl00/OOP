

import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

public class Teacher extends User implements ISendRequest {
   
    private Position position;
    private HashMap<Course, LessonType> coursesAndLessonTypes;
    private Course course;
    private Set<CourseFile> courseFiles;
    private Message message;
    private Vector<Course> courses;
    public Vector<Double> points;
	public Vector<Book> books = new Vector<>();
    
    Teacher(){}
    
    Teacher(String name, String surname, String login, String password){
    	super(name, surname, login, password);
//    	this.position = position;
//    	this.coursesAndLessonTypes = coursesAndLessonTypes;
//    	this.course = course;
    }
//    
    Teacher(String id){
    	super(id);
    }
    
//    Teacher(String name, String surname){
//    	super(name, surname);
//    }
	 
    // main methods 
    
    public void addCourseFile(Course course, CourseFile courseFile) {
    	courseFile.setCourse(course);
        this.courseFiles.add(courseFile);
    }
    
    public void removeCourseFiles(Course course, CourseFile courseFile) {
    	for(CourseFile cf : this.courseFiles) {
    		if(cf.getTitle().equals(courseFile.getTitle())) {
    			this.courseFiles.remove(courseFile);
    		}
    	}
    } 

    public String viewCourseStudents(Course course) {
    	return course.students.toString();
    }

    public void putMarks(Course course, Student student, TypeMark mark) {
        student.getTranscript().getMarks().put(course, mark);
    }
    
    public String viewStudent(Student student) { 
    	return student.toString();
    }
    
//    public String generateId(User user) {
//    	return super.generateId(user) + "t";
//    }
    
    public void sortStudents(Course course) {
    	Collections.sort(course.students, new NameComparator());
    }
    
    // getters and setters
    
    private Vector<Course> getCourses() {
    	return this.courses;
    }
    
    private Position getPosition() {
        return this.position;
    }

    private void setPosition(Position position) {
        this.position = position;
    }

    public HashMap<Course, LessonType> getcoursesAndLessonTypes() {
        return this.coursesAndLessonTypes;
    }

    public void setCourses(HashMap<Course, LessonType> courses) {
        this.coursesAndLessonTypes = courses;
    }
    
    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public Set<CourseFile> getCourseFiles() {
        return this.courseFiles;
    }
    
    public Message getMessage() {
        return this.message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

	
    // default methods 
    
    @Override
	public String toString() {
		return super.toString() + " Teacher [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((courseFiles == null) ? 0 : courseFiles.hashCode());
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + ((coursesAndLessonTypes == null) ? 0 : coursesAndLessonTypes.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (courseFiles == null) {
			if (other.courseFiles != null)
				return false;
		} else if (!courseFiles.equals(other.courseFiles))
			return false;
		if (courses == null) {
			if (other.courses != null)
				return false;
		} else if (!courses.equals(other.courses))
			return false;
		if (coursesAndLessonTypes == null) {
			if (other.coursesAndLessonTypes != null)
				return false;
		} else if (!coursesAndLessonTypes.equals(other.coursesAndLessonTypes))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (!points.equals(other.points))
			return false;
		if (position != other.position)
			return false;
		return true;
	}

	@Override
	public String sendRequest(User userTo, Request req) {
		if(userTo instanceof Manager) {
				Database.getInstance().requests.add(req);
				return "You succesfully send request";
			}
		return "You are not allowed to send request to this user, please send your request to Manager";
			
	}
}
