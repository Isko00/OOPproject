package main;

import java.util.Vector;

public class TechSupport extends ORManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2910614437880316074L;
	private static Vector<Order> orders = new Vector<Order>();

	public TechSupport() { super(); }
	
	public TechSupport(String password, UniversitySystem system) { 
		super(password, system); 
	}
	
	public Order getUnreadOrder() {
		return super.getUnreadOrder(orders);
	}

	public Vector<Order> getOrders() {
		return orders;
	}
	
	public static void addOrder(Order o) {
		addOrder(orders, o);
	}

	@Override
	public void saveOrders() {
		reserve = orders;
	}

	@Override
	public void loadOrders() {
		reserve = orders;
	}
}
