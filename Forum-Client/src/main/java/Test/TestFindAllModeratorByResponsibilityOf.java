package Test;

import java.util.List;

import Entities.ResponsibilityOf;
import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

public class TestFindAllModeratorByResponsibilityOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String responsibleOf="Movies";
		List<User> moderators =AccountManagementServiceDelegate.dofindAllUserByResponsibilityOf(ResponsibilityOf.GAMES);
		for (User m : moderators) {
	System.out.println(m.getLastName());
		}
	}

}
