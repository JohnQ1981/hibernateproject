package h02nt.embedded_annotation;

import javax.persistence.Embeddable;

@Embeddable
public class Courses {

	private String elective;
	private String mandatory;
	private String course_id;

	public String getElective() {
		return elective;
	}
	public void setElective(String elective) {
		this.elective = elective;
	}
	public String getMandatory() {
		return mandatory;
	}
	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	@Override
	public String toString() {
		return "Courses [elective=" + elective + ", mandatory=" + mandatory + ", course_id=" + course_id + "]";
	}

}
