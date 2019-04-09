package Test;

import Entities.Message;
import Entities.MessageId;
import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;
import businessDelegate.MessageServiceDelegate;


public class TestSendMessageBySubscriber {
	public static void main(String[] args) {
		User user=AccountManagementServiceDelegate.dofindUserById(8);
		User user1=AccountManagementServiceDelegate.dofindUserById(10);
		MessageId messageId= new MessageId(10, 8);
		Message message=new Message(messageId, "ya 7ayawen","Sabben", user, user1);
		MessageServiceDelegate.SendMessageBySubscriber(message);
		
	}
	

}
