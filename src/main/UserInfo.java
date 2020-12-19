package main;
import java.util.HashMap;
import java.io.Serializable;

public class UserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6845130151436394015L;
	private HashMap<String, String> properties;
	
	public UserInfo() {
		properties = new HashMap<String, String>();
	}
	
	public void setProperty(String property, String value) {
		properties.putIfAbsent(property, value);
	}
	
	public String getProperty(String property) {
		return properties.get(property);
	}
	
	public HashMap<String, String> getAllProperties() {
		return properties;
	}
	
	public int hashCode() {
		return properties.hashCode();
	}
	
	public boolean equals(Object o) {
		return properties.equals(o);
	}
	
	public String toString() {
		String result = "";
		
		for (HashMap.Entry<String, String> entry : properties.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    result += key + " [" + value + "]\n";
		}

		return result;
	}
}