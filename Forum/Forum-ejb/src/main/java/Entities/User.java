package Entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class User implements Serializable,CallbackHandler{

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private Date dateOfBirth;
	private String role;
	private boolean enabled;
	private ResponsibilityOf responsibleOf;
	 
  
	@OneToMany(mappedBy="userSender")
	private List<Message> messagesSent;
	
	@OneToMany(mappedBy="userReceiver")
	private List<Message> messagesReceived;
	
	@OneToMany(mappedBy="user")
	private List<Rating> ratings;
	
	@OneToMany(mappedBy="user")
	private List <Comment> comments;
	
	@OneToOne(mappedBy="user")
	private Favorites favorites;
	
	public Favorites getFavorites() {
		return favorites;
	}
	public void setFavorites(Favorites favorites) {
		this.favorites = favorites;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public List<Message> getMessagesSent() {
		return messagesSent;
	}
	public void setMessagesSent(List<Message> messagesSent) {
		this.messagesSent = messagesSent;
	}
	public List<Message> getMessagesReceived() {
		return messagesReceived;
	}
	public void setMessagesReceived(List<Message> messagesReceived) {
		this.messagesReceived = messagesReceived;
	}
	public List<Message> getMessages() {
		return messagesSent;
	}
	public void setMessages(List<Message> messages) {
		this.messagesSent = messages;
	}

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}   
	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public User(String username, String password) {
		if (username == null) {
		     throw new NullPointerException("NULL user name");
	}
		if (password == null) {
		     throw new NullPointerException("NULL password");
	}
		this.username = username;
		this.password = password;
	}
	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	
	public ResponsibilityOf getResponsibleOf() {
		return responsibleOf;
	}
	public void setResponsibleOf(ResponsibilityOf responsibleOf) {
		this.responsibleOf = responsibleOf;
	}
	public User(String username) {
		
			  
		this.username = username;
	}
	
	@Override
	public void handle(Callback[] callbackArray) throws IOException, UnsupportedCallbackException {
//		System.out.println("callbackhandler ...");
		NameCallback nameCallback = null;
		PasswordCallback passwordCallback = null;
		int counter = 0;
		while (counter < callbackArray.length) {
			if (callbackArray[counter] instanceof NameCallback) {
				nameCallback = (NameCallback) callbackArray[counter++];
				System.out.println(nameCallback.getPrompt());
				nameCallback.setName(username);

			} else if (callbackArray[counter] instanceof PasswordCallback) {
				passwordCallback = (PasswordCallback) callbackArray[counter++];
				System.out.println(passwordCallback.getPrompt());
				passwordCallback
						.setPassword(password.toCharArray());
			}
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
	
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((responsibleOf == null) ? 0 : responsibleOf.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled != other.enabled)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (responsibleOf != other.responsibleOf)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
	
}
