package h05.onetomany_joins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteRunner {

	public static void main(String[] args) {

		Question11 q1 = new Question11();
		Answer a1 = new Answer();



		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question11.class).addAnnotatedClass(Answer.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();


		//		a1= session.get(Answer.class, 2);
		//		session.delete(a1);
		System.out.println("99999999999999");
		a1=session.get(Answer.class, 5);
		System.out.println(a1);
		//		q1=session.get(Question11.class, 3);
		//		session.delete(q1);
		System.out.println("-------");
		//how to delete all records from
		// 1st Way SQL:
		//		String sqlq1="DELETE FROM Question11";
		//		int delrec= session.createSQLQuery(sqlq1).executeUpdate();
		//		System.out.println(delrec);


		// 2nd Way SQL:
		//		String hqlq1="FROM Question11";
		//		int delrec2= session.createQuery(hqlq1).executeUpdate();
		//		System.out.println(delrec2);

		//3rd way, the shortest way with HQL
		session.delete(a1);

		tx.commit();
		sf.close();
		session.close();

	}

}
