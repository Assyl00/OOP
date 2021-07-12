package prj;

import java.util.Iterator;
import java.util.Vector;

public class Admin extends User implements IViewRequest{
    
    public Admin() {};
    
    public Admin(String name, String surname, String login, String password) {
    	super(name, surname, login, password);
    }
    
    Admin(String id){
    	super(id);
    }
    
    // main methods
    
    /**
     * method to add users
     * @param userType is a type of user
     * @param name is name of new user
     * @param surname is surname of new user
     * */
    public User addUser(String userType, String name, String surname) {
    	User user = UserFactory.getUser(userType);
    	Database.getInstance().users.add(user);
    	user.setName(name);
    	user.setSurname(surname);
    	user.generateLogin();
    	user.generatePassword();
    	user.generateId(user);
    	return user;
    }
    
    /**
     * method to remove users
     * @param user is user that you want to remove
     * */
    public void removeUser(User user) {

    	Database.getInstance().users.remove(user);

    }
    
    /**
     * method to see when user login
     * @param user is user which log files we want to see
     * */
    public void seeLogFilesAboutUser(User user) {
        for(String log : Database.getInstance().logs) {
        	if(log.contains(user.getLogin())) {
        		System.out.println(log); 
        	}
        }
    }
//    public Vector<String> seeLogFilesAboutUser() {
//        return Database.getInstance().logs;
//    }
//    
    public void updateUser(String id, String name, String surname) {
    	for(User u : Database.getInstance().users) {
			if(u.getId().equals(id)) {
				u.setName(name);
		    	u.setSurname(surname);
//		    	u.setLogin(login);
//		    	u.setPassword(password);
			}
		}
    }
    
    /**
     * method to sign request by rector
     * @param req is req that we want to assign
     * */
    public String assignRequest(Request req) {
		for(Request r : Database.getInstance().requests) {
			if(r.equals(req)) {
				r.isAssignedByRector = true;
				return r.toString() + "------------" + "Request is assigned by rector";
			}
		}
		return "No such request";
	}
    
    // default methods


    @Override
	public String toString() {
		return "Admin " + super.toString();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}


	

}

