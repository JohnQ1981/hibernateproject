package questionandanswerentity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	private int answer_id;
	private String answer;
	private String answer_status;

	@ManyToOne
	@JoinColumn(name="question_id")
	private Question question;

	public int getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer_status() {
		return answer_status;
	}

	public void setAnswer_status(String answer_status) {
		this.answer_status = answer_status;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [answer_id=" + answer_id + ", answer=" + answer + ", answer_status=" + answer_status + "]";
	}






}
