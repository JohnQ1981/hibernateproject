package h03nt.onetoone_joins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {

	public static void main(String[] args) {
		Diary d1= new Diary();
		Diary d2= new Diary();
		Students03 st1= new Students03();
		Students03 st2= new Students03();

		st1.setStd_id(1001);
		st1.setName("Ali Can");
		st1.setGrade(11);
		st1.setDiary(d1);

		st2.setStd_id(1002);
		st2.setName("Veli Han");
		st2.setGrade(11);




		d1.setDiary_id(101);
		d1.setDiary_name("Red Diary");
		d1.setStudent(st1);

		d2.setDiary_id(102);
		d2.setDiary_name("No bodies Diary");




		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Students03.class)
				.addAnnotatedClass(Diary.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(d1);
		session.save(st1);

		session.save(d2);
		session.save(st2);



		tx.commit();
		session.close();
		sf.close();



	}

}
