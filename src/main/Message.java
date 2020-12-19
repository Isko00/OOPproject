package main;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Message implements Cloneable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3462171518708932588L;
	private String message = "";
	private Calendar date = new GregorianCalendar();
	private int from;
	private int to;
	private boolean status = false; // 1 read
	private Message re = null;

	public Message(String message, int from, int to, Message re) {
		this.message = message;
		this.from = from;
		this.to = to;
		this.re = re;
	} 
	
	public Message(String message, int from, int to) {
		this(message, from, to, null);
	}

	public Message() { 
		this("", 0, 0, new Message());
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setFrom(int from) {
		this.from = from;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public void setRe(Message re) {
		this.re = re;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void edit(String message) {
		this.message = message;
	}
	public void delete() {
		message = "Deleted";
	}
	
	public Object clone() throws CloneNotSupportedException{
		Message m = (Message)super.clone(); 
		return m;
	}
	public Object forward(int to, Message re) throws CloneNotSupportedException {
		Message m = (Message)this.clone();
		m.setTo(to);
		m.setRe(re);
		m.setFrom(this.to);
		m.setStatus(false);
		return m;
	}

	public int HashCode() {
		int prime = 17;
		int res = 11;
		res = res * prime + message.hashCode();
		res = res * prime + date.hashCode();
		res = res * prime + from;
		res = res * prime + to;
		return res % 1000007 + 1000007;
	}

	public boolean equals(Object o) {
		if(o == null
				|| this != o
				|| o.getClass() != this.getClass()) {
			return false;
		}

		Message m = (Message)o;
		return this.hashCode() == m.hashCode();
	}

	public String toString() {
		return "Message [" + message + "]\n" 
				+ "Date [" + date + "]\n" 
				+ "From [" + from + "]\n" 
				+ "To [" + to + "]\n" 
				+ "Status [" + status + "]\n"
				+ "Re [" + ((re != null) ? re.getMessage() : "") + "]";
	}
}