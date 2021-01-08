package h06.manytomany_joins;


import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch06 {

	public static void main(String[] args) {

		Students06 st1= new Students06();
		Books06 bk1 = new Books06();


		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students06.class).addAnnotatedClass(Books06.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		//get student with id 1001 by using get()
		//		st1= session.get(Students06.class, 1001);
		//		System.out.println(st1);
		//		System.out.println("---------");

		//bk1=session.get(Books06.class, 101);
		//System.out.println(bk1);

		/////////////
		/// fetch data of the student 

		//3)Fetch the book whose name 
		//is "Art Book". I want to see the owners as well
		String hql1="FROM Books06 b WHERE b.book_name='Art Book'";
		Object rs1 =session.createQuery(hql1).getSingleResult();
		Object rs2 =session.createQuery(hql1).uniqueResult();

		System.out.println(rs1+"---"+ rs2);
		////4)Fetch the student whose name is 
		//"Ali Can". I want to see the books as well
		System.out.println("+++++");  
		String hql2 = "FROM Students06 s WHERE s.name='Ali Can'";
		Object rs3=session.createQuery(hql2).getSingleResult();

		System.out.println(rs3);

		/////Fetch the Students names
		String hql3= "SELECT s.name FROM Students06 s";
		List<Object> rs4= session.createQuery(hql3).list();
		System.out.println(rs4);
		System.out.println("below are books");
		//Fetch Books names
		String hql5="SELECT b.book_name FROM  Books06 b";
		List<Object> rs5= session.createQuery(hql5).list();
		System.out.println(rs5);


		System.out.println("//fetch the book with id 101");
		//fetch the book with id 101
		String hql4="SELECT b.book_name FROM Books06 b WHERE b.book_id=101 ";
		List<Object>rs6= session.createQuery(hql4).list();
		System.out.println(rs6);

		//8)Fetch the student name, 
		//book name whose student id is 1001
		System.out.println("//8)Fetch the student name, \n"
				+ "		//book name whose student id is 1001");

		String hql7="SELECT b.book_name ,s.name FROM Students06 s INNER JOIN FETCH Books06 b on s.std_id=1001";
		List<Object[]> rs8=session.createQuery(hql7).getResultList();

		for(Object[] w: rs8) {
			System.out.println(Arrays.toString(w));

		}

		tx.commit();
		sf.close();
		session.close();






	}

}
