package main;

import java.util.Vector;

public class Manager extends ORManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6358131110453879595L;
	private static Vector<Order> orders = new Vector<Order>();
	
	public Manager() { super(); }
	
	public Manager(String password) { super(password); }

	public Order getUnreadOrder() {
		return super.getUnreadOrder(orders);
	}
	
	public static void addOrder(Order o) {
		addOrder(orders, o);
	}		
}