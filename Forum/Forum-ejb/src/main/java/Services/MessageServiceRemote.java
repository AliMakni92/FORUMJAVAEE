package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import Entities.Message;
import Entities.User;

@Remote
public interface MessageServiceRemote {
	 void AddMessage(String text,String object_message,User userSender, User userReceiver);
	
	boolean UpdateMessage(Message message);

	void SendMessageBySubscriber(Message message);

	List<Message> FindAllMessages();

	List<Message> findAllMessagesByReceiver(User user);

	List<Message> findAllMessagesBySender(User user);

	List<User> findUserSenderByMessage(Message message);

	Message findMessagesById(Integer id);

	List<Message> findMessagesByText(String text);

	int getNumberofmessagesbyUserbydate(String date1, String date2, User user);
	 List<Message> FindReceivedMessages(int id);
	 void removeMessage(Message message) ;
	   Message findMessagebyId(Integer id) ;
	   Message findMessagebytext(String text); 
	   Message findByMessagebySenderReceiver(User usersersender, User userreceiver) ;
	   

}
