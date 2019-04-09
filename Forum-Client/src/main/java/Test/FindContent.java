package Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Entities.Content;
import Services.ContentServicesRemote;
import businessDelegate.ContentServicesDelegate;


public class FindContent {

	
	public static void main(String[] args) throws NamingException {
		
		Content contentFound =   ContentServicesDelegate.findContentById(1);

		System.out.println(contentFound.getTitle());
	}
}
