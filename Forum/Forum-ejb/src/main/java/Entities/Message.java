package Entities;

import java.io.Serializable;
import java.lang.String;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity
public class Message implements Serializable {

	@EmbeddedId
	private MessageId messageId =new MessageId();
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", text=" + text + ", object_message=" + object_message
				+ ", userSender=" + userSender + ", userReceiver=" + userReceiver + "]";
	}
	private String text;
	private String object_message ;
	@ManyToOne
	@JoinColumn(name="idSender",referencedColumnName="id",updatable=false,insertable=false)
	private User userSender;
	
	@ManyToOne
	@JoinColumn(name="idReceiver",referencedColumnName="id",updatable=false,insertable=false)
	private User userReceiver;
	
	private static final long serialVersionUID = 1L;
	

	public Message() {
		super();
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}
	public Message(String text, String object_message, User userSender, User userReceiver) {
		super();
		this.messageId= new MessageId(userSender.getId(), userReceiver.getId());
		this.text = text;
		this.object_message=object_message;
		this.userSender = userSender;
		this.userReceiver = userReceiver;
	}
	public Message(String text, User userSender, User userReceiver) {
		super();
		this.messageId= new MessageId(userSender.getId(), userReceiver.getId());
		this.text = text;
		this.userSender = userSender;
		this.userReceiver = userReceiver;
	}
	public User getUserSender() {
		return userSender;
	}
	public void setUserSender(User userSender) {
		this.userSender = userSender;
	}
	public User getUserReceiver() {
		return userReceiver;
	}
	public void setUserReceiver(User userReceiver) {
		this.userReceiver = userReceiver;
	}
	public Message(MessageId messageId, String text, User userSender, User userReceiver) {
		super();
		this.messageId = messageId;
		this.text = text;
		this.userSender = userSender;
		this.userReceiver = userReceiver;
	}
	public String getObject_message() {
		return object_message;
	}
	public void setObject_message(String object_message) {
		this.object_message = object_message;
	}
	
	public Message(MessageId messageId, String text, String object_message, User userSender,
			User userReceiver) {
		super();
		this.messageId= new MessageId(userSender.getId(), userReceiver.getId());
		this.text = text;
		this.object_message = object_message;
		
		this.userSender = userSender;
		this.userReceiver = userReceiver;
	}
	
	
	
	public Message(User userSender, User userReceiver) {
		super();
		this.userSender = userSender;
		this.userReceiver = userReceiver;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messageId == null) ? 0 : messageId.hashCode());
		result = prime * result + ((object_message == null) ? 0 : object_message.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((userReceiver == null) ? 0 : userReceiver.hashCode());
		result = prime * result + ((userSender == null) ? 0 : userSender.hashCode());
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
		Message other = (Message) obj;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		if (object_message == null) {
			if (other.object_message != null)
				return false;
		} else if (!object_message.equals(other.object_message))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (userReceiver == null) {
			if (other.userReceiver != null)
				return false;
		} else if (!userReceiver.equals(other.userReceiver))
			return false;
		if (userSender == null) {
			if (other.userSender != null)
				return false;
		} else if (!userSender.equals(other.userSender))
			return false;
		return true;
	}
}
