package main;
import java.util.Vector;

public abstract class Requester extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8829104337618118023L;
	private Vector <Message> messages;
	
	public Requester() { super(); }
	
	public Requester(String password, UniversitySystem system) {
		super(password, system);
	}
	
	Vector <Message> getMessageList() {
		return messages;
	}
	
	public void addMessage(Message m) {
		messages.add(m);
	}
	
	void readMessage(int index) {
		messages.elementAt(index).setStatus(true);
	}
	
	void deleteMessage(int index) {
		messages.elementAt(index).delete();
	}
}
