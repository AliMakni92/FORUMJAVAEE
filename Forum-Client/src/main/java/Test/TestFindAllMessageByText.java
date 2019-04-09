package Test;

import java.util.List;

import Entities.Message;
import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;
import businessDelegate.MessageServiceDelegate;

public class TestFindAllMessageByText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Message> messages=MessageServiceDelegate.findMessagesByText("No No");
		for (Message m : messages) {
		System.out.println(m.getUserReceiver().getUsername());
		}
	}

}
