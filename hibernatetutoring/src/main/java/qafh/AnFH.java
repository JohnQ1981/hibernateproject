package qafh;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnFH {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String answer;
	private String postedBy;

	@ManyToOne //Many Answers to one Question
	private QA question;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public QA getQuestion() {
		return question;
	}

	public void setQuestion(QA question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "AnFH [id=" + id + ", answer=" + answer + ", postedBy=" + postedBy + "]";
	}


}