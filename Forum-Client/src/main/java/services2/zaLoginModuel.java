package services2;

import java.io.IOException;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
import Services.AccountManagementServicesRemote;

public class zaLoginModuel implements LoginModule  {
	private Subject subject=null;
private CallbackHandler callbackHandler=null;
private ZaPrincipal zaPrincipal=null;
private User user=null;
//private static final String[][] TEST_USERS={{"user1","password1"},{"user2","password2"},{"user3,password3"}};
	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.subject=subject;
		this.callbackHandler=callbackHandler;
//System.out.println("initialise...");
	}

	@Override
	public boolean login() throws LoginException {
		boolean flag=false;
		Callback[] callbackArray=new Callback[2];
		callbackArray[0]=new NameCallback("user name :");
		callbackArray[1]=new PasswordCallback("Password:",false);
		try {
			callbackHandler.handle(callbackArray);
//			System.out.println("login...");	
			String name=((NameCallback) callbackArray[0]).getName();
			String password=new String (((PasswordCallback) callbackArray[1]).getPassword());
			
			
			Context context = null;
			AccountManagementServicesRemote proxy = null;
					try {
						context=new InitialContext();
						proxy = (AccountManagementServicesRemote) context.lookup(
								"Forum-ear/Forum-ejb/AccountManagementServices!Services.AccountManagementServicesRemote");
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			
			if((proxy.Authentification(name, password)!=null)&&(flag=true)){
			
					zaPrincipal=new ZaPrincipal(name);
					System.out.println("Authentification success...");
					;
					
				}
				
			
			else if(flag==false)
			{
				throw new FailedLoginException("Authentification failure ...");
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedCallbackException e) {
			// TODO Auto-generated catch blocki
			e.printStackTrace();
		}



return flag;
	}

	@Override
	public boolean commit() throws LoginException {
		boolean flag;
		if(subject!=null && !subject.getPrincipals().contains(zaPrincipal))
		{
			subject.getPrincipals().add(zaPrincipal);
			flag=true;
		}
//System.out.println("commit ..");	
return true;
	}

	@Override
	public boolean abort() throws LoginException {
		if(subject!=null && zaPrincipal!=null && subject.getPrincipals().contains(zaPrincipal))
		{
			subject.getPrincipals().remove(zaPrincipal);
			subject=null;
			zaPrincipal=null;

		}
//System.out.println("abort ..");		
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		subject.getPrincipals().remove(user);
		subject=null;
		return true;
		
//System.out.println("logout...");		
	}

}
