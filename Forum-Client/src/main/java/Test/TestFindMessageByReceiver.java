package Test;

import java.util.List;

import Entities.Message;
import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;
import businessDelegate.MessageServiceDelegate;

public class TestFindMessageByReceiver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user=AccountManagementServiceDelegate.dofindUserById(1);
		List<Message> messages = MessageServiceDelegate.findAllMessagesByReceiver(user);
		for (Message m : messages) {
			System.out.println(m.getText());
		}
	}

}
