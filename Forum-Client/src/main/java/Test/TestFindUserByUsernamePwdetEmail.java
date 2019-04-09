package Test;

import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

public class TestFindUserByUsernamePwdetEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username="admin";
				User user=AccountManagementServiceDelegate.dofindUserByUsername(username);
				String password="moderator";
				User user1=AccountManagementServiceDelegate.dofindUserByPassword(password);
				String email="ali.makni@esprit.tn";
				User user2=AccountManagementServiceDelegate.dofindUserByEmail(email);
				String u=user.getEmail();
				String u1=user1.getEmail();
				String u2=user2.getEmail();
		System.out.println(u);
		System.out.println(u1);
		System.out.println(u2);
	}

}
