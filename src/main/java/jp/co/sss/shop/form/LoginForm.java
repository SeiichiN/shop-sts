package jp.co.sss.shop.form;

public class LoginForm {
	private int userId;
	private String password;
	
	public int getUserId() { return userId; }
	public String getPassword() { return password; }
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
