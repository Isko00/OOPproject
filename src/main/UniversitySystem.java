package main;
import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

public class UniversitySystem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3055240074839513380L;
	private HashMap<Integer, User> users = new HashMap<Integer, User>();
	private static UniversitySystem INSTANCE = new UniversitySystem();	

	static FileInputStream fis;
	static FileOutputStream fos;
	static ObjectOutputStream oos;
	static ObjectInputStream oin;

	public static void deserialize() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("backUp");
		oin = new ObjectInputStream(fis);
		INSTANCE = (UniversitySystem) oin.readObject();
	}
	
	public static void serialize() throws IOException {
		fos = new FileOutputStream("backUp");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(INSTANCE);
		oos.close();
	}
	
	private UniversitySystem() {}
	
	public static UniversitySystem getInstance() {
		return INSTANCE;
	}
	
	public User getUser(int id) {
		return users.get(id);
	}
	
	public HashMap<UserType, Vector<User>> getAllUsers() {
		Vector<User> teachers = new Vector<User>();
		Vector<User> students = new Vector<User>();
		Vector<User> admins = new Vector<User>();
		Vector<User> managers = new Vector<User>();
		Vector<User> techSupports = new Vector<User>();
		System.out.println("size " + users.values().size());
		for (User u : users.values()) {
			if (u instanceof Teacher) {
				teachers.add(u);
			} else if (u instanceof Student) {
				students.add(u);
			} else if (u instanceof Admin) {
				admins.add(u);
			} else if (u instanceof Manager) {
				managers.add(u);
			} else if (u instanceof TechSupport) {
				techSupports.add(u);
			}
		}

		HashMap<UserType, Vector<User>> sortedUsers = new HashMap<UserType, Vector<User>>();

		sortedUsers.put(UserType.TEACHER, teachers);
		sortedUsers.put(UserType.STUDENT, students);
		sortedUsers.put(UserType.MANAGER, managers);
		sortedUsers.put(UserType.ADMIN, admins);
		sortedUsers.put(UserType.TECHSUPPORT, techSupports);
		
		return sortedUsers;
	}

	public void register(User user) {
		users.putIfAbsent((Integer) user.getId(), user);
	}
	
	public User autorise(int id, String password) throws UserDataException {
		if (!users.containsKey(id)) {
			throw new UserDataException("Wrong login!");
		} else if (!users.get(id).checkPassword(password)) {
			throw new UserDataException("Wrong password!");
		} else {
			return (User) users.get(id);
		}
	}
	
	public void deleteUser(int id) {
		users.remove(id);
	}
	
	public int getLastId() {
		return Collections.max(users.keySet());
	}
	
	public String toString() {
		HashMap<UserType, Vector<User> > map = getAllUsers();
		String result = "";
		for (UserType u : map.keySet()) {
			result += u + " [" + map.get(u) + "]\n";
		}
		
		return result;
	}
}