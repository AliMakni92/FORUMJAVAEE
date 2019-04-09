package SecurityForum;

import java.io.Serializable;
import java.security.Principal;

import SecurityForum.*;

public class FMSPrincipal implements Principal,Serializable{
	private static final long serialVersionUID = 1L;
private final String username;
	public FMSPrincipal(String username) {
		// TODO Auto-generated constructor stub
	this.username=username;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return username;
	}
	public boolean equals(Object object) {
		boolean flag = false;
		if(object instanceof FMSPrincipal) 
			flag = username.equals(((FMSPrincipal)object).getName());
		return flag;
	}
	
}
