

public class Message {
	private User userTo;
	private User userFrom;
	private String body;
	
	Message(){}
	
	Message(User userTo, String body){
		this.userTo = userTo;
		this.body = body;
	}

	public User getUserTo() {
		return userTo;
	}

	public void setUserTo(User userTo) {
		this.userTo = userTo;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public void setUserFrom(User userFrom) {
		this.userFrom = userFrom;
		
	}
	
	public User getUserFrom() {
		return this.userFrom;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((userTo == null) ? 0 : userTo.hashCode());
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
		Message other = (Message) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (userTo == null) {
			if (other.userTo != null)
				return false;
		} else if (!userTo.equals(other.userTo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [userTo=" + userTo + ", body=" + body + "]";
	}
	
	
	
}
