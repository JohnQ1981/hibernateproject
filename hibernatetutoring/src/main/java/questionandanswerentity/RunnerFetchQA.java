package questionandanswerentity;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetchQA {

	public static void main(String[] args) {

		Question q1 = new Question();

		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class);

		SessionFactory sf= con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();


		q1= session.get(Question.class, 1);
		System.out.println(q1);
		System.out.println("Printed Above");

		String hql1= "SELECT q.question, a.answer FROM Question q \n"
				+ "INNER JOIN FETCH Answer a ON q.q_id=a.question";

		List<Object[]>rL1=session.createQuery(hql1).getResultList();
		for(Object[] w: rL1) {
			System.out.println(Arrays.toString(w));

		}
		System.out.println("ABOVE IS INNER JOIN");

		String hql2= "SELECT q.question, a.answer FROM Question q \n"
				+ "FULL JOIN FETCH Answer a ON q.q_id=a.question";

		List<Object[]>rL2=session.createQuery(hql2).getResultList();
		for(Object[] w: rL2) {
			System.out.println(Arrays.toString(w));

		}

		System.out.println("ABOVE IS FULL JOIN");

		String hql3= "SELECT q.q_status,q.question, a.answer, a.answer_id FROM Question q \n"
				+ "LEFT JOIN FETCH Answer a ON q.q_id=a.question";

		List<Object[]>rL3=session.createQuery(hql3).getResultList();
		for(Object[] w: rL3) {
			System.out.println(Arrays.toString(w));

		}

		System.out.println("ABOVE IS LEFT JOIN");

		String hql4= "SELECT q.q_status,q.question, a.answer, a.answer_id FROM Question q \n"
				+ "RIGHT JOIN FETCH Answer a ON q.q_id=a.question";

		List<Object[]>rL4=session.createQuery(hql4).getResultList();
		for(Object[] w: rL4) {
			System.out.println(Arrays.toString(w));

		}


		tx.commit();
		sf.close();
		session.close();





	}

}
