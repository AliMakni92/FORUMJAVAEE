package Test;

import java.util.List;

import Entities.Category;
import Entities.Content;
import businessDelegate.ContentServicesDelegate;



public class FindContentByCategory {
	
	public static void main(String[] args)  {
		
		Category category=Category.MOVIES;
		List<Content> contents = ContentServicesDelegate.findContentByCategory(category);
		for (Content c : contents) {
			System.out.println(c.getTitle());
		}

		
		

	}
}
