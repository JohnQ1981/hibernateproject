package h06.manytomany_joins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {

	public static void main(String[] args) {

		Books06 b1 = new Books06();
		Books06 b2 = new Books06();

		Students06 s1 = new Students06();
		Students06 s2 = new Students06();
		Students06 s3 = new Students06();
		Students06 s4 = new Students06();

		s1.setStd_id(1001);
		s1.setName("Ali Can");
		s1.setGrade(11);
		s1.getBooksList().add(b1);
		s1.getBooksList().add(b2);

		s2.setStd_id(1002);
		s2.setName("Veli Han");
		s2.setGrade(11);
		s2.getBooksList().add(b1);

		s3.setStd_id(1003);
		s3.setName("Mary Star");
		s3.setGrade(9);
		s3.getBooksList().add(b1);
		s3.getBooksList().add(b2);

		s4.setStd_id(1004);
		s4.setName("John Q");
		s4.setGrade(10);
		s4.getBooksList().add(b1);

		b1.setBook_id(101);
		b1.setBook_name("Art Book");
		b1.getStudentList().add(s1);

		b2.setBook_id(102);
		b2.setBook_name("Math Book");
		b2.getStudentList().add(s1);
		b2.getStudentList().add(s2);
		b2.getStudentList().add(s3);

		Configuration con = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Students06.class).
				addAnnotatedClass(Books06.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		//session.save(b1);
		//session.save(b2);

		session.save(s1);
		session.save(s2);
		session.save(s3);
		//session.save(s4);
		tx.commit();

	}

}