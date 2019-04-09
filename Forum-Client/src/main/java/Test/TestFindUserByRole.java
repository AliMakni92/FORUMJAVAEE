package Test;


import java.util.List;


import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

public class TestFindUserByRole {
	public static void main(String[] args) {
		String role="moderator";
		List<User> users =AccountManagementServiceDelegate.dofindAllUserByRole(role);
		for (User u : users) {
	System.out.println(u.getUsername());
	
		}	
	}
}
