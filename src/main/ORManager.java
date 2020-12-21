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

	public void replyRejectedOrder(Order o, String text) {
		Requester r = (Requester) getSys().getUser(o.getFrom());
		r.addMessage(new Message(text, getId(), r.getId()));
	}
	
	public void rejectOrder(Order o, String text) {
		o.setStatus(Statuses.REJECTED);
		replyRejectedOrder(o, text);
	}
	
	public abstract void saveOrders();

	public abstract void loadOrders();
}