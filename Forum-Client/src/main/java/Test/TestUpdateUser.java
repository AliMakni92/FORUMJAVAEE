package Test;


import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

public class TestUpdateUser {
	public static void main(String[] args) {
		
		User moderator=AccountManagementServiceDelegate.dofindUserById(2);
		moderator.setPassword("");
		moderator.setEmail("aa@ee.tt");
		moderator.setUsername("cc");
		AccountManagementServiceDelegate.doUpdateUser(moderator);
	}
}
