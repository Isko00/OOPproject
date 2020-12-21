package main;
import java.util.Vector;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;

public class Student extends Requester {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6757927690609941571L;
	
	public Student() { super(); }
	
	public Student(String password, UniversitySystem system) {
		super(password, system);
	}
	
	public Vector<User> teachers 
			= getSys().getAllUsers().get(UserType.TEACHER);

	public Vector<Course> getCourses() {
		Vector<Course> result = new Vector<Course>();
		
		for (User u : teachers) {
			Teacher t = (Teacher) u;
			result.addAll(t.getMarksForStudent(this).keySet());
		}
		
		return result;
	}
	
	public HashMap <Course, HashSet <CourseFile> > getCourseFiles() {
		HashMap <Course, HashSet <CourseFile> > result;
		result = new HashMap <Course, HashSet <CourseFile> >() ;

		for (Course c : getCourses()) {
			result.put(c, c.getCourseFiles());
		}
		
		return result;
	}
	
	public HashMap<Course, Marks> getMarks() {
		HashMap<Course, Marks> result = new HashMap<Course, Marks>();
		
		for (User u : teachers) {
			Teacher t = (Teacher) u;
			result.putAll(t.getMarksForStudent(this));
		}
		
		return result;
	}
	
	public HashMap <Course, Marks> viewTranscript() {
		HashMap <Course, Marks> ret = new HashMap <Course, Marks> ();
		for (User u : teachers) {
			Teacher t = (Teacher) u;
			ret.putAll(t.getMarksForStudent(this));
		}
		return ret;
	}
	
	public UserInfo getInfoTeacherOfCourse(Course course) {
		return course.getCourseTeacher().getInfo();
	}
	
	public void sendItOrder(String text) {
		TechSupport.addOrder(new Order(text, getId()));
	}
	
	public void sendCourseRegistrationOrder(String text) {
		sendCourseRegistrationOrder(new Order(text, getId()));
	}
	
	public void sendCourseRegistrationOrder(Order o) {
		Manager.addOrder(o);
	}
	
	/* Bonus */
	//Get attendance list for specific course
	public HashMap <GregorianCalendar, Boolean> 
			viewAttendanceListForSpecificCourse(Course course) {
		return course.getAttendanceListForStudent(this);
	}
}