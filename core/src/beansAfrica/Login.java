package beansAfrica;

public class Login {
	private String username;
	private String password;
	public Login(String username2, String password2) {
		this.username=username2;
		this.password=password2;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
