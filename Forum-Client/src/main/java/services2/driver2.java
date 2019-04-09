package services2;
import services2.callabkHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivilegedAction;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class driver2 {
	public enum Action {
		action1, action2, logout
	};

	public static void main(String[] args) {
		driver2 driver = new driver2();
		System.setProperty("java.security.auth.login.config", "fichier.config");
		LoginContext logincontext = null;
		while (true) {
			try {
				logincontext = new LoginContext("ZaJaasTutorial04", new callabkHandler());
				logincontext.login();
				boolean flag = true;
				while (flag)
					flag = driver.performAction(logincontext);
			} catch (LoginException | IOException e) {
				System.out.println(e.getMessage());

			}
		}
	}

	boolean performAction(LoginContext loginContext) throws IOException, LoginException {
		boolean flag = true;
		System.out.println("please specify action to take(usage:action1,action2,logout)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		switch (Action.valueOf(br.readLine())) {
		case logout:
			loginContext.logout();
			System.out.println("you are now logout...");
			flag=false;
			break;
		case action1:
			PrivilegedAction<Object>privilegedAction1=()->{
				System.out.print("action1 was performed  ");
				return null;
			};
			Subject.doAs(loginContext.getSubject(), privilegedAction1);
			System.out.println("by "+loginContext.getSubject().getPrincipals().iterator().next().getName());
			break;
		case action2:
			PrivilegedAction<Object>privilegedAction2=()->{
				System.out.print("action2 was performed  ");
				return null;
			};
			Subject.doAs(loginContext.getSubject(), privilegedAction2);
			System.out.println("by "+loginContext.getSubject().getPrincipals().iterator().next().getName());
			break;
		}
	}
	catch(IllegalArgumentException e)
	{
		System.out.println();
	}
		return flag;
	}
}
