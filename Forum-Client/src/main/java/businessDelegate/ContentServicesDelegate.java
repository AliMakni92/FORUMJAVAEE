package businessDelegate;

import java.util.ArrayList;

import java.util.List;

import Entities.Category;
import Entities.Content;
import Entities.Genre;
import ServiceLocator.ServiceLocator;
import Services.ContentServicesRemote;

public class ContentServicesDelegate {

	private static String jndiName = "Forum-ear/Forum-ejb/ContentServices!Services.ContentServicesRemote";

	public static ContentServicesRemote getProxy() {
		return (ContentServicesRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

	public static void addContent(String title, Genre genre, String description, String trailer, int yearReleased, Double rating,
			Category category) {
		getProxy().addContent(title, genre, description, trailer, yearReleased, rating, category);
	}
	
	public static void updateContent(Content content) {
		getProxy().updateContent(content);
	}
	

	public static Content findContentById(Integer id) {
		return getProxy().findContentById(id);
	}
	
	public static List<Content> findContentByTitle(String title) {
		return getProxy().findContentByTitle(title);
	}
	
	

	public static Category findCategoryById(Integer id) {
		return getProxy().findCategoryById(id);
	}

	public static void deleteContent(Content content) {

		getProxy().deleteContent(content);
	}

	public static void deleteContentById(Integer id) {

		getProxy().deleteContentById(id);

	}

	public static List<Content> findAllContents() {

		return getProxy().findAllContents();
	}

	public static List<Content> findContentByCategory(Category category) {
		
		return getProxy().findContentByCategory(category);
	}
	public static ArrayList<Content> listAlphabetically(ArrayList<Content> contents) {
		return getProxy().listAlphabetically(contents);
	}
	
	public static ArrayList<Content> listByGenre(ArrayList<Content> contents){
		return getProxy().listByGenre(contents);
	}
	}
