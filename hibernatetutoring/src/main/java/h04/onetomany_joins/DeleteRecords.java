package h04.onetomany_joins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteRecords {

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





		//How to delete a record by using delete(<Object Name>) method

		//		book=session.get(Books04.class, 108);
		//		session.delete(book);


		//2.nd way
		//		book = session.get(Books04.class, 102);
		//		session.delete("Books04", book);

		// You can delete records from PARENT TABLE AS WELL
		//Delete the record whose id is 1003 from Students04 table


		String hql8="DELETE FROM Students04 s WHERE s.std_id=1002";

		int numofDel=session.createQuery(hql8).executeUpdate();
		System.out.println(numofDel);

		///when there is parent -child relationship, and if you want
		//to delete  , first you need to delete child for that record
		// then you can delete parent, or the drop. the same for both.

		student = session.get(Students04.class, 1002);
		session.delete(student);


		tx.commit();

		sf.close();
		session.close();

	}

}
