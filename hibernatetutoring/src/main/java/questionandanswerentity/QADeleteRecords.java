package questionandanswerentity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class QADeleteRecords {

	public static void main(String[] args) {
		Question q1 = new Question();

		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class);

		SessionFactory sf= con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		//q1= session.get(null, session)



		tx.commit();
		sf.close();
		session.close();

	}

}
