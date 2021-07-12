package prj;

import java.io.*;

public class AdminTester {

	public static void main(String[] args, Admin a) throws NumberFormatException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
//		Admin a = (Admin)Auth.currentUser;
		Database db = Database.getInstance();
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Hey, admin!");
		
		main:while(true) {
			System.out.println("Choose what operation do you want to do:" + "\n1.Add user "
					+ "\n2.Remove user "
					+ "\n3.Update user "
					+ "\n4.View all users " 
					+ "\n5.View all reqeusts" 
					+ "\n6.Assign requests"
					+ "\n7.Send message"
					+ "\n8.See log files"
					+ "\n9.Back");
			int chosen = Integer.parseInt(bfr.readLine());
			if(chosen == 1) {
				System.out.println("Write what type of user you want to add");
				String userType = bfr.readLine();
				System.out.println("Name: ");
				String name = bfr.readLine();
				System.out.println("Surname: ");
				String surname = bfr.readLine();
				User u = a.addUser(userType, name, surname);
				System.out.println("Id of added user: " + u.getId());
				System.out.println("Password of user: " + u.getPassword());
				System.out.println("User was uccesfully added");
			}
			else if(chosen == 2) {
				System.out.println("Choose user that you want to delete: ");
				for(int i = 0; i < db.users.size(); i++) {
					System.out.println(1 + i + ")" + db.users.get(i));
				}
				int in = Integer.parseInt(bfr.readLine()) - 1;
		        User user = db.users.get(in);
//				String id = bfr.readLine();
				a.removeUser(user);
				
				System.out.println("User was succesfully removed");
			}
			else if(chosen == 3) {
				System.out.println("Write ID of user that you want update:");
				String id = bfr.readLine();
				System.out.println("Wrtie updated name:");
				String name = bfr.readLine();
				System.out.println("Write updated surname:");
				String surname = bfr.readLine();
				a.updateUser(id, name, surname);
				System.out.println("User was succesfully updated");
			}
			else if(chosen == 4) {
				for(int i = 0; i < db.users.size(); i++) {
					System.out.println(1 + i + ")" + db.users.get(i));
				}
			}
			else if(chosen == 5) {
				System.out.println(a.viewAllRequests());
			}
			else if(chosen == 6) {
				System.out.println("Choose request that you want to assign: ");
				for(int i = 0; i < db.requests.size(); i++) {
					System.out.println(1 + i + ")" + db.requests.get(i));
				}
				int in = Integer.parseInt(bfr.readLine()) - 1;
		        Request req = db.requests.get(in);
//				String id = bfr.readLine();
				
				
				System.out.println(a.assignRequest(req));
			}
			else if(chosen == 7) {
				
			}
			else if(chosen == 8) {
				System.out.println("Choose user: ");
				for(int i = 0; i < db.users.size(); i++) {
					System.out.println(1 + i + ")" + db.users.get(i));
				}
				int in = Integer.parseInt(bfr.readLine()) - 1;
		        User u = db.users.get(in);
		        a.seeLogFilesAboutUser(u);
//				System.out.println(a.seeLogFilesAboutUser());
				
			}
			else if(chosen == 9) {
				Auth.main(args);
			}
		}
	}

}
