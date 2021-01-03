package h04.onetomany_joins;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04FromHoca {

	public static void main(String[] args) {

		Students04 student = new Students04();
		Books04 book = new Books04();

		Configuration con = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Students04.class).
				addAnnotatedClass(Books04.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		//Example 1: Fetch all books of a student whose id is 1001 by using get() method
		student = session.get(Students04.class, 1002);
		for(Books04 w : student.getBooksList()) {
			System.out.println(w);
		}
		System.out.println("999999999999999999999");
		//Example 2: Fetch the owner of a book whose id is 101 by using get() method
		book = session.get(Books04.class, 101);
		student = session.get(Students04.class, book.getStudent().getStd_id());
		System.out.println(student);
		System.out.println("8888888888888888888888");
		//Example 3: Fetch student name, book name of common records from Students04 and Books04 tables (INNER JOIN)
		//1.Way: SQL
		String sqlQuery1 = "SELECT s.name, b.book_name \n"
				+ "FROM students04 s INNER JOIN books04 b\n"
				+ "ON s.std_id = b.student_id";

		List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
		for(Object[] w : resultList1) {
			System.out.println(Arrays.toString(w));
		}
		System.out.println("777777777777777777777");
		//2.Way: HQL
		//*********** HQL is case sensitive in class names ***************
		String hqlQuery1 = "SELECT s.name, b.book_name \n"
				+ "FROM Students04 s INNER JOIN FETCH Books04 b\n"
				+ "ON s.std_id = b.student";

		List<Object[]> resultList2 = session.createQuery(hqlQuery1).getResultList();
		for(Object[] w : resultList2) {
			System.out.println(Arrays.toString(w));
		}
		System.out.println("6666666666666666666666666");
		//Example 4: Fetch student name, book name of records from Students04 table (LEFT JOIN)
		//1.Way: Use SQL
		String sqlQuery2 = "SELECT s.name, b.book_name, b.book_id \n"
				+ "FROM students04 s LEFT JOIN books04 b\n"
				+ "ON s.std_id = b.student_id";
		List<Object[]> resultList3 = session.createSQLQuery(sqlQuery2).getResultList();
		for(Object[] w : resultList3) {
			System.out.println(Arrays.toString(w));
		}
		System.out.println("55555555555555555555555555");
		//2.Way: Use HQL
		//*********** HQL is case sensitive in class names ***************
		String hqlQuery2 = "SELECT s.name, b.book_name, b.book_id \n"
				+ "FROM Students04 s LEFT JOIN FETCH Books04 b\n"
				+ "ON s.std_id = b.student";
		List<Object[]> resultList4 = session.createQuery(hqlQuery2).getResultList();
		for(Object[] w : resultList4) {
			System.out.println(Arrays.toString(w));
		}
		System.out.println("SQL is belowwwwwwwwwwwwww");
		//Example 5: Fetch student name, book name of records from Books04 table (RIGHT JOIN)
		//1.Way: Use SQL
		String sqlQuery3 = "SELECT s.name, b.book_name, b.book_id \n"
				+ "FROM students04 s RIGHT JOIN books04 b\n"
				+ "ON s.std_id = b.student_id";
		List<Object[]> resultList5 = session.createSQLQuery(sqlQuery3).getResultList();
		for(Object[] w : resultList5) {
			System.out.println(Arrays.toString(w));
		}
		System.out.println("HQL is belowwwwwwwwwwwwww");
		//2.Way: Use HQL
		//*********** HQL is case sensitive in class names ***************
		String hqlQuery3 = "SELECT s.name, b.book_name, b.book_id \n"
				+ "FROM Students04 s RIGHT JOIN FETCH Books04 b\n"
				+ "ON s.std_id = b.student";
		List<Object[]> resultList6 = session.createQuery(hqlQuery3).getResultList();
		for(Object[] w : resultList6) {
			System.out.println(Arrays.toString(w));
		}

		//Example 6: Fetch student name, book name of all records from Students04 and Books04 table (FULL JOIN)
		//1.Way: Use SQL
		String sqlQuery4 = "SELECT s.name, b.book_name, b.book_id \n"
				+ "FROM students04 s FULL JOIN books04 b\n"
				+ "ON s.std_id = b.student_id";
		List<Object[]> resultList7 = session.createSQLQuery(sqlQuery4).getResultList();
		for(Object[] w : resultList7) {
			System.out.println(Arrays.toString(w));
		}

		//2.Way: Use SQL
		//		String hqlQuery4 = "SELECT s.name, b.book_name, b.book_id \n"
		//							+ "FROM Students04 s FULL JOIN FETCH Books04 b\n"
		//							+ "ON s.std_id = b.student";
		//		List<Object[]> resultList8 = session.createQuery(hqlQuery4).getResultList();
		//		for(Object[] w : resultList8) {
		//			System.out.println(Arrays.toString(w));
		//		}

		//How to delete all records from a table
		//1.Way: SQL
		String sqlQuery5 = "DELETE FROM Books05";
		int numOfRec1 = session.createSQLQuery(sqlQuery5).executeUpdate();
		System.out.println(numOfRec1);
		System.out.println("Records deleted from Books05 deleted");
		//2.Way: HQL
		String hqlQuery6 = "DELETE FROM Books05";
		int numOfRec2 = session.createQuery(hqlQuery6).executeUpdate();
		System.out.println("The number of deleted records: " + numOfRec2);

		tx.commit();

		sf.close();
		session.close();

	}

}