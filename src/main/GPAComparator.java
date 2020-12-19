package main;
import java.util.Comparator;

public class GPAComparator implements Comparator<Student>{
	public int compare(Student s1, Student s2) {
		return s1.getGPA().compareTo(s2.getGPA());
	}
}