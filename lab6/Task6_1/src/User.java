public class User {
	private String login;
	private String pass;
	
	public User(String login, String pass) {
		setLogin(login);
		setPass(pass);
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "login = " + login + ", pass = " + pass;
	}
}
