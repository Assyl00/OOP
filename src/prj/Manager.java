package prj;


import java.util.Objects;
import java.util.Set;

public class Manager extends User implements ISendRequest, IViewRequest{
    
	// fields 
    private ManagerType type;
    private Report report;
    private Set<Request> requests;
//    private News news;
//    private Message message;
    
    Manager(){}
    
    Manager(String name, String surname, String login, String password, ManagerType type){
    	super(name, surname, login, password);
    	this.type = type;
    }
    
    Manager(String id){
    	super(id);
    }
    // main methods
    
    /**
     * method to assign teachers for courses
     * @param course is the course that you want to assign 
     * @param teacher is teacher that you want to assign for course
     * @param lessonType is the type of course
     */
    public void assignTeachersForCourses(Course course, Teacher teacher, LessonType lessonType) {
    	switch(lessonType) {
    	case PRACTICE:
    		course.setPracticeTeacher(teacher);
    		teacher.getCourses().add(course);
    		break;
    	
    	case LECTURE:
    		course.setLectureTeacher(teacher);
    		teacher.getCourses().add(course);
    		break;
    		
    	case PRACTICEANDLECTURE:
    		course.setPracticeTeacher(teacher);
    		course.setLectureTeacher(teacher);
    		teacher.getCourses().add(course);
    		break;
    	}
    }

    /**
     * method to add course to registration
     * @param course is the course that you want to add 
     */
    public void addCourseToRegistration(Course course) {
    	Database.getInstance().coursesForRegistration.add(course);
    	Database.getInstance().courses.add(course);
    }

    /**
     * method to view information about user
     * @param user is user that you want to see the information
     */
    public String viewInfoAboutUser(User user) throws ClassNotFoundException{
    	return user.toString();
    }

    /**
     * method to approve student's registration for courses
     * @param student is student that you want to approve
     * @param course is course for which student want to register
     */
    public String approveStudentRegistration(Student student, Course course) {
    	if(student.registrationCourses.contains(course)) {
	        if(student.getCredits() <= 21) {
	        	student.courses.add(course);
	        	student.credits += course.getCredits();
	        	course.students.add(student);
	        	return "Succesfully registrated";
	        }else
	        	return "Too many credits";
    	}else
    		return "Do not registered for this course";
    }

    /**
     * method to add news
     * @param news is news that you want to add
     */
    public void addNews(News news) {
        Database.getInstance().news.add(news);
    }

    /**
     * method to remove news
     * @param news is news that you want to remove
     */
    public void removeNews(News news) throws ClassNotFoundException{
        Database.getInstance().news.remove(news);
    }

    /**
     * method to view statistical report on academic performance
     * @param course is course which you want to see the report
     * @param teacher is teacher who is teaching that course
     */
    public Report statisticalReportsOnAcademicPerformance(Course course, Teacher teacher) {
        //course.get
    	return this.report;
    }

    /** a method to send request to user 
     * @param userTo is user that you want to send request
     * @param req is a request that you want to send
     * */
    @Override
	public String sendRequest(User userTo, Request req) {
		if(userTo instanceof Admin) {
			return "You succesfully send request";
		}
		return "You are not allowed to send request to this user, please send your request to Admin";
	}


    /**
     * method to set status of attestation
     * @param status is a status that you want to set for choosen attestation
     */
    public String setStatus(String status) {//tester
    	Database.getInstance().status = status;
    	return "Current status is " + status;
    }
    
    /**
     * method to get average rate of teacher
     * @param teacher is a teacher that you want to get average rate
     */
    public double getRateOfTeacher(Teacher teacher) {//tester, presentation
    	double sum = 0;
    	for(Double p : teacher.points) {
    		sum += p;
    	}
    	double avg = sum/teacher.points.size();
    	return avg;
    }
    
    // getters and setters
    

    public ManagerType getType() {
        return this.type;
    }

    public void setType(ManagerType type) {
        this.type = type;
    }

    public Set<Request> getRequests() {
        return this.requests;
    }

    public void setRequest(Request request) {
        this.requests.add(request);
    }

    public Report getReport() {
        return this.report;
    }
    
    public void setReport(Report report) {
        this.report = report;
    }
    
    // default methods


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		return result;
	}

    @Override
	public String toString() {
		return "Manager " + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return true;
	}

	
	
}

