package Test;

import java.util.ArrayList;
import java.util.List;

import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

public class TestListAlphabeticallyUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<User> users = AccountManagementServiceDelegate.dofindAllUser();
ArrayList<User> usersal=AccountManagementServiceDelegate.dolistAlphabetically((ArrayList<User>) users);
for (User u : usersal) {
	System.out.println(u.getUsername());
}
	}

}
