package Test;

import java.util.List;

import Entities.Message;
import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;
import businessDelegate.MessageServiceDelegate;

public class TestfindMessageBySenderReceiver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = AccountManagementServiceDelegate.dofindUserById(1);
		User user1 = AccountManagementServiceDelegate.dofindUserById(6);
		Message message=MessageServiceDelegate.findByMessagebySenderReceiver(user, user1);
		System.out.println(message.getText());
	}
}
