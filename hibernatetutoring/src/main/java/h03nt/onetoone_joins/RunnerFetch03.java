package h03nt.onetoone_joins;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {

	public static void main(String[] args) {

		Students03 st1 = new Students03();
		Diary d1= new Diary();

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students03.class)
				.addAnnotatedClass(Diary.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();


		//Example 1: Fetch the student whose id is 101 by using get()

		st1 = session.get(Students03.class, 1001);
		System.out.println(st1);

		System.out.println("********************");
		//Example 2: Fetch the diary details of a student whose id is 101 by using get()

		d1= session.get(Diary.class, 101);
		System.out.println(d1);

		//Example 3: Fetch student name, diary 
		//name and student grade of common 
		//records from Students03 and Diary tables
		//use HQL
		String hqlQ1= "SELECT s.name,d.diary_name, s.grade FROM Students03 s INNER JOIN FETCH Diary d on d.student=s.std_id ";

		List<Object[]>rsL1= session.createQuery(hqlQ1).getResultList();

		for(Object[] w: rsL1) {
			System.out.println("Name: "+w[0]+"--"+"Diary Name: "+w[1]+"--"+"Grade "+w[2]);
			System.out.println("-----------------");
			System.out.println(Arrays.toString(w));

		}




		System.out.println("000000000000000000000000");

		/////Example 4: Fetch student name, diary name 
		//and student grade of records from Students03 table

		String hqlQ2="SELECT s.name,s.grade,d.diary_name FROM Students03 s LEFT JOIN FETCH Diary d on d.student=s.std_id";
		List<Object[]>rsL2= session.createQuery(hqlQ2).getResultList();

		for(Object[] w: rsL2) {
			System.out.println("Name: "+w[0]+"--"+"Diary Name: "+w[1]+"--"+"Grade "+w[2]);
			System.out.println("-----------------");
			System.out.println(Arrays.toString(w));

		}

		System.out.println("9999999999999999999999999");

		String hqlQ3="SELECT s.name,s.grade,d.diary_name FROM Students03 s RIGHT JOIN FETCH Diary d on d.student=s.std_id";
		List<Object[]>rsL3= session.createQuery(hqlQ3).getResultList();

		for(Object[] w: rsL3) {
			System.out.println("Name: "+w[0]+"--"+"Diary Name: "+w[1]+"--"+"Grade "+w[2]);
			System.out.println("-----------------");
			System.out.println(Arrays.toString(w));

		}

		System.out.println("555555555555555555");

		String hqlQ4="SELECT s.name,s.grade,d.diary_name FROM Students03 s FULL JOIN FETCH Diary d on d.student=s.std_id";
		List<Object[]>rsL4= session.createQuery(hqlQ4).getResultList();

		for(Object[] w: rsL4) {
			System.out.println("Name: "+w[0]+"--"+"Diary Name: "+w[1]+"--"+"Grade "+w[2]);
			System.out.println("-----------------");
			System.out.println(Arrays.toString(w));

		}


		///----------------------------
		//Example 7: Fetch all students information of 
		//common records from Students03 and Diary table
		System.out.println("Below is example of the Inner Join for all data");
		String hqlQ5="FROM Students03 s INNER JOIN FETCH s.diary";

		List<Students03>rsL5=session.createQuery(hqlQ5).getResultList();

		for(Students03 w: rsL5) {
			System.out.println(w);

		}

		System.out.println("22222222222222222222222222");
		String hqlQuery5 = "FROM Students03 s INNER JOIN FETCH s.diary";
		List<Students03> resultList5 = session.createQuery(hqlQuery5).getResultList();
		for(Students03 w : resultList5) {
			System.out.println(w);
		}

		System.out.println("333333333333333333333");
		//Example 8: Fetch all diary information of common 
		//records from Students03 and Diary table

		String hqlQ6= "FROM Diary d INNER JOIN FETCH d.student";
		List<Diary> rsL6= session.createQuery(hqlQ6).getResultList();

		for(Diary w: rsL6) {
			System.out.println(w);

		}

		System.out.println("77777777777777777777777777");
		String sqlQ1= "SELECT * FROM Diary d \n"
				+ "INNER JOIN Students03 s on d.student_id=s.std_id";

		List<Object[]>sqR=session.createSQLQuery(sqlQ1).getResultList();

		for(Object[] w: sqR) {
			System.out.println(Arrays.toString(w));

		}

		System.out.println("tttttttttttttttttttttttttttt");

		//Example: Fetch student name ,grade and diary name,
		//of all records from Students03 and diary table

		String sqlQ2="SELECT d.diary_name, s.grade,s.name FROM Diary d \n"
				+ "FULL JOIN Students03 s on d.student_id=s.std_id";

		List<Object[]>rL7=session.createSQLQuery(sqlQ2).getResultList();

		for(Object[] w: rL7) {
			System.out.println(Arrays.toString(w));

		}
		System.out.println("2nd wayyyyyyyyyyyyyyyyyyyyyy");
		//2ND WAY
		String hqlQ7="SELECT d.diary_name, s.grade,s.name FROM Diary d \n"
				+ "FULL JOIN FETCH Students03 s on d.student=s.std_id";


		List<Object[]>rL8=session.createQuery(hqlQ7).getResultList();

		for(Object[] w: rL8) {
			System.out.println(Arrays.toString(w));

		}


		tx.commit();
		session.close();
		sf.close();

	}

	private static Object createQuery(String hqlQ1) {
		// TODO Auto-generated method stub
		return null;
	}

}
