package Test;

import java.util.ArrayList;

import Entities.Category;
import Entities.Content;
import businessDelegate.ContentServicesDelegate;



public class listByGenre {
	
	public static void main(String[] args)  {
	Category category = Category.MOVIES;	
ArrayList<Content> contents=(ArrayList<Content>) ContentServicesDelegate.findContentByCategory(category);
		ArrayList<Content> cont = ContentServicesDelegate.listByGenre(contents);

		for (Content c : cont) {
			System.out.println(c.getTitle());
		}

	}

}
