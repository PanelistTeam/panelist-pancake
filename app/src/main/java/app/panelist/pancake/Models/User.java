package app.panelist.pancake.Models;

import java.sql.Timestamp;

public class User {
	private int id;
	private String display_name;
	private boolean full_account;
	private Timestamp member_since;
	private String email;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isFullAccount() {
		return full_account;
	}
	
	public void setFullAccount(boolean full_account) {
		this.full_account = full_account;
	}
	
	public String getDisplayName() {
		return display_name;
	}
	
	public void setDisplayName(String display_name) {
		this.display_name = display_name;
	}
	
	public Timestamp getMemberSince() {
		return member_since;
	}
	
	public void setMemberSince(Timestamp member_since) {
		this.member_since = member_since;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
