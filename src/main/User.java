package main;
import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5768743020744465843L;
	private final int id;
	private String password;
	private UserInfo info;
	private static UniversitySystem system = UniversitySystem.getInstance();
	
	public User(String password, UniversitySystem newSystem) {
		this(password);
		system = newSystem;
	}
	
	public User(String password, UserInfo info) {
		this.setPassword(password);
		this.info = info;
		id = system.getLastId() + 1;
	}
	
	public User(String password) {
		this(password, new UserInfo());
	}
	
	public User() {
		this("");
	}
	
	public int getId() { return id; }
	
	public UserInfo getInfo() { return info; }
	
	public String getPassword() { return password; }
	
	public UniversitySystem getSys() { return system; }
	
	public void setInfo(UserInfo info) { this.info = info; }
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public int hashCode() { return id; }
	
	public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        User u = (User) o;
        return hashCode() == u.hashCode();
	}

	public String toString() {
		return "id [" + id + "]\n"
				+ "info [" + info.toString() + "]";
	}
}
