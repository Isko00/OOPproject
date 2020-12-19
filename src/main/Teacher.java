package main;
import java.util.Vector;
import java.util.HashMap;
import java.util.HashSet;

public class Teacher extends Requester {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5314522154448078014L;
	private HashSet<Course> courses = new HashSet<Course> ();
	
	public Teacher() {super();}
	public Teacher(String password) {
		super(password);
	}
	
	public void addCourseFile(Course course, CourseFile courseFile) {
		course.addFile(course, courseFile);
	}
	public void delCourseFile(Course course, CourseFile courseFile) {
		course.delete(course, courseFile);
	}
	public HashSet<Course> getCourses() {
		return courses;
	}
	
	public void sendItOrder(String message) {
		Order o = new Order(message);
		techSupportOrders.addNewOrder(o);
	}
	public void putMark(Course course, int student, int mark) {
		for(Student s: course.getStudentMarks.keySet()) {
			if(s.getId == student) {
				course.putMark(Student, mark);
				break;
			}
		}
	}
	public void sendCourseAdditionOrder(Course c) {
		OrderCourseAddition o = new OrderCourseAddition(c);
		managerOrders.addNewOrder(o);
	}
	HashMap <Student, Marks> getStudentsForCourse(Course course) {
		return course.getStudentMarks();
	}
}
