package SecurityForum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivilegedAction;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import businessDelegate.AccountManagementServiceDelegate;

public class Driver {
	public enum Action{action1,action2,logout};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver =new Driver();
		System.setProperty("java.security.auth.login.config", "Forum.config");
		 LoginContext loginContext=null;
		 String password;
		 try {
			

			
	
		 loginContext=new LoginContext("Forum", new FMSCalbackHandler());
		 if(loginContext==null)
			 System.out.println("bye");
		 else{
		 loginContext.login();
			 
		 System.out.println("aaaa");
		 System.out.println("Authentificated");
		 System.exit(0);}
	} catch (LoginException  e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		
	}
		
		
		
			
		boolean flag =true;
		while (flag)
			try {
				flag = driver.performedAction(loginContext);
			} catch (LoginException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	
	}
	
	public boolean performedAction(LoginContext loginContext)throws IOException,LoginException{
		boolean flag=true;
		System.out.println("Please specify action to take (usage:action1,action2,logout)");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try{
		switch(Action.valueOf(br.readLine())){
			case logout:
				loginContext.logout();
				System.out.println("you are logget out..");
				flag=false;
				break;
			case action1:
				PrivilegedAction<Object>privilegedAction1=()->{
					System.out.println("action 1 was performed");
		return null;
				};
				Subject.doAs(loginContext.getSubject(), privilegedAction1);
				System.out.println("by"+loginContext.getSubject().getPrincipals().iterator().next().getName());
				break;
			case action2:
				PrivilegedAction<Object>privilegedAction2=()->{
					System.out.println("action 2 was performed");
		return null;
				};
				Subject.doAs(loginContext.getSubject(), privilegedAction2);
				System.out.println("by"+loginContext.getSubject().getPrincipals().iterator().next().getName());
				break;
		}	
		}catch (IllegalArgumentException e) {
			System.out.println("invalid entry ...");
		}
		return flag;
		}
		

}
