package Test;

import java.util.List;

import Entities.Message;
import Entities.User;
import businessDelegate.MessageServiceDelegate;

public class TestFindAllMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Message> messages = MessageServiceDelegate.FindAllMessages();
		for (Message m : messages) {
			System.out.println(m.getText());
		}
	}

}
