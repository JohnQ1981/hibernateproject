package h02nt.embedded_annotation;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {

	public static void main(String[] args) {

		Students02 std1 = new Students02();

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students02.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		//Example 1 :Fetch the record whose student id is 101


		std1= session.get(Students02.class, 101);

		System.out.println(std1);

		//Example 2: Fetch Student name and mandatory courses from Students02 Table by Using hql,where id is 102
		System.out.println("--------------------------");
		String hql1="SELECT s.name, s.course.mandatory, s.course.elective FROM Students02 s";

		List<Object[]>rL1=session.createQuery(hql1).getResultList();


		System.out.println("**********************");
		for(Object[] w: rL1) {
			System.out.println(Arrays.toString(w));
		}
		//----------------------
		//or
		for(Object[] w: rL1) {
			System.out.println(w[0]+"---"+ w[1]);
		}















		tx.commit();
		session.close();
		sf.close();

	}

	private static Object createQuery(String hql1) {
		// TODO Auto-generated method stub
		return null;
	}

}
