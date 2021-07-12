package prj;


public interface IViewRequest {
	default String viewAllRequests() {
		return Database.getInstance().requests.toString();
	}
}
