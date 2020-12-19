package main;
import java.util.Vector;

public abstract class ORManager extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8829104337618118023L;

	public ORManager() { super(); }

	public ORManager(String password) {
		super(password);
	}

	public Order getUnreadOrder(Vector<Order> v) {
		Order o = v.firstElement();
		if (!o.isNew()) { o = null; }
		return o;
	}
	
	public static void addOrder(Vector<Order> v, Order o) {
		v.add(o);
	}

	public abstract Order getUnreadOrder();
	
	@SuppressWarnings("unused")
	private void acceptOrder(Order o) {
		o.setStatus(Statuses.ACCEPTED);
	}

	private void replyRejectedOrder(Order o, String text) {
		Requester r = (Requester) UniversitySystem.getUser(o.getFrom());
		r.addMessage(new Message(text, getId(), r.getId()));
	}
	
	@SuppressWarnings("unused")
	private void rejectOrder(Order o, String text) {
		o.setStatus(Statuses.REJECTED);
		replyRejectedOrder(o, text);
	}
}