package SecurityForum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

import Entities.User;

public class FMSCalbackHandler implements CallbackHandler{
	private User user;
	private String username = null;
	private String password = null;
	
	public FMSCalbackHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FMSCalbackHandler(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		// TODO Auto-generated method stub
		
		NameCallback nameCallback =(NameCallback)callbacks[0];
//		nameCallback.setName((new BufferedReader(new InputStreamReader(System.in))).readLine());
		
//		System.out.println(nameCallback.getPrompt());
	nameCallback.setName(username);
		PasswordCallback passwordCallback =(PasswordCallback)callbacks[1];
	System.out.println(passwordCallback.getPrompt());
   passwordCallback.setPassword(password.toCharArray());
//		passwordCallback
//		.setPassword((new BufferedReader(new InputStreamReader(System.in))).readLine().toCharArray());

	}

}
