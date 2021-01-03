package h03nt.onetoone_joins;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/*
 * One-To-One Relationship is like: every student will have just a single diary
 * and every diary will belong to a single student. single owner diary.
 * 
 * 
 * 
 */


@Entity
public class Students03 {

	@Id
	private int std_id;
	private String name;
	private int grade;
	@OneToOne(mappedBy = "student")
	private Diary diary;

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
		return "Students03 [std_id=" + std_id + ", name=" + name + ", grade=" + grade + ", diary=" + diary + "]";
	}
	public Diary getDiary() {
		return diary;
	}
	public void setDiary(Diary diary) {
		this.diary = diary;
	}



}
