package hibernatetutoring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01FromHoca {

	public static void main(String[] args) {

		Students01 std1 = new Students01();
		std1.setStd_id(101);
		std1.setName("Ali Can");
		std1.setGrade(11);

		Students01 std2 = new Students01();
		std2.setStd_id(102);
		std2.setName("Veli Han");
		std2.setGrade(11);

		Students01 std3 = new Students01();
		std3.setStd_id(103);
		std3.setName("Mary Star");
		std3.setGrade(9);



		Students01 std4 = new Students01();
		std4.setStd_id(104);
		std4.setName("Angie Ocean");
		std4.setGrade(9);
		std4.setDob("August-5-2013");




		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students01.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		//session.save(std1);
		//session.save(std2);
		//session.save(std3);
		session.save(std4);
		tx.commit();

		sf.close();
		session.close();

	}

}