package h04.onetomany_joins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04FromHoca {

	public static void main(String[] args) {

		Books04 book1 = new Books04();
		Books04 book2 = new Books04();
		Books04 book3 = new Books04();
		Books04 book = new Books04();

		Students04 std1 = new Students04();
		Students04 std2 = new Students04();
		Students04 std3 = new Students04();

		book1.setBook_id(101);
		book1.setBook_name("Art book");
		book1.setStudent(std1);

		book2.setBook_id(102);
		book2.setBook_name("Math book");
		book2.setStudent(std1);

		book3.setBook_id(103);
		book3.setBook_name("Science book");
		book3.setStudent(std2);

		std1.getBooksList().add(book1);
		std1.getBooksList().add(book2);

		std1.setStd_id(1001);
		std1.setName("Ali Can");
		std1.setGrade(11);
		std1.setBooksList(std1.getBooksList());

		std2.getBooksList().add(book3);

		std2.setStd_id(1002);
		std2.setName("Veli Han");
		std2.setGrade(10);
		std2.setBooksList(std2.getBooksList());

		std3.setStd_id(1003);
		std3.setName("Mary Star");
		std3.setGrade(9);



		Configuration con = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Students04.class).
				addAnnotatedClass(Books04.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(std1);
		session.save(std2);
		session.save(std3);

		session.save(book1);
		session.save(book2);
		session.save(book3);

		//If a student has many books you can use 
		//for-each loop to stop repetition
		//		for(Books04 w : std1.getBooksList()) {
		//			session.save(w);
		//		}


		tx.commit();

	}

}