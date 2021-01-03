package hibernatetutoring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerSave01 {

	public static void main(String[] args) {

		Student01 std1 = new Student01();

		std1.setStd_id(101);
		std1.setName("Ali Can");
		std1.setGrade(11);
		//std1.setDob("Aug-12-2002");


		Student01 std2 = new Student01();

		std2.setStd_id(102);
		std2.setName("Veli Han");
		std2.setGrade(11);
		std2.setDob("June-6-2002");

		Student01 std3 = new Student01();

		std3.setStd_id(103);
		std3.setName("Mary Star");
		std3.setGrade(11);
		std3.setDob("June-6-2002");



		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		//session.save(std1);
		//session.save(std2);
		session.save(std3);

		tx.commit();
		sf.close();
		session.close();
	}

}
