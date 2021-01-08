package h07.ntlazyfetch_eagerfetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*


Advantages of LAZY FETCH:
		 1)Initial load time much smaller than "Eager Fetch" approach
		 2)Less memory consumption than "Eager Fetch" approach

		 Disadvantage of LAZY FETCH:
		 1)Delayed initialization might impact performance 

 *
 *
 */

/*
 Advantages of EAGER FETCH:
		 1)No delayed initialization related performance impacts

		 Disadvantages of EAGER FETCH:
		 1)Long initial loading time
		 2)Loading too much unnecessary data might impact performance and memory badly 
 */

public class RunnerFetch07 {

	public static void main(String[] args) {

		Students07 st1= new Students07();
		Books07 bk1= new Books07();
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Students07.class)
				.addAnnotatedClass(Books07.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		st1= session.get(Students07.class, 1005);
		System.out.println(st1);



		//		bk1= session.get(Books07.class, 101);
		//		System.out.println(bk1);

		tx.commit();
		sf.close();
		session.close();


	}

}
