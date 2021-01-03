package h03nt.onetoone_joins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import h04.onetomany_joins.Books04;
import h04.onetomany_joins.Students04;

public class RunnerFetch04 {

	public static void main(String[] args) {

		Students04 st1 = new Students04();

		Configuration con = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Students04.class).
				addAnnotatedClass(Books04.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();




		st1=session.get(Students04.class, 1001);
		for(Books04 w: st1.getBooksList()) {
			System.out.println(w);
		}

		System.out.println(st1);

		tx.commit();

	}

}
