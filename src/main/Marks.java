package main;

import java.io.Serializable;

public class Marks implements Serializable {
	
	private static final long serialVersionUID = 845427730499347868L;
	/* First certification = marks[0]
	 * Second certification = marks[1]
	 * Final exam = marks[2]
	 */
	public int[] marks;
	public int certificationNum = 0;

	public Marks () {
		marks = new int[3];
	}

	public void putMark(int mark) {
		marks[certificationNum] = mark;
		certificationNum++;
	}

	public int hashCode() {
	    return marks[0] * 100
	    		+ marks[1] * 10
	    		+ marks[2];
	}
	
	public boolean equals(Object o) {
		if ((this != o) 
				|| this == null
				|| this.getClass() != o.getClass()) {
			return false;
		}
		Marks mark = (Marks)o;
		return this.hashCode() == mark.hashCode();
	}

	public String toString() {
		return "First certification [" + marks[0] + "]\n"
				+ "Second certification [" + marks[1] + "]\n"
				+ "Final exam [" + marks[2] + "]";
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	public int[] getMarks() { return marks; }

	public String getMarkChar(int mark) {
		if (100 >= mark && mark >= 95) return "A";
		else if (94 >= mark && mark >= 90) return "A-";
		else if (89 >= mark && mark >= 85) return "B+";
		else if (84 >= mark && mark >= 80) return "B";
		else if (79 >= mark && mark >= 75) return "B-";
		else if (74 >= mark && mark >= 70) return "C+";
		else if (69 >= mark && mark >= 65) return "C";
		else if (64 >= mark && mark >= 60) return "C-";
		else if (60 >= mark && mark >= 50) return "D";
		else return "F";
	}

	public double getGPA() {
		double result = 0;
		for (int i : marks) {
			result += i;
		}
	    return result / 25;
	}
}
