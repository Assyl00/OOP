package prj;


public class UserFactory {
	
	/** a method to get new user depending on its user type
	 * @param userType is user type that you want to create
     * */
	public static User getUser(String userType) {
		if(userType == null) 
			return null;
		if(userType.equals("Student")) 
			return new Student();
		else if(userType.equals("Teacher")) 
			return new Teacher();
		else if(userType.equals("Manager")) 
			return new Manager();
		return null;
	}
}
