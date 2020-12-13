import java.io.Serializable;

public abstract class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5768743020744465843L;
	private final int id;
	private static int lastId = 0;
	private String password;
	private UserInfo info;

	public User(String password, UserInfo info) {
		this.setPassword(password);
		this.info = info;
		id = lastId++;
	}
	
	public User(String password) {
		this(password, new UserInfo());
	}
	
	public User() {
		this("");
	}
	
	public int getId() { return id; }
	
	public UserInfo getInfo() { return info; }
	
	public String getPassword() {
		return password;
	}

	public void setInfo(UserInfo info) { this.info = info; }
	
	public void setPassword(String password) {
		this.password = password;
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
