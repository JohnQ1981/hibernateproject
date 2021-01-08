package h06.manytomany_joins;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Books06 {
	@Id
	private int book_id;

	//@Column(name="book_name")
	private String book_name;




	@ManyToMany(mappedBy = "booksList")
	private List<Students06> studentList = new ArrayList<Students06>();

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
	public List<Students06> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Students06> studentList) {
		this.studentList = studentList;
	}


	//	@Override
	//	public String toString() {
	//		return "Books06 [book_id=" + book_id + ", book_name=" + book_name + ", studentList=" + studentList + "]";
	//	}


	@Override
	public String toString() {
		return "Books06 [book_id=" + book_id + ", book_name=" + book_name + "]";
	}

}
