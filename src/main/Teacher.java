package main;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;

public class Teacher extends Requester {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5314522154448078014L;
	private HashSet<Course> courses = new HashSet<Course> ();
	
	public Teacher() { super(); }
	
	public Teacher(String password, UniversitySystem system) {
		super(password, system);
	}
		
	public void delCourseFile(Course course, CourseFile courseFile) {
		course.deleteFile(courseFile);
	}
	
	public HashSet<Course> getCourses() {
		return courses;
	}
	
	public void addCourseFile(Course c, CourseFile cf) {
		c.addFile(cf);
	}
	
	public HashMap<Course, Marks> getMarksForStudent(Student s) {
		HashMap<Course, Marks> result
				= new HashMap<Course, Marks>();
		for (Course c : courses) {
			if (c.containsStudent(s)) {
				result.put(c, c.getMarksForStudent(s));
			}
		}

		return result;
	}
	
	public boolean hasStudent(Student s) {
		for (Course c : courses) {
			if (c.containsStudent(s)) {
				return true;
			}
		}
		
		return false;
	}

	public void sendItOrder(String message) {
		Order o = new Order(message, getId());
		TechSupport.addOrder(o);
	}
	
	public void putMark(Course course, int studentId, int mark) {
		Student s = (Student) getSys().getUser(studentId);
		course.putMark(s, mark);
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public void sendCourseAdditionOrder(Course c) {
		Order o = new Order(c.toString(), getId());
		Manager.addOrder(o);
	}
	
	public void sendCourseAdditionOrder(String s) {
		Order o = new Order(s, getId());
		Manager.addOrder(o);
	}
	
	public void deleteCourse(String courseName) {
		for (Course c : courses) {
			if (c.getName().equals(courseName)) {
				courses.remove(c);
				return;
			}
		}
	}
	
	public HashMap <Student, Marks> getStudentsForCourse(Course course) {
		return course.getStudentMarks();
	}
	
	/* Bonus */
	// Attendance list for specific course
	public void putAttendance(Course c, GregorianCalendar date, 
			HashMap <Student, Boolean> attendance) {
		
		c.putAttendance(date, attendance);
	}
	 
	public HashMap<Student, Boolean> getAttendance(Course course, 
			GregorianCalendar date) {
		
		return course.getAttendance(date);
	}
}
