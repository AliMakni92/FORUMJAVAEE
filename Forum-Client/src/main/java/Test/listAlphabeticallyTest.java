package Test;

import java.util.ArrayList;

import Entities.Category;
import Entities.Content;
import businessDelegate.ContentServicesDelegate;



public class listAlphabeticallyTest {
	
	public static void main(String[] args)  {
	Category category = Category.MOVIES;	
ArrayList<Content> contents=(ArrayList<Content>) ContentServicesDelegate.findContentByCategory(category);
		ArrayList<Content> cont = ContentServicesDelegate.listAlphabetically(contents);

		for (Content c : cont) {
			System.out.println(c.getTitle());
		}

	}

}
