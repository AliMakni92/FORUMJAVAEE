package Test;

import Entities.Category;
import Entities.Genre;
import businessDelegate.ContentServicesDelegate;

public class AddTest {

	public static void main(String[] args) {

		String title = "The Ring";
		Genre genre = Genre.ACTION;
		String description = "HORRIFIC";
		String trailer = "www.youtube.com";
		Double rating = 8.0;
		int yearReleased = 2007;
		Category category = ContentServicesDelegate.findCategoryById(1);

		ContentServicesDelegate.addContent(title, genre, description, trailer, yearReleased,rating, category);
	}

}
