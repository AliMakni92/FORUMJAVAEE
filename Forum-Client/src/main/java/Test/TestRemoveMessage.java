package Test;

import Entities.Message;
import Entities.MessageId;
import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;
import businessDelegate.MessageServiceDelegate;

public class TestRemoveMessage {
public static void main(String[] args) {
		
		User user=AccountManagementServiceDelegate.dofindUserByUsername("admin");
		User user1=AccountManagementServiceDelegate.dofindUserById(6);
		//MessageId messageId = new MessageId(user.getId(), user1.getId());
		Message message = new Message(user, user1);
		//MessageId messageId= new MessageId(9, 10);
	//	Message message=new Message(messageId, "ya bhim","Sabben", user, user1);
		MessageServiceDelegate.DeleteMessage(message);
		
	}
}
