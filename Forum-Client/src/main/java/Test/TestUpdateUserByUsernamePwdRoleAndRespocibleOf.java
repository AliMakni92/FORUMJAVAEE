package Test;

import javax.jws.soap.SOAPBinding.Use;

import Entities.ResponsibilityOf;
import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

public class TestUpdateUserByUsernamePwdRoleAndRespocibleOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username="haha";
		String password="haha";
		String role="user";
AccountManagementServiceDelegate.updateUser(8, username, password, role);
String username1="haha";
String password1="haha";
//String role1="user";
String responsibleOf1="";
AccountManagementServiceDelegate.updateUser1(9, username1, password1, "moderator", ResponsibilityOf.GAMES);
System.out.println("haha");
	}

}
