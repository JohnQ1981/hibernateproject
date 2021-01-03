package h04.onetomany_joins;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Books04 {
	@Id
	private int book_id;
	private String book_name;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Students04 student;


	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Students04 getStudent() {
		return student;
	}
	public void setStudent(Students04 student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Books04 [book_id=" + book_id + ", book_name=" + book_name + "]";
	}





}
