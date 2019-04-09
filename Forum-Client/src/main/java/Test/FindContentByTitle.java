package Test;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Entities.Category;
import Entities.Content;
import Services.ContentServicesRemote;
import businessDelegate.ContentServicesDelegate;


public class FindContentByTitle {

	
	public static void main(String[] args)  {
		
		
		List<Content> contents = ContentServicesDelegate.findContentByTitle("Minions");
		for (Content c : contents) {
			System.out.println(c.getYearReleased());
		}
	}}
