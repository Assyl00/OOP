package prj;



import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

public class Teacher extends User implements ISendRequest {
   
    private Position position;
    private Vector<CourseFile> courseFiles = new Vector<>();
    private Vector<Course> courses = new Vector<>();
	public Vector<Double> points = new Vector<>();
	public Vector<Book> books = new Vector<>();
    
    Teacher(){}
    
    Teacher(String name, String surname, String login, String password){
    	super(name, surname, login, password);

    }
//    
    Teacher(String id){
    	super(id);
    }
    
	 
    // main methods 
    
    /** a method to add course file
     * @param course is course for which we want to add course file 
     * @param title is title of course file that teacher want to add
     * @param body is body of course file that teacher want to add
     * */
    public void addCourseFile(Course course, String title, String body) {
    	CourseFile cf = new CourseFile(title, body);
    	course.getCourseFiles().add(cf);
    	
//        this.courseFiles.add(cf);
    }
    
    /** a method to remove course file
     * @param courseFile is course file which teacher want to remove
     * */
    public void removeCourseFiles(CourseFile courseFile) {
    	this.courseFiles.remove(courseFile);
//    	for(CourseFile cf : course.getCourseFiles()) {
//    		if(cf.getTitle().equals(courseFile.getTitle())) {
//    			course.getCourseFiles().remove(courseFile);
//    		}
//    	}
    } 

    /** a method to view course students
     * @param course is course which students teacher want to remove
     * */
    public String viewCourseStudents(Course course) {
    	return course.students.toString();
    }

    /** a method to put marks to students
     * @param course is course for which teacher wants to put mark
     * @param mark is the mark that teacher wants to put to the student
     * */
    public void putMarks(Course course, Student student, TypeMark mark) {
    	for(User s : Database.getInstance().users) {
    		if(s.getId().equals(student.getId())){
    			((Student) s).getTranscript().getMarks().put(course, mark);
    		}
    	}
        
    }

    /** a method to sort students by name 
     * @param course is course which students teacher wants to sort
     * */
    public void sortStudents(Course course) {//tester
    	Collections.sort(course.students, new NameComparator());
    }
    
    /** a method to send request to user 
     * @param userTo is user that you want to send request
     * @param req is a request that you want to send
     * */
	@Override
	public String sendRequest(User userTo, Request req) {
		if(userTo instanceof Manager) {
				Database.getInstance().requests.add(req);
				return "You succesfully send request";
			}
		return "You are not allowed to send request to this user, please send your request to Manager";
			
	}
    
    // getters and setters
    
	public Vector<Course> getCourses() {
    	return this.courses;
    }
    
    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    
    public Vector<CourseFile> getCourseFiles() {
        return this.courseFiles;
    }


    public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}
    
    
    // default methods 
    
    @Override
	public String toString() {
		return "Teacher " + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
//		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((courseFiles == null) ? 0 : courseFiles.hashCode());
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
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
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (!points.equals(other.points))
			return false;
		if (position != other.position)
			return false;
		return true;
	}


}
