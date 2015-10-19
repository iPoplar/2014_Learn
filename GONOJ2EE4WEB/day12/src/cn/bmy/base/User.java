package cn.bmy.base;

public class User 
{
	private String username;
	private String gender;
	private String likes[];
	
	
	
	public User() {
		super();
	}


	public User(String username) {
		super();
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getLikes() {
		return likes;
	}
	public void setLikes(String[] likes) {
		this.likes = likes;
	}
	
}
