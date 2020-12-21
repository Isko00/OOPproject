package main;

import java.util.HashSet;
import java.util.Vector;

public class Manager extends ORManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6358131110453879595L;
	
	private static Vector<Order> orders = new Vector<Order>();
	
	public Manager() { super(); }
	
	public Manager(String password, UniversitySystem system) { 
		super(password, system); 
	}

	public Order getUnreadOrder() {
		return super.getUnreadOrder(orders);
	}

	public Vector<Order> getOrders() {
		return orders;
	}
	
	public static void addOrder(Order o) {
		addOrder(orders, o);
	}
	
	public void addCourse(Teacher teacher, Course course) {
		teacher.addCourse(course);
	}
	
	public void addCourse(int tId, String courseName) throws UserDataException {
		User u = getSys().getUser(tId);
		if (u instanceof Teacher) {
			Teacher t = (Teacher) u;
			addCourse(t, new Course(courseName, t));
		} else {
			System.out.println(system.toString());
			throw new UserDataException("Wrong id!");
		}
	}

	public UserInfo getTeacherInfo(int tId) {
		return getSys().getUser(tId).getInfo();
	}
	
	public static void addStudentToCourse(Student s, Course c) {
		c.addStudent(s);
	}
	
	public void addStudentToCourse(int sId, Course c) {
		Student s = (Student) getSys().getUser(sId);
		addStudentToCourse(s, c);
	}
	
	public void addStudentToCourse(int sId, String courseName) 
			throws CourseOperationException {
		
		Course c = getCourse(courseName);
		if (c == null) {
			throw new CourseOperationException("Wrong course name!");
		}
		addStudentToCourse(sId, c);
	}
	
	public HashSet<Course> getAllCourses() {
		HashSet<Course> result = new HashSet<Course>();
		
		for (User u : getSys().getAllUsers().get(UserType.TEACHER)) {
			Teacher t = (Teacher) u;
			result.addAll(t.getCourses());
		}
		
		return result;
	}
	
	public void deleteCourse(int tId, String courseName) throws UserDataException {
		User u = getSys().getUser(tId);
		Teacher t;
		if (u instanceof Teacher) {
			t = (Teacher) u;
		} else {
			throw new UserDataException("Wrong id!");
		}
		t.deleteCourse(courseName);
	}
	
	public Course getCourse(String name) {
		for (User u : getSys().getAllUsers().get(UserType.TEACHER)) {
			Teacher t = (Teacher) u;
			if (t.getCourses().size() > 0) {
				for (Course c : t.getCourses()) {
					if (c.getName().equals(name)) {
						return c;
					}
				}
			}
		}
		return null;
	}

	@Override
	public void saveOrders() {
		reserve = orders;
	}

	@Override
	public void loadOrders() {
		orders = reserve;
	}
}