package hibernatetutoring;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch01 {

	public static void main(String[] args) {

		Student01 std1= new Student01();
		Student01 std2= new Student01();
		Student01 std3= new Student01();

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

		SessionFactory sf= con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx= session.beginTransaction();

		//To get a single Record from Database  we can use get()
		//get() uses Primary Key as second parameter.
		std1= session.get(Student01.class,101);
		std2= session.get(Student01.class,102);
		std3= session.get(Student01.class,103);

		System.out.println(std1+"\n" +std2+ "\n"+std3);
		System.out.println("===========");
		// HOW TO GET MULTIPLE RECORDS FROM TABLE(DB)
		//1st. way- use get() multiple times. (bad idea)
		//inconvenient 



		//2nd way.  By using SQL Queries we can may get Multiple Data
		// it is better than first way but not ideal.
		//because we are learning HIBERNATE not to use SQL. so it is not ideal.
		String sqlQuery1= "SELECT * FROM Student01";

		List<Object[]> rslist1=session.createSQLQuery(sqlQuery1).getResultList();

		for(Object[] w: rslist1) {
			System.out.println(Arrays.toString(w));

		}
		System.out.println("*******************");
		//3rd Way is best way,: by using HQL, Hibernate Query Language.
		// we can get Multiple records.
		//when you use HQL , table and column name must come from java class. not from table

		String hqlQuery = "FROM Student01";

		List<Object>rsList2 = session.createQuery(hqlQuery).getResultList();

		for(Object w: rsList2) {
			System.out.println(w);

		}

		System.out.println("------------------");
		//Fetch the record whose name is "Veli Han"
		//A if you are not sure Veli Han is unique you can use solution below
		String sqlQuery2 = "SELECT * FROM student01\n"
				+ "WHERE name ='Veli Han'";
		List<Object[]> rsList3=session.createSQLQuery(sqlQuery2).getResultList();
		for(Object[] w: rsList3) {
			System.out.println(Arrays.toString(w));
		}
		//b) if you are sure Veli han is unique ;

		System.out.println("666666666666666666666");
		Object[] result1 =(Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();

		System.out.println(Arrays.toString(result1));

		System.out.println("88888888888888888888888888888");
		///2nd Way: USE HQL
		// in HQL most of the times we use alias and utilize it.
		String hqlQuery2= "FROM Student01 s WHERE s.name='Veli Han'";

		Object result3 = session.createQuery(hqlQuery2).uniqueResult();
		System.out.println(result3);
		System.out.println("999999999999999999999999");
		// by using HQL  fetch the records whose grades are 11
		String hqlQ4 = "FROM Student01 s WHERE s.grade=11";
		List<Object> r4 = session.createQuery(hqlQ4).getResultList();
		for(Object w: r4) {
			System.out.println(r4);
		}
		System.out.println("100000000000000000");
		/// get only names where grades are 11
		String hql5= "SELECT s.name FROM Student01 s  WHERE s.grade=11";
		List<Object> r5 = session.createQuery(hql5).getResultList();
		for(Object w: r5) {
			System.out.println(r5);
		}

		sf.close();
		session.close();


		tx.commit();

	}

}
