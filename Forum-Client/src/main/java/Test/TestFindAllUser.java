package Test;

import java.util.List;

import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

public class TestFindAllUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<User> users = AccountManagementServiceDelegate.dofindAllUser();
		for (User u : users) {
			System.out.println(u.getUsername());
		}
	}

}
