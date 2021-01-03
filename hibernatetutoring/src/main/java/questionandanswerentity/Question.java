package questionandanswerentity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	@Id
	private int q_id;
	private String question;
	private String q_status;

	@OneToMany(mappedBy="question")
	private List<Answer> answerList= new ArrayList<Answer>();

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQ_status() {
		return q_status;
	}

	public void setQ_status(String q_status) {
		this.q_status = q_status;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	@Override
	public String toString() {
		return "Question [q_id=" + q_id + ", question=" + question + ", q_status=" + q_status + ", answerList="
				+ answerList + "]";
	}







}
