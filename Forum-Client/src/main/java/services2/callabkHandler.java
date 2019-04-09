package services2;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class callabkHandler implements CallbackHandler {
private String login =null;
private String pwd=null;
	
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
				nameCallback.setName(login);

			} else if (callbackArray[counter] instanceof PasswordCallback) {
				passwordCallback = (PasswordCallback) callbackArray[counter++];
				System.out.println(passwordCallback.getPrompt());
				passwordCallback
						.setPassword(pwd.toCharArray());
			}
		}
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public callabkHandler(String login, String pwd) {
		super();
		this.login = login;
		this.pwd = pwd;
	}
	public callabkHandler(String login) {
		super();
		this.login = login;
	}
	public callabkHandler() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
