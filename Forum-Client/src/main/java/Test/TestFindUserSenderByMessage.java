package Test;


import java.util.List;

import Entities.Message;
import Entities.MessageId;
import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;
import businessDelegate.MessageServiceDelegate;

public class TestFindUserSenderByMessage {
	public static void main(String[] args) {
		User userReceiver =AccountManagementServiceDelegate.dofindUserById(6);
		User userSender =AccountManagementServiceDelegate.dofindUserById(1);
		MessageId messageId = new MessageId(1, 6);
		Message message =new Message(messageId,"Hello Word", userSender, userReceiver);
		List<User> users =MessageServiceDelegate.findUserSenderByMessage(message);
		for(User u :users){
			System.out.println(u.getEmail());
		}
	
			
	}
}
