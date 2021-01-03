package h03nt.onetoone_joins;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {

	@Id
	private int diary_id;
	private String diary_name;
	@OneToOne
	@JoinColumn(name= "student_id") // if we use JoinColumn  this class will have foreign key
	private Students03 student;

	public int getDiary_id() {
		return diary_id;
	}
	public void setDiary_id(int diary_id) {
		this.diary_id = diary_id;
	}
	public String getDiary_name() {
		return diary_name;
	}
	public void setDiary_name(String diary_name) {
		this.diary_name = diary_name;
	}

	public Students03 getStudent() {
		return student;
	}
	public void setStudent(Students03 student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Diary [diary_id=" + diary_id + ", diary_name=" + diary_name + "]";
	}







}
