package app.panelist.pancake.Models;

public class QuestionVote {
	private int id;
	private int question_id;
	private int user_id;
	private boolean value;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuestionId() {
		return question_id;
	}
	
	public void setQuestionId(int question_id) {
		this.question_id = question_id;
	}
	
	public int getUserId() {
		return user_id;
	}
	
	public void setUserId(int user_id) {
		this.user_id = user_id;
	}
	
	public boolean isValue() {
		return value;
	}
	
	public void setValue(boolean value) {
		this.value = value;
	}
}
