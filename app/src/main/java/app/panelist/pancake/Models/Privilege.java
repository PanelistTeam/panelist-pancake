package app.panelist.pancake.Models;

public class Privilege
{
	private int id;
	private int user_id;
	private int askroom_id;
	private int access_level;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return user_id;
	}
	
	public void setUserId(int user_id) {
		this.user_id = user_id;
	}
	
	public int getAskroomId() {
		return askroom_id;
	}
	
	public void setAskroomId(int askroom_id) {
		this.askroom_id = askroom_id;
	}
	
	public int getAccessLevel() {
		return access_level;
	}
	
	public void setAccessLevel(int access_level) {
		this.access_level = access_level;
	}
}
