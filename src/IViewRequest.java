
public interface IViewRequest {
	String viewRequest(Request req);
	default String viewAllRequests() {
		return Database.getInstance().requests.toString();
	}
}
