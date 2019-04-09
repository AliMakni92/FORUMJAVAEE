package businessDelegate;

import java.util.List;

import Entities.Message;
import Entities.MessageId;
import Entities.User;
import ServiceLocator.ServiceLocator;
import Services.MessageServiceRemote;

public class MessageServiceDelegate {
	
	
	private static String jndiName ="Forum-ear/Forum-ejb/MessageService!Services.MessageServiceRemote";
	public static MessageServiceRemote getProxy() {
		return (MessageServiceRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
		
	}
	public static void AddMessage(String text,String object_message,User userSender, User userReceiver){
		getProxy().AddMessage(text,object_message,userSender,userReceiver);
	}
	public static void UpdateMessage(Message message ){
		getProxy().UpdateMessage(message);
	}
	public static void DeleteMessage(Message message ){
		getProxy().removeMessage(message);
	}
	public static void SendMessageBySubscriber(Message message){
		getProxy().SendMessageBySubscriber(message);
	}
	public static Message findByMessagebySenderReceiver(User usersersender, User userreceiver){
		return getProxy().findByMessagebySenderReceiver(usersersender, userreceiver);
	}
	public static List<Message> FindAllMessages(){
		return getProxy().FindAllMessages();
	}
	public static List<Message> findAllMessagesByReceiver(User user){
		return getProxy().findAllMessagesByReceiver(user);
	}
	public static List<Message> findAllMessagesBySender(User user){
		return getProxy().findAllMessagesBySender(user);
	}
	
	public static List<User> findUserSenderByMessage(Message message){
		return getProxy().findUserSenderByMessage(message);
	}
	public static  Message findMessagesById(Integer id){
		return getProxy().findMessagesById(id);
	}
	public static List<Message> findMessagesByText(String text){
		return getProxy().findMessagesByText(text);
	}
	public static int getNumberofmessagesbyUserbydate(String date1, String date2, User user) {
		return getProxy().getNumberofmessagesbyUserbydate(date1, date2, user);
	}
}
