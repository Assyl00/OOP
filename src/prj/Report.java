package prj;

import java.util.Vector;

public class Report {
	private Vector<Double> gpa;
	public Report() {
		
	}
	
	public void add(Database data) {
        gpa.add(Database.students.getGpa());
        
    }
	@SuppressWarnings("null")
	public double averageGpa(Vector<Double> gpa) {
		Double sum = null, avg;
		for (Double x : gpa){
			sum += x;
	    }	
		avg = (sum/gpa.size());
		return avg;
	}
}
