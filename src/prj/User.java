package prj;


public abstract class User{
    
    private String name;
    private String surname;
    private String login;
    private String password;
    public String id = "19B";
    
    public User() {}
    
    public User(String name, String surname, String login, String password) {
    	this.name = name;
    	this.surname = surname;
    	this.login = login;
    	this.password = password;
    }

    public User(String id) {
    	this.id = id;
    }
 
    public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

    /** a method to send the messages
     * @param userTo is the user who you want to send message
     * @param body is text of message
     * 
     * */
	public String sendMessage(User userTo, String body) {
		for(User u : Database.getInstance().users) {
			if(u.getId().equals(userTo.getId())) {
				Message m = new Message(userTo, body);
				m.setUserFrom(this);
				Database.getInstance().messages.add(m);
				return "You send message";
			}	
		}
		return "No such user";
	}
	
	/** a method to view all messages that you have
     * */
	public String viewMessage() {
		for(Message m : Database.getInstance().messages) {
			if(m.getUserTo().getId().equals(this.getId())) {
				return "Message: " + m.getBody() + "\n" + 
						"Message from: " + m.getUserFrom().name + " " + m.getUserFrom().surname;
			}
		}
		return "You don't have messages";
	}
	
	/** a method to view all news
     * */
	public String viewNews() {
		for(News n : Database.getInstance().news) {
			return "News: " + n.getTitle() + " " + n.getDate();
		}
		return "No news yet";
	}
	
	/** a method to generate password
     * */
	public void generatePassword() {
		String password = this.getName() + this.hashCode();
		this.setPassword(password);
		
	}
    
	/** a method to generate login
     * */
	public void generateLogin() {
		String login = this.getName().charAt(0) + "." + this.getSurname();
		this.setLogin(login);
	}
	
	/** a method to generate id
	 * @param id is id of user for who you want generate id
     * */
	public void generateId(User user) {
		String id = this.id + Database.getInstance().users.indexOf(user);
		this.setId(id);
	}
	
	//getters and setters
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return this.surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   
    
    
    public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

 

    @Override
	public String toString() {
		return "[name=" + name + ", surname=" + surname + ", login=" + login + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
