package main;

import java.util.GregorianCalendar;
import java.io.Serializable;

public class CourseFile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1234037302105082891L;
	private String link, name;
	private final GregorianCalendar uploadDate = new GregorianCalendar(); 
	
	public CourseFile(String name, String link) {
		this.name = name;
		this.link = link;
	}
	
	public CourseFile() {
		this("", "");
	}
	
	public String getName() { return name; }

	public String getLink() { return link; }

	public GregorianCalendar getDate() { 
		return uploadDate; 
	}
	
	public int hashCode() {
		return name.hashCode() + link.hashCode() 
				+ uploadDate.hashCode();
	}
	
	public boolean equals(Object o) {
		if ((this != o) 
				|| this == null
				|| this.getClass() != o.getClass()) {
			return false;
		}
		CourseFile file = (CourseFile) o;
		return this.hashCode() == file.hashCode();
	}
	
	public String toString() {
		return "Name [" + name + "]\n"
				+ "Link [" + link + "]\n"
				+ "Upload date [" + uploadDate.getTime() + "]";
	}
}