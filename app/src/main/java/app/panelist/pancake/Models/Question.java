package app.panelist.pancake.Models;

import java.sql.Timestamp;

public class Question {
	private int id;
	private int askroom_id;
	private int submitted_by;
	private Timestamp time_submitted;
	private int current_version_id;
	private int previous_version_id;
	private int score;
	private String content;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAskroom_id() {
		return askroom_id;
	}
	
	public void setAskroomId(int askroom_id) {
		this.askroom_id = askroom_id;
	}
	
	public int getSubmittedBy() {
		return submitted_by;
	}
	
	public void setSubmittedBy(int submitted_by) {
		this.submitted_by = submitted_by;
	}
	
	public Timestamp getTimeSubmitted() {
		return time_submitted;
	}
	
	public void setTimeSubmitted(Timestamp time_submitted) {
		this.time_submitted = time_submitted;
	}
	
	public int getCurrentVersionId() {
		return current_version_id;
	}
	
	public void setCurrentVersionId(int current_version_id) {
		this.current_version_id = current_version_id;
	}
	
	public int getPreviousVersionId() {
		return previous_version_id;
	}
	
	public void setPreviousVersionId(int previous_version_id) {
		this.previous_version_id = previous_version_id;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
