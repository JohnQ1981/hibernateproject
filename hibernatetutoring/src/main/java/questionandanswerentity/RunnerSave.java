package questionandanswerentity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {

	public static void main(String[] args) {
		Question q1= new Question();
		Question q2 = new Question();

		Answer a1= new Answer();
		Answer a2= new Answer();
		Answer a3= new Answer();

		Answer a4= new Answer();
		Answer a5= new Answer();
		Answer a6= new Answer();




		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.addAnnotatedClass(Answer.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();



		q1.setQ_id(001);
		q1.setQ_status("Easy");
		q1.setQuestion("What is 1+1 ? ");
		q1.getAnswerList().add(a1);


		q2.setQ_id(002);
		q2.setQ_status("Hard");
		q2.setQuestion("What is Sin(60) ?");
		q1.getAnswerList().add(a2);

		a1.setAnswer("1+1= 2");
		a1.setAnswer_id(101);
		a1.setAnswer_status("Easy");
		a1.setQuestion(q1);

		a2.setAnswer("Sin(60) is equal to:we get sin 60 degrees exact value as √3/2");
		a2.setAnswer_status("Hard");
		a2.setAnswer_id(102);
		a2.setQuestion(q2);

		a3.setAnswer("it is 2");
		a3.setAnswer_id(103);
		a3.setAnswer_status("Easy");
		a3.setQuestion(q1);

		a4.setAnswer("it is hard to calculate Sin(60) but it is:value as √3/2" );
		a4.setAnswer_id(104);
		a4.setAnswer_status("Hard");
		a4.setQuestion(q2);

		a5.setAnswer("not easy Sin(60) but it is:value as √3/2" );
		a5.setAnswer_id(105);
		a5.setAnswer_status("Hard");
		a5.setQuestion(q2);

		a6.setAnswer("difficult to find Sin(60) but it is:value as √3/2" );
		a6.setAnswer_id(106);
		a6.setAnswer_status("Hard");
		a6.setQuestion(q2);

		q1.setAnswerList(q1.getAnswerList());
		q2.setAnswerList(q2.getAnswerList());

		//session.save(q1);
		//session.save(q2);
		//session.save(a1);
		//		session.save(a2);
		//		session.save(a3);
		//		session.save(a4);
		//		session.save(a5);
		//		session.save(a6);


		//		for(Answer w: q1.getAnswerList()) {
		//			session.save(w);
		//
		//		}




		tx.commit();
		session.close();
		sf.close();









	}

}
