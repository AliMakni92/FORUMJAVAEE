package SecurityForum;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;

public class FMSLoginModule implements LoginModule {
	private static final String[][]TEST_USERS={{"user1","password1"},{"user2","password2"}};
	//private static AccountManagementServiceDelegate accountManagementServiceDelegate;
	//User user=AccountManagementServiceDelegate.doAuthentification(username, password);
	User user;
	private Subject subject = null;
	private CallbackHandler callbackHandler = null;
	private FMSPrincipal fMSPrincipal=null;
	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.subject=subject;
		this.callbackHandler=callbackHandler;
		// TODO Auto-generated method stub
	}
/*
	@Override
	public boolean login() throws LoginException {
		// TODO Auto-generated method stub
		boolean flag =false;
		Callback[] callbackArray=new Callback[2];
		callbackArray[0]=new NameCallback("Username:");
		callbackArray[1]=new PasswordCallback("Password:",false);
	try {
		callbackHandler.handle(callbackArray);
	String username= ((NameCallback) callbackArray[0]).getName();
	String password= new String(((PasswordCallback) callbackArray[1]).getPassword());
   user =new User();
	while(user!=null){
		if(user.equals(username)&&user.equals(password)){
			fMSPrincipal = new FMSPrincipal(username);
			System.out.println("authentification success...");
		flag=true;
		break;
		}
	}
	if (flag==false) throw new FailedLoginException("authentification failure...");
	} catch (IOException | UnsupportedCallbackException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return flag;

	}*/
	public boolean login() throws LoginException {
	    boolean returnValue = true;
		if (callbackHandler == null){
	        throw new LoginException("No callback handler supplied.");
	    }

	    Callback[] callbacks = new Callback[2];
	    callbacks[0] = new NameCallback("Username");
	    callbacks[1] = new PasswordCallback("Password", false);

	    try {
	        callbackHandler.handle(callbacks);
	        String userName = ((NameCallback) callbacks[0]).getName();
	        char [] passwordCharArray = ((PasswordCallback) callbacks[1]).getPassword();
	        String password = new String(passwordCharArray);
	        //--> authenticate if username is the same as password (yes, this is a somewhat simplistic approach :-)
	        returnValue = userName.equals(password);
	    } catch (IOException ioe)  {
	        ioe.printStackTrace();
	        throw new LoginException("IOException occured: "+ioe.getMessage());
	    } catch (UnsupportedCallbackException ucbe) {
	        ucbe.printStackTrace();
	        throw new LoginException("UnsupportedCallbackException encountered: "+ucbe.getMessage());
	    }

	    System.out.println("logged in");
	    return returnValue;
	}
	@Override
	public boolean commit() throws LoginException {
		// TODO Auto-generated method stub
		boolean flag=false;
		System.out.println("FMSLoginModule commit...");
		if(subject!=null && !subject.getPrincipals().contains(fMSPrincipal)){
			subject.getPrincipals().add(fMSPrincipal);
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean abort() throws LoginException {
		// TODO Auto-generated method stub
		if(subject !=null && fMSPrincipal!=null &&subject.getPrincipals().contains(fMSPrincipal))
		subject.getPrincipals().remove(fMSPrincipal);
		subject=null;	
		fMSPrincipal=null;
		//System.out.println("FMSLoginModule abort...");
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		subject.getPrincipals().remove(fMSPrincipal);
		subject=null;
		return true;
	}

}
