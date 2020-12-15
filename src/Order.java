import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3462171518708932588L;
	private String message = "";
	private Calendar date = new GregorianCalendar();
	private int from;
	private int to;
	private Statuses status = Statuses.NEW;

	public Order(String message, int from, int to) {
		this.message = message;
		this.from = from;
		this.to = to;
	}

	public Order() { 
		this("", 0, 0);
	}
	
	public String getMessage() {
		return message;
	}
	
	public Statuses getStatus() { return status; }
	
	public void setFrom(int from) {
		this.from = from;
	}
	
	public void setTo(int to) {
		this.to = to;
	}
	
	public void setStatus(Statuses status) {
		this.status = status;
	}
	
	public void edit(String message) {
		this.message = message;
	}
	
	public void delete() {
		message = "Deleted";
	}
	
	public Object clone() throws CloneNotSupportedException{
		Order o = (Order)super.clone(); 
		return o;
	}
	
	public Object forward(int to, Message re) throws CloneNotSupportedException {
		Order o = (Order)this.clone();
		o.setTo(to);
		o.setFrom(this.to);
		return o;
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

		Order order = (Order)o;
		return this.hashCode() == order.hashCode();
	}

	public String toString() {
		return "Message [" + message + "]\n" 
				+ "Date [" + date + "]\n" 
				+ "From [" + from + "]\n" 
				+ "To [" + to + "]\n" 
				+ "Status [" + status + "]\n";
	}
}
