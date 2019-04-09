package Test;

import java.util.List;

import Entities.Message;
import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;
import businessDelegate.MessageServiceDelegate;

public class TestFindMessageBySender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user=AccountManagementServiceDelegate.dofindUserById(1);
		List<Message> messages = MessageServiceDelegate.findAllMessagesBySender(user);
		for (Message m : messages) {
			System.out.println(m.getText());
		}
	}

}
