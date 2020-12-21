package main;

import java.util.Vector;

public class Admin extends ORManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2412196862726793555L;
	private static Vector<Order> orders = new Vector<Order>();
	
	public Admin() { super(); }
	
	public Admin(String password, UniversitySystem system) { 
		super(password, system); 
	}
	
	@Override
	public Order getUnreadOrder() {
		return super.getUnreadOrder(orders);
	}
	
	public Vector<Order> getOrders() {
		return orders;
	}
	
	public static void addOrder(Order o) {
		addOrder(orders, o);
	}
	
	public void addUser(UserType type, String password) {
		User u;
		switch(type) {
		  case STUDENT:
		    u = new Student(password);
		    break;
		  case TEACHER:
			 u = new Teacher(password);
		    break;
		  case MANAGER:
			 u = new Manager(password);
		    break;
		  case TECHSUPPORT:
			 u = new TechSupport(password);
		    break;
		  case ADMIN:
			 u = new Admin(password, getSys());
		    break;
		  default:
			 u = new User();
		}
		
		getSys().register(u);
	}
	
	public void deleteUser(User u) {
		deleteUser(u.getId());
	}
	
	public void deleteUser(int id) {
		getSys().deleteUser(id);
	}
	
	public void updateInfo (User u, String property, String value) {
		UserInfo info = u.getInfo();
		info.setProperty(property, value);
		u.setInfo(info);
	}
	
	public void updateInfo (int userId, String property, String value) {
		User u = getSys().getUser(userId);
		updateInfo(u, property, value);
	}
}