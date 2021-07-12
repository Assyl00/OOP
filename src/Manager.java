
import java.util.Objects;
import java.util.Set;

public class Manager extends User implements ISendRequest, IViewRequest{
    
	// fields 
    private ManagerType type;
    private Report report;
    private Set<Request> requests;
    private News news;
    private Message message;
    
    Manager(){}
    
    Manager(String name, String surname, String login, String password, ManagerType type){
    	super(name, surname, login, password);
    	this.type = type;
    }
    
    Manager(String id){
    	super(id);
    }
    // main methods
    
    public void assignTeachersForCourses(Course course, Teacher teacher, LessonType lessonType) {
    	switch(lessonType) {
    	case PRACTICE:
    		course.setPracticeTeacher(teacher);
    		break;
    	
    	case LECTURE:
    		course.setLectureTeacher(teacher);
    		break;
    		
    	case PRACTICEANDLECTURE:
    		course.setPracticeTeacher(teacher);
    		course.setLectureTeacher(teacher);
    		break;
    	}
    }

    public void addCourseToRegistration(Course course) {
    	Database.getInstance().coursesForRegistration.add(course);
    }

    public String viewInfoAboutStudent(Student student) throws ClassNotFoundException{
    	return student.toString();
    }

    public String viewInfoAboutTeacher(Teacher teacher) throws ClassNotFoundException{
        return teacher.toString();
    }

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

    public void addNews(News news) {
        Database.getInstance().news.add(news);
    }

    public void removeNews(News news) throws ClassNotFoundException{
        Database.getInstance().news.remove(news);
    }

    public Report statisticalReportsOnAcademicPerformance(Course course, Teacher teacher) {
        //course.get
    	return this.report;
    }

    public String viewRequests() {
        return "Requests: " + this.getRequests();
    }
    
    public String setStatus(MarkingPeriod status) {
    	Database.getInstance().status = status;
    	return "Current status is " + status;
    }
    
//    public String generateId(User user) {
//    	return super.generateId(user) + "m";
//    }
    
    
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

    public Message getMessage() {
        return this.message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    
    public Report getReport() {
        return this.report;
    }
    
    public void setReport(Report report) {
        this.report = report;
    }

    public News getNews() {
        return this.news;
    }

    public void setNews(News news) {
        this.news = news;
    }
    
    // default methods


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return super.toString();
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
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String sendRequest(User userTo, Request req) {
		if(userTo instanceof Admin) {
			for(Request r : Database.getInstance().requests) {
				if(!r.equals(req)) {
					Database.getInstance().requests.add(req);
					return "You succesfully send request";
				}
			}
			
		}
		return "You are not allowed to send request to this user, please send your request to Admin";
	}

	@Override
	public String viewRequest(Request req) {
		for(Request r : Database.getInstance().requests) {
			if(r.equals(req)) {
				
				return r.toString();
			}
		}
		return "No such request";
	}


	
}

