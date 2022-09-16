package dto;

public class User {
	private int userSeq;
	private String userId;
	private String password;
	private String userName;
	
	
	
	public User() {
		super();
	}



	public User(int userSeq, String userId, String password, String userName, String nickName, String email) {
		super();
		this.userSeq = userSeq;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
	}



	public int getUserSeq() {
		return userSeq;
	}



	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}







	@Override
	public String toString() {
		return "User [userSeq=" + userSeq + ", userId=" + userId + ", password=" + password + ", userName=" + userName
				+"]";
	}
	
	
	
	
	
}
