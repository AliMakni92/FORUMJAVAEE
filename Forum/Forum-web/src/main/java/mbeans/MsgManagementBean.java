package mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import Entities.Message;
import Entities.User;
import Services.AccountManagementServicesLocal;
import Services.MessageServiceLocal;
import Util.Utils;






@ManagedBean
@SessionScoped
public class MsgManagementBean {
	@EJB
	private AccountManagementServicesLocal accountManagementServicesLocal;
	@EJB
	private MessageServiceLocal messageServiceLocal;
	//Model
	private User user= new User();
	private User userselected= new User();
	private List<User> allUsers = new ArrayList<>();
	private List<Message> messagebyReceiver = new ArrayList<>();
	private List<Message> allMessages=new ArrayList<>();
	private Boolean formVisibility = false;
	private String messageselected ;
	private String objet;
	private User usersersender;
	private User userreceiver;
	private Message message = new Message();
	private String text;
	private String object_message;
	@ManagedProperty("#{identity}")
	private Identity identity;
	@PostConstruct
	public void init(){
		userreceiver= new User();
		//userreceiver=identity.getUser();
	//	userreceiver.setUsername(userreceiver.getUsername());a
		usersersender=new User();
		usersersender=identity.getUser();}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getObject_message() {
		return object_message;
	}


	public void setObject_message(String object_message) {
		this.object_message = object_message;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Message> getMessagebyReceiver() {
		messagebyReceiver=messageServiceLocal.findAllMessagesBySender(identity.getUser());
		return messagebyReceiver;
	}

	public void setMessagebyReceiver(List<Message> messagebyReceiver) {
		this.messagebyReceiver = messagebyReceiver;
	}

	public String getMessageselected() {
		return messageselected;
	}
	public void setMessageselected(String messageselected) {
		this.messageselected = messageselected;
	}
	public AccountManagementServicesLocal getAccountManagementServicesLocal() {
		return accountManagementServicesLocal;
	}
	public void setAccountManagementServicesLocal(AccountManagementServicesLocal accountManagementServicesLocal) {
		this.accountManagementServicesLocal = accountManagementServicesLocal;
	}
	public MessageServiceLocal getMessageServiceLocal() {
		return messageServiceLocal;
	}
	public void setMessageServiceLocal(MessageServiceLocal messageServiceLocal) {
		this.messageServiceLocal = messageServiceLocal;
	}
	public List<Message> getAllMessages() {
		allMessages=messageServiceLocal.findAllMessagesByReceiver(identity.getUser());
		return allMessages;
	}
	public void setAllMessages(List<Message> allMessages) {
		this.allMessages = allMessages;
	}
	public User getUsersersender() {
		return usersersender;
	}
	public void setUsersersender(User usersersender) {
		this.usersersender = usersersender;
	}
	public User getUserreceiver() {
		return userreceiver;
	}
	public void setUserreceiver(User userreceiver) {
		this.userreceiver = userreceiver;
	}
	public List<User> getAllUsers() {
		allUsers = accountManagementServicesLocal.findAllUser();
		return allUsers;
	}
	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Boolean getFormVisibility() {
		return formVisibility;
	}
	public void setFormVisibility(Boolean formVisibility) {
		this.formVisibility = formVisibility;
	}
	public void changeVisibility() {
		formVisibility = true; 
	}
	public User getUserselected() {
		return userselected;
	}
	public void setUserselected(User userselected) {
		this.userselected = userselected;
	}
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}
	
	
	public String doAddMessage(String messageselected,String objet,User userselected) {
		String navigateTo="";
		//usersersender=(User)identity.getUser();
		//messageServiceLocal.AddMessage(messageselected.getText(),messageselected.getObject_message(), usersersender, userreceiver);
	
		//	messageServiceLocal.AddMessage(text, object_message, usersersender, userreceiver);
		messageServiceLocal.AddMessage(messageselected, objet, identity.getUser(), userselected);
		System.out.println("************************************");
		navigateTo="/pages/user/sendMessage.jsf";
		return navigateTo;

	}



}
