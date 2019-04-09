package services2;

import java.io.Serializable;
import java.security.Principal;

public class ZaPrincipal implements Principal,Serializable {
		public static final long serialVersionUID=1L;
		private  String name;
		 public ZaPrincipal(String name) {
	this.name=name;	}
		

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}
		public boolean equals(Object object)
		{
			boolean flag=false;
			if (object instanceof ZaPrincipal)flag=name.equals(((ZaPrincipal)object).getName());
			return flag;
			
			
		}

	}

