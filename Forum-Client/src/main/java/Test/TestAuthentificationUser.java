package Test;



import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

public class TestAuthentificationUser {
	public static void main(String[] args) {


	String username="admin";
	String password="admin";
		User user = AccountManagementServiceDelegate.doAuthentification(username, password);
String u=user.getUsername();
	System.out.println(u);
	}
}
