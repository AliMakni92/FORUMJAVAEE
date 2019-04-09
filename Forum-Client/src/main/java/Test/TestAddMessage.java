package Test;

import Entities.Message;
import Entities.MessageId;
import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;
import businessDelegate.MessageServiceDelegate;


public class TestAddMessage {
	public static void main(String[] args) {
		
		User user=AccountManagementServiceDelegate.dofindUserByUsername("admin");
		User user1=AccountManagementServiceDelegate.dofindUserById(9);
		//Message message = new Message("ya bhim", "Sabben", user, user1);
		//MessageId messageId= new MessageId(9, 10);
	//	Message message=new Message(messageId, "ya bhim","Sabben", user, user1);
		MessageServiceDelegate.AddMessage("ya bhim", "sabben", user, user1);
		
	}
	

}
