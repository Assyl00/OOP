package prj;

import java.util.HashMap;
import java.util.Vector;

public class Course {
	// fields
    private String name;
    private Teacher practiceTeacher;
    private Faculty Faculty;
    private int yearOfStudy;
    private Vector<CourseFile> courseFiles = new Vector<>();
    private Teacher lectureTeacher;
    public Vector<Student> students = new Vector<>();
    private int credits;
    
    
    public Course() {}
    
    public Course(String name, Teacher practiceTeacher, Faculty faculty, int yearOfStudy, 
    		Teacher lectureTeacher, int credits) {
    		super();
    		this.name = name;
    		this.practiceTeacher = practiceTeacher;
    		Faculty = faculty;
    		this.yearOfStudy = yearOfStudy;
//    		this.courseFiles = courseFiles;
    		this.lectureTeacher = lectureTeacher;
//    		this.lesson = lesson;
    		this.credits = credits;
    	}
    
    // main methods
    
    
    // getters and setters 
    
    public Vector<Student> getStudents() {
		return students;
	}

	public void setStudents(Vector<Student> students) {
		this.students = students;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Teacher getPracticeTeacher() {
        return this.practiceTeacher;
    }

    public void setPracticeTeacher(Teacher practiceTeacher) {
        this.practiceTeacher = practiceTeacher;
    }
    
    public Faculty getFaculty() {
        return this.Faculty;
    }

    public void setFaculty(Faculty Faculty) {
        this.Faculty = Faculty;
    }

    public int getYearOfStudy() {
        return this.yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Vector<CourseFile> getCourseFiles() {
        return this.courseFiles;
    }
    
    public void setCourseFiles(Vector<CourseFile> courseFiles) {
        this.courseFiles = courseFiles;
    }
    
    public Teacher getLectureTeacher() {
        return this.lectureTeacher;
    }
    public void setLectureTeacher(Teacher lectureTeacher) {
        this.lectureTeacher = lectureTeacher;
    }

    @Override
	public String toString() {
		return "Course [name=" + name + ", practiceTeacher=" + practiceTeacher + ", Faculty=" + Faculty
				+ ", yearOfStudy=" + yearOfStudy + ", lectureTeacher=" + lectureTeacher + ", credits=" + credits + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Faculty == null) ? 0 : Faculty.hashCode());
		result = prime * result + ((courseFiles == null) ? 0 : courseFiles.hashCode());
		result = prime * result + credits;
		result = prime * result + ((lectureTeacher == null) ? 0 : lectureTeacher.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((practiceTeacher == null) ? 0 : practiceTeacher.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		result = prime * result + yearOfStudy;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (Faculty != other.Faculty)
			return false;
		if (courseFiles == null) {
			if (other.courseFiles != null)
				return false;
		} else if (!courseFiles.equals(other.courseFiles))
			return false;
		if (credits != other.credits)
			return false;
		if (lectureTeacher == null) {
			if (other.lectureTeacher != null)
				return false;
		} else if (!lectureTeacher.equals(other.lectureTeacher))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (practiceTeacher == null) {
			if (other.practiceTeacher != null)
				return false;
		} else if (!practiceTeacher.equals(other.practiceTeacher))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		if (yearOfStudy != other.yearOfStudy)
			return false;
		return true;
	}
    
    

}
