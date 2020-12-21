package main;
import java.util.Vector;

public abstract class ORManager extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8829104337618118023L;

	public Vector<Order> reserve = new Vector<Order>();
	public ORManager() { super(); }

	public ORManager(String password, UniversitySystem system) {
		super(password, system);
	}
	
	public ORManager(String password) {
		super(password);
	}

	public Order getUnreadOrder(Vector<Order> v) {
		Order o = v.firstElement();
		if (!o.isNew()) { o = null; }
		return o;
	}

	public abstract Order getUnreadOrder();
	
	public static void addOrder(Vector<Order> v, Order o) {
		v.add(o);
	}
	
	public void acceptOrder(Order o) {
		o.setStatus(Statuses.ACCEPTED);
	}

	public void rejectOrder(Order o, String text) {
		o.setStatus(Statuses.REJECTED);
		replyRejectedOrder(o, text);
	}
	
	public void replyRejectedOrder(Order o, String text) {
		User u = getSys().getUser(o.getFrom());
		if (u instanceof Requester) {
			Requester r = (Requester) u;
			r.addMessage(new Message(text, getId(), r.getId()));
		} 
	}
	
	public abstract void saveOrders();

	public abstract void loadOrders();
}