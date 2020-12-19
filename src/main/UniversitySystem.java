package main;
import java.io.Serializable;
import java.util.HashMap;

public class UniversitySystem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3055240074839513380L;
	private static HashMap<Integer, User> users = new HashMap<Integer, User>();
	private static final UniversitySystem INSTANCE = new UniversitySystem();
	
	private UniversitySystem() {}
	
	public static UniversitySystem getInstance() {
		return INSTANCE;
	}
	
	public static User getUser(int id) {
		return users.get(id);
	}
	
	public static void register(User user) {
		users.putIfAbsent((Integer) user.getId(), user);
	}
	
	public static User autorise(int id, String password) throws UserAuthorizationException {
		if (!users.containsKey(id)) {
			throw new UserAuthorizationException("Wrong login!");
		} else if (!users.get(id).checkPassword(password)) {
			throw new UserAuthorizationException("Wrong login!");
		} else {
			return (User) users.get(id);
		}
	}
}