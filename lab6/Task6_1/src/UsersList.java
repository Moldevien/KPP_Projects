import java.util.ArrayList;
import java.util.List;

public class UsersList {
	private List<User> users;
	
	public UsersList() {
		this.users = new ArrayList<>();
	}
	
	public UsersList(List<User> users) {
		this.users = users;
	}
	
	public boolean add(String login, String pass) {
		if (check(login)) {
			return false;
		}
		users.add(new User(login, pass));
		return true;
	}
	
	public boolean editLogin(String login, String newLogin) {
		if (!check(login)) {
			return false;
		}
		getUser(login).setLogin(newLogin);
		return true;
	}
	
	public boolean editPass(String login, String newPass) {
		if (!check(login)) {
			return false;
		}
		getUser(login).setPass(newPass);
		return true;
	}
	
	public boolean delete(String login) {
		return users.removeIf(user -> user.getLogin().equals(login));
	}
	
	public boolean check(String login) {
		return users.stream().anyMatch(user -> user.getLogin().equals(login));
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public User getUser(String login) {
		return users.stream().filter(user -> user.getLogin().equals(login)).findFirst().get();
	}
	
	public void showAll() {
		users.stream().forEach(user -> System.out.println(user.toString()));
	}
}
