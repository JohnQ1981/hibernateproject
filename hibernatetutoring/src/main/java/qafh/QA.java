package qafh;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class QA {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String question;

	/*
	 								What Is Cascading?
	 Any operations on the table of “Question” will have an impact over the table of “Answers”. 
	 When you create id for a question, it will be added into Answers table for every question
	 */
	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name = "question_id")
	private List<AnFH> answers = new ArrayList<AnFH>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<AnFH> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnFH> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "QA [id=" + id + ", question=" + question + ", answers=" + answers + "]";
	}



}
