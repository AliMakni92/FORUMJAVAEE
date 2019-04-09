package Test;


import Entities.Content;
import businessDelegate.ContentServicesDelegate;


public class DeleteTest {

	public static void main(String[] args)  {
		
		Content content=ContentServicesDelegate.findContentById(1);
		

		ContentServicesDelegate.deleteContent(content);
	}
	
}
