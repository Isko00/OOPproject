package main;

import java.util.Vector;

public class TechSupport extends ORManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2910614437880316074L;
	private static Vector<Order> orders = new Vector<Order>();
	
	public TechSupport() { super(); }
	
	public TechSupport(String password) { super(password); }
	
	public Order getUnreadOrder() {
		return super.getUnreadOrder(orders);
	}
	
	public static void addOrder(Order o) {
		addOrder(orders, o);
	}
}
