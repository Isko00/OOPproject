package main;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Order implements Serializable, Comparable<Order> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3462171518708932588L;
	private String message = "";
	private Calendar date = new GregorianCalendar();
	private int from;
	private Statuses status = Statuses.NEW;

	public Order(String message, int from) {
		this.message = message;
		this.from = from;
	}

	public Order() { 
		this("", 0);
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getFrom() { return from; }
	
	public Statuses getStatus() { return status; }
	
	public Calendar getDate() { return date; }
	
	public void setFrom(int from) {
		this.from = from;
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

	public boolean isNew() { return status == Statuses.NEW; }
	
	public int compareTo(Order o){
		if (status == o.getStatus()) {
			return date.compareTo(o.getDate());
		} else {
			return (int) Math.signum(status.getCode() - o.getStatus().getCode());
		}
    }
	
	public int hashCode() {
		int prime = 17;
		int res = 11;
		res = res * prime + message.hashCode();
		res = res * prime + date.hashCode();
		res = res * prime + from;
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
				+ "Status [" + status + "]\n";
	}
}
