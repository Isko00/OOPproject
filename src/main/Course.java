package main;
import java.util.HashMap;
import java.util.HashSet;
import java.util.GregorianCalendar;
import java.io.Serializable;

public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8711961955621914862L;
	private String name;
	private Teacher teacher;
	private HashSet <CourseFile> courseFiles = new HashSet <CourseFile>();
	private HashMap <Student, Marks> studentsMarks = new HashMap <Student, Marks>();
	private HashMap <GregorianCalendar, HashMap<Student, Boolean> > attendance 
			= new HashMap <GregorianCalendar, HashMap<Student, Boolean> >();
	
	public Course() {}

	public Course(String name, Teacher teacher) {
		this.name = name;
		this.teacher = teacher;
	}
	
	//Add student for course
	public void addStudent(Student student) {
		studentsMarks.put(student, new Marks());
		System.out.println(studentsMarks);
	}

	//Delete course file
	public void addFile(CourseFile courseFile) {
		courseFiles.add(courseFile);
	}
	//Delete course file
	public void deleteFile(CourseFile courseFile) {
		courseFiles.remove(courseFile);
	}

	//Get course Files
	public HashSet <CourseFile> getCourseFiles() {
		return courseFiles;
	}

	public HashMap <Student, Marks> getStudentMarks() {
		return studentsMarks;
	}

	public Marks getMarksForStudent(Student s) {
		return studentsMarks.get(s);
	}
	
	//Get teacher of Course
	public Teacher getCourseTeacher() {
		return teacher;
	}
	
	public String getName() { return name; }
	
	//Return true if student registered for this course 
	public boolean containsStudent(Student student) {
		return studentsMarks.containsKey(student);
	}
	
	/* BONUS */
	//for Teachers. They can upload attendance list by date
	public void putAttendance(GregorianCalendar date, HashMap <Student, Boolean> attendance) { 
		this.attendance.put(date, attendance);
	}
	
	//forStudents. They can download their own attendances
	public HashMap <GregorianCalendar, Boolean> 
			getAttendanceListForStudent(Student student) {
		
		HashMap <GregorianCalendar, Boolean> ret 
				= new HashMap <GregorianCalendar, Boolean>();
		for(GregorianCalendar date : attendance.keySet()) {
			ret.put(date, attendance.get(date).get(student));
		}
		return ret;
	}
	
	//For Teachers to check
	public HashMap<Student, Boolean> getAttendance(GregorianCalendar date) {
		return attendance.get(date);
	}
	
	public void putMark(Student s, int mark) {
		Marks m = studentsMarks.get(s);
		m.putMark(mark);
	}
	
	public String toString() {
		return "Name [" + name + "]\n"
				+ "Teacher [" + teacher + "]";
	}
}
