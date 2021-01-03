package hibernatetutoring;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 	If you use "@Entity" annotation for a class it must have a)Constructor
 															 b)getters and setters for each variable
 															 c)Do not define any variable "static" or "final"
 															 d)toString() is optional but most of the times we need






 	because of that create it everytime


 	If you want to use different name for the table in database you need to use "@Table" annotation at the top of the
 	class name like " @Table(name = "students_table") "
 		Note: When you use " @Table(name = "students_table") " you changed just the name of the table in Database
 		   you did not change Entity object name. It is still "Students01"
 		Note: When you use " @Column(name = "std_name") " you changed just the name of the column in Database
 		   you did not change variable name. It is still "name"
 		Note: When you use " @Entity(name = "students_table") " you changed both the name of the table in Database
 		   and Entity object name.


 		   if you use @Transient Annotation for a variable it does not create
 		   column for a variable in a table.
 */

@Entity
@Table(name = "students_table")
public class Students01 { // class name is table name by default.
	@Id// this is primary key annotation
	private int std_id;
	//@Column(name = "std_name")
	private String name;
	//@Transient// DOES NOT CREATE THIS COLUMN
	private int grade;

	private String dob;

	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Students01 [std_id=" + std_id + ", name=" + name + ", grade=" + grade + ", dob=" + dob + "]";
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

}