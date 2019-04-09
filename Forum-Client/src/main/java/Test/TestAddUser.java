package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Entities.ResponsibilityOf;
import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

public class TestAddUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User moderator = new User();
		moderator.setFirstName("Ali");
		moderator.setLastName("Makni");
		Date naissancemod;
		try {
			naissancemod = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-15 17:05:17");
			moderator.setDateOfBirth(naissancemod);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moderator.setEnabled(true);
		moderator.setPassword("Ali");
		moderator.setRole("moderator");
		moderator.setUsername("ali");
		moderator.setResponsibleOf(ResponsibilityOf.MOVIES);
		moderator.setEmail("aa@ee.tt");
		AccountManagementServiceDelegate.doAddUser(moderator);
		System.out.println("ya ali");
	}

}
