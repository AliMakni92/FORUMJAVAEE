package Test;

import java.util.List;

import Entities.Content;
import businessDelegate.ContentServicesDelegate;



public class FindAllContentTest {
	
	public static void main(String[] args)  {
		

		List<Content> contents = ContentServicesDelegate.findAllContents();

		for (Content c : contents) {
			System.out.println(c.getTitle());
		}

	}

}
