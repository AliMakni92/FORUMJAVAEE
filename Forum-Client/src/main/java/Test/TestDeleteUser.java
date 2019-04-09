package Test;

import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

public class TestDeleteUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user=AccountManagementServiceDelegate.dofindUserById(10);
			AccountManagementServiceDelegate.dodeleteUser(user);
	}

}
