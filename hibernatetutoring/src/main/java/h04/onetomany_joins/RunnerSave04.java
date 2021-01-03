package h04.onetomany_joins;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {

	public static void main(String[] args) {

		Books04 bk1= new Books04();
		Books04 bk2= new Books04();
		Books04 bk3= new Books04();
		Books04 bk4= new Books04();

		Students04 st1= new Students04();		
		st1.setStd_id(1001);
		st1.setName("Ali Can");
		st1.setGrade(10);

		Students04 st2= new Students04();		
		st2.setStd_id(1002);
		st2.setName("Veli Han");
		st2.setGrade(11);



		bk1.setBook_id(101);
		bk1.setBook_name("Diary of the Wimpy Kid");
		bk1.setStudent(st1);

		bk2.setBook_id(102);
		bk2.setBook_name("War");
		bk2.setStudent(st1);

		bk3.setBook_id(103);
		bk3.setBook_name("Barak Obama");
		bk3.setStudent(st2);

		bk4.setBook_id(104);
		bk4.setBook_name("Java For Dummies");
		bk4.setStudent(st2);



		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Students04.class)
				.addAnnotatedClass(Books04.class);

		SessionFactory sf= con.buildSessionFactory();

		Session session =sf.openSession();


		Transaction tx = session.beginTransaction();


		session.save(st1);
		session.save(st2);
		session.save(bk1);
		session.save(bk2);
		session.save(bk3);
		session.save(bk4);


		tx.commit();
		session.close();
		sf.close();









	}

}
