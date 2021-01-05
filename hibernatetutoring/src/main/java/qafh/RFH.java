package qafh;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RFH {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(QA.class).addAnnotatedClass(AnFH.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		AnFH ans1 = new AnFH();
		ans1.setAnswer("Java is a programming language");
		ans1.setPostedBy("Ali Can");

		AnFH ans2 = new AnFH();
		ans2.setAnswer("Java is object oriented programming language");
		ans2.setPostedBy("Veli Han");

		AnFH ans3 = new AnFH();
		ans3.setAnswer("Session is an Interface");
		ans3.setPostedBy("Mark Stone");

		AnFH ans4 = new AnFH();
		ans4.setAnswer("Session object is used to access methods");
		ans4.setPostedBy("Tom Hanks");

		ArrayList<AnFH> list1 = new ArrayList<AnFH>();
		list1.add(ans1);
		list1.add(ans2);

		ArrayList<AnFH> list2 = new ArrayList<AnFH>();
		list2.add(ans3);
		list2.add(ans4);

		QA question1 = new QA();
		question1.setQuestion("What is Java?");
		question1.setAnswers(list1);

		QA question2 = new QA();
		question2.setQuestion("What is Session?");
		question2.setAnswers(list2);

		session.save(question1);
		session.save(question2);

		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
		session.save(ans4);

		tx.commit();
		session.close();
		System.out.println("success");
	}
}