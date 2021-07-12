package prj;



public class Request {
	public String title;
	public String body;
	public boolean isAssignedByRector;
	
	Request(){}
	
	
	public Request(String title, String body, boolean isAssignedByRector) {
		super();
		this.title = title;
		this.body = body;
		this.isAssignedByRector = isAssignedByRector;
	}
	
	public Request(String title, String body) {
		super();
		this.title = title;
		this.body = body;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public boolean isAssignedByRector() {
		return isAssignedByRector;
	}
	public void setAssignedByRector(boolean isAssignedByRector) {
		this.isAssignedByRector = isAssignedByRector;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + (isAssignedByRector ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Request other = (Request) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (isAssignedByRector != other.isAssignedByRector)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Request [title=" + title + ", body=" + body + ", isAssignedByRector=" + isAssignedByRector + "]";
	}
	
	
}
