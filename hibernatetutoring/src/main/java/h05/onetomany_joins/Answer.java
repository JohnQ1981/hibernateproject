package h05.onetomany_joins;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue//(orphanRemoval = true,strategy = GenerationType.TABLE)
	private int id;
	private String answer;
	private String postedBy;

	@ManyToOne//(orphanRemoval = true,cascade = CascadeType.ALL) //Many Answers to one Question
	private Question11 question;

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

	public Question11 getQuestion() {
		return question;
	}

	public void setQuestion(Question11 question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + ", postedBy=" + postedBy + "]";
	}
}