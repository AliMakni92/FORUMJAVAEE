package Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sun.mail.handlers.message_rfc822;

import Entities.Message;
import Entities.User;


/**
 * Session Bean implementation class MessageService
 */
@Stateless
@LocalBean
public class MessageService implements MessageServiceRemote, MessageServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public MessageService() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void AddMessage(String text,String object_message,User userSender, User userReceiver) {
    	Message message=new Message(text, object_message, userSender, userReceiver);
    	
    		entityManager.persist(message);
    		System.out.println("message envoyé");
	
		
	}
    
    @Override
   	public boolean UpdateMessage(Message message) {
    	try{
    		entityManager.merge(message);
		}catch(Exception e) {
    		System.out.println("Update problem");
			return false;	
		}
		return true;
   	}
    public void DeleteMessage(Message message)
    {
    	entityManager.remove(message);
    }
  
    @Override
	public Message findMessagebyId(Integer id) {
		return entityManager.find(Message.class, id);
	}
    @Override
	public Message findMessagebytext(String text) {
		return entityManager.createQuery("select a from Message a where a.text=?1",Message.class).setParameter(1, text).getSingleResult();
	}
    @SuppressWarnings("unchecked")
	@Override
	public List<Message> FindAllMessages() {
	return(List<Message>) entityManager.createQuery("select m from Message m ")
	   .getResultList();	
	} 
    @SuppressWarnings("unchecked")
    @Override
	public List<Message> findAllMessagesByReceiver(User user) {
		return entityManager
				.createQuery("SELECT m FROM Message m  where m.userReceiver=:p", Message.class)
				.setParameter("p", user).getResultList();
	}
    @SuppressWarnings("unchecked")
	@Override
	public List<Message> findAllMessagesBySender(User user) {
		return entityManager
				.createQuery("SELECT m FROM Message m  where m.userSender=:p", Message.class)
				.setParameter("p", user).getResultList();
	}
    @Override
	public Message findByMessagebySenderReceiver(User usersersender, User userreceiver) {
 return entityManager.createQuery ("select a from Message a where a.messageId.idSender=?1 AND a.messageId.idReceiver=?2" , Message.class).setParameter(1, usersersender.getId()).setParameter(2, userreceiver.getId()).getSingleResult();
	}

	
	
	
	
	@Override
	public void SendMessageBySubscriber(Message message) {	
		
		entityManager.persist(entityManager.merge(message));
		
	}

	@Override
	public List<Message> findMessagesByText(String text) {
		return entityManager
				.createQuery("SELECT m FROM Message m  where m.text=:p", Message.class)
				.setParameter("p", text).getResultList();
	}
	
	@Override
	public Message findMessagesById(Integer id) {
		return entityManager.find(Message.class, id);
	}
	@Override
	public List<User> findUserSenderByMessage(Message message) {
		return entityManager
				.createQuery("SELECT u FROM User u inner join u.messagesSent mt where mt.id=:p", User.class)
				.setParameter("p", message).getResultList();
	}
	
public List<Message> FindReceivedMessages(int id) {
		
		Query queryfindmessagesbyreceiver = entityManager.createNamedQuery("select m from Message "
				+ "m where m.userSender.id=:value");
		queryfindmessagesbyreceiver .setParameter("value",id);
		return queryfindmessagesbyreceiver.getResultList();
	}
@Override
public void removeMessage(Message message) {
	//message = new Message(messageId, userSender, userReceiver)
	 entityManager.remove(message);
	
}
	
	@Override
	public int getNumberofmessagesbyUserbydate(String date1, String date2, User user) {
		Query querygetcountmessagesbydate = entityManager.createQuery("SELECT count(m) FROM Message m WHERE m.date_send BETWEEN :date1 AND :date2"
			+ " and m.userSender.id=:p");
		querygetcountmessagesbydate .setParameter("date1",date1);
		querygetcountmessagesbydate .setParameter("date2",date2);
		querygetcountmessagesbydate .setParameter("p",user.getId());
		int result=((Long)querygetcountmessagesbydate .getSingleResult()).intValue();
		return result;
	}
}
