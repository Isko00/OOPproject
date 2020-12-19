package main;
import java.util.Vector;
import java.util.HashMap;
import java.util.HashSet;

public class Student extends Requester {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6757927690609941571L;
	public Student() { super(); }
	public Student(String password) {
		super(password);
	}
	
	HashMap <Course, HashSet <CourseFile> > getCourseFiles() {
		HashMap <Course, HashSet <CourseFile> > ret;
		Vector <Teacher> teachers = UniversitySystem.getTeachers;
		for(Teacher t : teachers)
			for(Course c : t.getCourses)
				for(Student s : c.getStudentMarks.keySet())
					if(s.equals(this)) { 
						ret.put(c, c.getCourseFiles);
						break;
					}
		return ret;
	}
	
	Marks getMarksForSpecificCourse(Course course) {
		Marks ret = null;
		Vector <Teacher> teachers = UniversitySystem.getTeachers;
		for(Teacher t : teachers)
			for(Course c : t.getCourses)
				if(c.equals(course))
					ret = c.getStudentMarks.get(this);
		return ret;
	}
	
	HashMap <Course, Marks> viewTranscript() {
		HashMap <Course, Marks> ret = new HashMap <Course, Marks> ();
		for(Teacher t : UniversitySystem.getTeachers())
			for(Course c : t.getCourses())
				for(Student s : c.getStudentMarks().keySet())
					if(s.equals(this)) { 
						ret.put(c, c.getStudentMarks().get(this));
						break;
					}
		return ret;
	}
	UserInfo getInfoTeacherOfSpeCourse(Course course) {
		UserInfo ret = new UserInfo();
		for(Teacher t : UniversitySystem.getTeachers())
			for(Course c : t.getCourses())
				if(c.equals(course))
					ret = t.getInfo();
		return ret;
	}
	
	public void sendItOrder(String text) {
		TechSupport.addOrder(new Order(text, getId()));
	}
}