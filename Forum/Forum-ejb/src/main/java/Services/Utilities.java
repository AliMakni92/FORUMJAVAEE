package Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Entities.Category;
import Entities.Content;
import Entities.Genre;
import Entities.Message;
import Entities.ResponsibilityOf;
import Entities.User;




/**
 * Session Bean implementation class Utilities
 */
@Singleton
@LocalBean
@Startup
public class Utilities {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public Utilities() {
	}
	public static HttpSession getSession() {
        return (HttpSession)
          FacesContext.
          getCurrentInstance().
          getExternalContext().
          getSession(false);
      }
       
      public static HttpServletRequest getRequest() {
       return (HttpServletRequest) FacesContext.
          getCurrentInstance().
          getExternalContext().getRequest();
      }
	@PostConstruct
	public void initDb() {
		/////////////////////////////////////////Acccount/////////////////////////////////////////
		User admin=new User();
		admin.setFirstName("admin");
		admin.setLastName("admin");
		admin.setUsername("admin");
		admin.setPassword("admin");
		Date naissanceadmin;
		try {
			naissanceadmin = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-14 17:05:14");
			admin.setDateOfBirth(naissanceadmin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		admin.setEmail("admin@esprit.tn");
		admin.setRole("admin");
		admin.setEnabled(true);
		User moderator=new User();
		moderator.setFirstName("moderator");
		moderator.setLastName("moderator");
		moderator.setUsername("moderator");
		moderator.setPassword("moderator");
		Date naissancemod;
		try {
			naissancemod = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-15 17:05:17");
			moderator.setDateOfBirth(naissancemod);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moderator.setEmail("moderator@esprit.tn");
		moderator.setRole("moderator");
		moderator.setResponsibleOf(ResponsibilityOf.MOVIES);
		moderator.setEnabled(true);
		User moderator1=new User();
		moderator1.setFirstName("moderator1");
		moderator1.setLastName("moderator1");
		moderator1.setUsername("moderator1");
		moderator1.setPassword("moderator1");
		Date naissancemod1;
		try {
			naissancemod1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-18 17:05:55");
			moderator1.setDateOfBirth(naissancemod1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moderator1.setEmail("moderator1@esprit.tn");
		moderator1.setRole("moderator");
		moderator1.setResponsibleOf(ResponsibilityOf.GAMES);
		moderator1.setEnabled(true);
		User moderator2=new User();
		moderator2.setFirstName("moderator2");
		moderator2.setLastName("moderator2");
		moderator2.setUsername("moderator2");
		moderator2.setPassword("moderator2");
		Date naissancemod2;
		try {
			naissancemod2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-25 17:05:50");
			moderator2.setDateOfBirth(naissancemod2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moderator2.setEmail("moderator2@esprit.tn");
		moderator2.setRole("moderator");
		moderator2.setResponsibleOf(ResponsibilityOf.TV);
		moderator2.setEnabled(true);

		User moderator3=new User();
		moderator3.setFirstName("moderator3");
		moderator3.setLastName("moderator3");
		moderator3.setUsername("moderator3");
		moderator3.setPassword("moderator3");
		Date naissancemod3;
		try {
			naissancemod3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-28 17:08:50");
			moderator3.setDateOfBirth(naissancemod3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		moderator3.setEmail("moderator3@esprit.tn");
		moderator3.setRole("moderator");
		moderator3.setResponsibleOf(ResponsibilityOf.MUSIC);
		moderator3.setEnabled(true);
		User user =new User();
		user.setFirstName("Makni");
		user.setLastName("Ali");
		user.setUsername("alimakni");
		user.setPassword("alimakni");
		Date naissance;
		try {
			naissance = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-08-14 17:08:45");
			user.setDateOfBirth(naissance);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		user.setRole("user");
		user.setEmail("ali.makni@esprit.tn");
		user.setEnabled(true);
		
		User user1 =new User();
		user1.setFirstName("Attallah");
		user1.setLastName("Marween");
		user1.setUsername("marweenattallah");
		user1.setPassword("marweenattallah");
		Date naissance1;
		try {
			naissance1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-15 17:08:45");
			user1.setDateOfBirth(naissance1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		user1.setRole("user");
		user1.setEmail("marween.attallah@esprit.tn");
		user1.setEnabled(true);
		User user2 =new User();
		user2.setFirstName("Nasri");
		user2.setLastName("Mohamed");
		user2.setUsername("mohamednasri");
		user2.setPassword("mohamednasri");
		Date naissance2;
		try {
			naissance2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-07 17:08:40");
			user2.setDateOfBirth(naissance2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		user2.setRole("user");
		user2.setEmail("marween.attallah@esprit.tn");
		user2.setEnabled(false);
		
		User user3 =new User();
		user3.setFirstName("Maghraoui");
		user3.setLastName("Sana");
		user3.setUsername("maghraouiSana");
		user3.setPassword("maghraouiSana");
		Date naissance3;
		try {
			naissance3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-15 17:08:40");
			user3.setDateOfBirth(naissance3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		user3.setRole("user");
		user3.setEmail("sana.maghraoui@esprit.tn");
		user3.setEnabled(true);
		User user4 =new User();
		user4.setFirstName("Aissa");
		user4.setLastName("Fidee");
		user4.setUsername("fideeaissa");
		user4.setPassword("fideeaissa");
		Date naissance4;
		try {
			naissance4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1992-02-07 17:08:35");
			user4.setDateOfBirth(naissance4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		user4.setRole("user");
		user4.setEmail("marween.attallah@esprit.tn");
		user4.setEnabled(true);
		entityManager.persist(admin);
		entityManager.persist(moderator);
		entityManager.persist(moderator1);
		entityManager.persist(moderator2);
		entityManager.persist(moderator3);
		entityManager.persist(user);
		entityManager.persist(user1);
		entityManager.persist(user2);
		entityManager.persist(user3);
		entityManager.persist(user4);
		////////////////////////////Message///////////////////////
////////////////////////////Message///////////////////////
Message message =new Message("Comment is +18","Attenttion" ,admin, user);
Message message1 =new Message("Comment is +18", "Attention",admin, user1);
/*Message message2 =new Message("Hello Word", admin, user2);
Message message3 =new Message("Hello Word", admin, user3);
Message message4 =new Message("Hello Word", admin, user4);*/
/*Message message5 =new Message("Hello Movies","Salutation", admin, moderator);
Message message6 =new Message("Hello Games","Salutation", admin, moderator1);
Message message7 =new Message("Hello TV","Salutation", admin, moderator2);
Message message8 =new Message("Hello Music","Salutation", admin, moderator3);
Message message9 =new Message("Hello Admin","Salutation", moderator, admin);
/*Message message10 =new Message("PES2017 is now", moderator, moderator1);
Message message11 =new Message("Good Emission", moderator, moderator2);*/
Message message12 =new Message("No No ", "Attention",moderator, user);
Message message13 =new Message("Ti Yezzi 3ad","Attention",moderator1, user);
/*Message message14 =new Message("+18 Movies", moderator1, moderator);
Message message15 =new Message("+12 Emission", moderator1, moderator2);
Message message16 =new Message("Don't stop the Music", moderator1, moderator3);	*/
/*Message message17 =new Message("Hello Admin", moderator2, user);
/*Message message18 =new Message("Titanic Movies", moderator2, moderator);
Message message19 =new Message("FIFA17 is now", moderator2, moderator1);
Message message20 =new Message("Good rock Music", moderator2, moderator3);
Message message21 =new Message("No Block this user please", moderator3, admin);
Message message22 =new Message("bad Movies", moderator3, moderator);
Message message23 =new Message("bad Games", moderator3, moderator1);
//Message message24 =new Message("Activate me please", user, moderator);
/*Message message25 =new Message("Reclamation", user1, moderator1);
Message message26 =new Message("Reclamation Help", user2, moderator2);
Message message27 =new Message("Reclamation bye", user3, moderator3);
Message message28 =new Message("Reclamation Hay", user4, admin);
Message message29 =new Message("Good Film", user, moderator);*/
//Message message30 =new Message("Good Video Games","Games", user, moderator1);
//Message message31 =new Message("Good Emission haha","Emission", user, moderator2);
//Message message32 =new Message("bad classic music", "Music",user, moderator3);
//Message message33=new Message("Hi", "Salutation", user, user1);
//Message message34=new Message("Hello", "Salutation", user1, user);
entityManager.persist(message);
entityManager.persist(message1);
/*entityManager.persist(message2);
entityManager.persist(message3);
entityManager.persist(message4);*/
entityManager.persist(message12);
entityManager.persist(message13);
//entityManager.persist(message17);
//entityManager.persist(message30);
//entityManager.persist(message31);
/*entityManager.persist(message10);
entityManager.persist(message11);
entityManager.persist(message12);
entityManager.persist(message13);
entityManager.persist(message14);
entityManager.persist(message15);
entityManager.persist(message16);
entityManager.persist(message17);
entityManager.persist(message18);
entityManager.persist(message19);
entityManager.persist(message20);
entityManager.persist(message21);
entityManager.persist(message22);
entityManager.persist(message23);*/
//entityManager.persist(message24);
/*entityManager.persist(message25);
entityManager.persist(message26);
entityManager.persist(message27);
entityManager.persist(message28);
entityManager.persist(message29);*/
//entityManager.persist(message30);
//entityManager.persist(message31);
//entityManager.persist(message32);
//entityManager.persist(message33);
//entityManager.persist(message34);
	///////////////////////////////////Category/////////////////////////
	
	
	
////////////////////////////////////////////////////////////
		
Content content1 =new Content();
content1.setTitle("Shutter Island");
content1.setDescription("mind blowing");
content1.setRating(8.1);
content1.setTrailer("www.IMDB.comSI");
content1.setGenre(Genre.THRILLER);
content1.setYearReleased(2007);
content1.setCategory(Category.MOVIES);

Content content2 = new Content("The Ring",Genre.HORROR,"HORRIFIC","www.youtube",2004, 7.4,
Category.MOVIES);

Content content3 = new Content("The Hangover",Genre.COMEDY,"FUNNY","YTS",2009, 8.0,
Category.MOVIES);

Content content4 = new Content("Minions",Genre.ADVENTURE,"KIDS","Metacritics",2013, 9.0,
Category.MOVIES);

Content content5 = new Content("HER",Genre.ROMANCE,"OS coming to life","www.youtube.com/HER",2012, 8.0,
Category.MOVIES);

Content content6 = new Content("Shadow Of Mordor",Genre.ADVENTURE,"Lord Of The Rings","www.youtube.com/Lord Of The Rings",2003, 9.5,
Category.GAMES);

Content content7 = new Content("Guns And Roses",Genre.DRAMA,"Lord Of The Rings","https://www.youtube.com/watch?v=8SbUC-UaAxE",1992, 2.0,
Category.MUSIC);

Content content8 = new Content("My Happy Ending",Genre.DRAMA,"Avril Lavigne","https://www.youtube.com/watch?v=afefae",1999, 8.0,
Category.MUSIC);
Content content9= new Content("Big Bang Theory",Genre.COMEDY,"Sitcom","https://www.youtube.com/watch?v=aggdsdsae",2010, 8.0,
Category.TV);
Content content10= new Content("Vikings",Genre.ACTION,"Scandinavian History","https://www.youtube.com/watch?v=a4455zae",2015, 8.5,
Category.TV);
Content content11= new Content("Game Of Thrones",Genre.ADVENTURE,"7 Kingdoms","https://www.youtube.com/watch?v=a4455zae",2011, 9.5,
Category.TV);

entityManager.persist(content1);
entityManager.persist(content2);
entityManager.persist(content3);
entityManager.persist(content4);
entityManager.persist(content5);
entityManager.persist(content6);
entityManager.persist(content7);
entityManager.persist(content8);
entityManager.persist(content9);
entityManager.persist(content10);
entityManager.persist(content11);

}



	}
	
