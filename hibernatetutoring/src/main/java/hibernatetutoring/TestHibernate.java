package hibernatetutoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestHibernate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "system", "oracle");
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM students20");
		while(rs.next()) {

			System.out.println(rs.getString(2)+"--"+ rs.getInt(1));

		}

		//boolean ct=st.execute("CREATE TABLE pil (pil_id number(3), pil_name VARCHAR2(50), pil_price NUMBER(5), pil_exp_date DATE )");
		//System.out.println(ct +"table created");

		st.executeUpdate("INSERT INTO pil VALUES(004,'Neospirin', 8,'3-APR-09')");
		ResultSet rs2=st.executeQuery("SELECT * FROM pil");
		while(rs2.next()) {
			System.out.println(rs2.getInt(1)+"--"+rs2.getString(2)+"--"+rs2.getInt(3)+"--"+rs2.getDate(4));
		}
	}



}


