package mbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import Entities.ResponsibilityOf;
import Entities.User;
import Services.AccountManagementServicesLocal;



@ManagedBean
@SessionScoped
public class Identity {
    FacesMessage message = null;
    private List<User> users = new ArrayList<>();
    private User userselected= new User();
	private Boolean formVisibility = false;
	public User getUserselected() {
		return userselected;
	}
	public void setUserselected(User userselected) {
		this.userselected = userselected;
	}
	String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@EJB
	private AccountManagementServicesLocal accountManagementServicesLocal;
	public static  User connected=null;
	public AccountManagementServicesLocal getAccountManagementServicesLocal() {
		return accountManagementServicesLocal;
	}
	public void setAccountManagementServicesLocal(AccountManagementServicesLocal accountManagementServicesLocal) {
		this.accountManagementServicesLocal = accountManagementServicesLocal;
	}
	public static User getConnected() {
		return connected;
	}
	public static void setConnected(User connected) {
		Identity.connected = connected;
	}
	private Boolean loggedInAsUser = false;
	private User user = new User();
	private boolean isLogged = false;
	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = accountManagementServicesLocal.Authentification(user.getUsername(), user.getPassword());
		userLoggedIn=accountManagementServicesLocal.findUserByUsername(user.getUsername());
		if(userLoggedIn==null){
			message=new FacesMessage("Error","login or password incorrect!");
		
			FacesContext.getCurrentInstance().addMessage("login_form:txt_login", message);		
			 navigateTo = "failure";
			
			} else {
				if (userLoggedIn != null) {
			isLogged = true;
			user = userLoggedIn;
			if ((userLoggedIn .getRole().equals("user"))&&(userLoggedIn.getEnabled()==true)) {
				loggedInAsUser = true;
				//return "success?faces-redirect=true";
			//	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", userLoggedIn.getUsername());
				navigateTo = "/pages/user/home?faces-redirect=true";
				 
			}
			else if (userLoggedIn .getRole().equals("moderator")) {
				if((userLoggedIn.getEnabled()==true)&&(userLoggedIn.getResponsibleOf()==ResponsibilityOf.MOVIES)){
				loggedInAsUser = true;
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", userLoggedIn.getUsername());
				navigateTo = "/pages/moderator/homemovies?faces-redirect=true";
				}else if ((userLoggedIn.getEnabled()==true)&&(userLoggedIn.getResponsibleOf()==ResponsibilityOf.GAMES)){
					loggedInAsUser = true;
					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", userLoggedIn.getUsername());
					navigateTo = "/pages/moderator/homegames?faces-redirect=true";
				}
			}else if ((userLoggedIn.getEnabled()==true)&&(userLoggedIn.getResponsibleOf()==ResponsibilityOf.TV)){
				loggedInAsUser = true;
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", userLoggedIn.getUsername());
				navigateTo = "/pages/moderator/hometv?faces-redirect=true";
			
			}
		else if ((userLoggedIn.getEnabled()==true)&&(userLoggedIn.getResponsibleOf()==ResponsibilityOf.MUSIC)){
			loggedInAsUser = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", userLoggedIn.getUsername());
			navigateTo = "/pages/moderator/homemusic?faces-redirect=true";
		
		}else if (userLoggedIn.getEnabled()==false){
			loggedInAsUser = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"NON_AUTORISE",null));
			 message=new FacesMessage("Error","You are blocked!");
				FacesContext.getCurrentInstance().addMessage(null, message);	
				navigateTo = "blocked";
		}
				
		
		
		}
			}	
				
		return navigateTo;
		
	}
	public String logout() {
		isLogged = false;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedInAsUser() {
		return loggedInAsUser;
	}

	public void setLoggedInAsUser(Boolean loggedInAsUser) {
		this.loggedInAsUser = loggedInAsUser;
	}

	  public void info() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
	    }
	public boolean isLogged() {
		return isLogged;
	}
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	
	
	public boolean sendPwd() {
		
		User citizen = accountManagementServicesLocal.recuppererMotDePasse(email);
		if (citizen != null) {
			final String username = "FMS@esprit.com";
			final String password = "AAAAaaaa";
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");

			Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("ali.makni@esprit.tn"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				message.setSubject("Password Recovery");
				message.setText("\n \n Votre nom d'utilisateur est: " + citizen.getUsername()
						+ "\n Votre mot de passe est: " + citizen.getPassword()
						+ "\n Merci de ne plus l'oublier la prochaine fois !\n Bonne Journée.");
				Transport.send(message);
				return true;

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}

		}
		return false;
	}
	
	

	public FacesMessage getMessage() {
		return message;
	}
	public void setMessage(FacesMessage message) {
		this.message = message;
	}

	@PostConstruct
	private void init() {
		user = new User();
		user.setRole("user");
		user.setEnabled(true);
	}
	public List<User> getUsers() {
		return users;
	}
	public void  doremoveUser(){
//		isLogged = true;
//		loggedInAsUser = true;
		accountManagementServicesLocal.deleteUser(user);
	
	}
	public void doSaveOrUpdateUser() {
		accountManagementServicesLocal.updateUser(userselected);
		setFormVisibility(false);
	}

	public List<User> dofindAllUser(){
		isLogged = true;
		loggedInAsUser = true;
		users = accountManagementServicesLocal.findAllUserNotAdminAndModerator(user.getRole());
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
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

}
