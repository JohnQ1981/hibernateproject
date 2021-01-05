package h05.onetomany_joins;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class RunnerFetch {

	public static void main(String[] args) {

		Configuration con = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Question11.class).
				addAnnotatedClass(Answer.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		//Fetch all questions and answers for the questions
		@SuppressWarnings("unchecked")
		List<Question11> list1 = session.createQuery("FROM Question11").getResultList();

		Iterator<Question11> itr = list1.iterator();
		while (itr.hasNext()) {
			//Printing question
			Question11 q = itr.next();
			System.out.println("Question: " + q.getQuestion());

			//Printing answers
			List<Answer> list2 = q.getAnswers();
			Iterator<Answer> itr2 = list2.iterator();
			while (itr2.hasNext()) {
				Answer a = itr2.next();
				System.out.println(a.getPostedBy() + ": " + a.getAnswer());
			}

			System.out.println("======================================");
		}

		tx.commit();

		session.close();
		System.out.println("success");
	}
}