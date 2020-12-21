package testers;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;
import main.*;

public class TeacherTester {
	public static Course getCourse(Teacher t, String courseName) throws CourseOperationException {
		Course co = null;
		for(Course course : t.getCourses()) {
			if(course.getName().equals(courseName)) {
				co = course;
			}
		}
		if (co == null) {
			throw new CourseOperationException("Wrong course name!");
		} else {
			return co;
		}
	}
	public static void menu(UniversitySystemTester UST, UniversitySystem US) {
		Teacher t = new Teacher("qwe", US);
		menu : while(true) {
			UST.println("Choose command");
			UST.println("1) get courses list");
			UST.println("2) add course file");
			UST.println("3) delete course file");
			UST.println("4) get marks for student"); 
			UST.println("5) put mark");
			UST.println("6) add course");
			UST.println("7) delete course");
			UST.println("8) get students for course");
			UST.println("9) put attendance");
			UST.println("10) Exit");
			
			switch(UST.readInt()) {  
				case 1:
					UST.println(t.getCourses().toString());
					break;
				case 2:
					UST.println("Type course name");
					String courseName = UST.read();
					UST.println("Type course file name");
					String name = UST.read();
					UST.println("Type course file link");
					String link = UST.read();
					CourseFile file = new CourseFile(name, link);
					try {
						Course co = getCourse(t, courseName);
						t.addCourseFile(co, file);
						UST.println("Course file successfully added");
					} catch(CourseOperationException e) {
						e.printStackTrace();
					}
					break;
				case 3:
					UST.println("Type course name");
					courseName = UST.read();
					UST.println("Type course file name");
					name = UST.read();
					try {
						Course cou = getCourse(t, courseName);
						CourseFile filee = null;
						for(CourseFile courseFile : cou.getCourseFiles()) {
							if(courseFile.getName().equals(name)) {
								filee = courseFile;
							}
						}
						t.delCourseFile(cou, filee);
						UST.println("Course file successfully deleted");
					} catch(CourseOperationException e) {
						e.printStackTrace();
					}
					
					break;
				case 4:
					UST.println("Type id of student");
					int id = UST.readInt();
					Vector <User> students = US.getAllUsers().get(UserType.STUDENT);
					Student st = null;
					for(User student : students) {
						if(student.getId() == id)
							st = (Student)student;
					}
					UST.println(t.getMarksForStudent(st).toString());
					break;
				case 5:
					UST.println("Enter course name:");
					courseName = UST.read();
					UST.println("Enter student id:");
					id = UST.readInt();
					UST.println("Enter mark:");
					int mark = UST.readInt();
					try {
						Course course5 = getCourse(t, courseName);
						t.putMark(course5, id, mark);
						UST.println("Marks successfully putted");
					} catch(CourseOperationException e) {
						e.printStackTrace();
					}
					break;
				case 6:
					UST.println("Enter course name:");
					String courseName6 = UST.read();
					t.sendCourseAdditionOrder(courseName6);
					UST.println("order sent");
				case 7:
					UST.println("Enter course name:");
					String courseName7 = UST.read();
					t.deleteCourse(courseName7);
					UST.println("Course: " + courseName7 + " successfully deleted");
				case 8:
					UST.println("Enter course name:");
					String courseName8 = UST.read();
					try {
						Course course8 = getCourse(t, courseName8);
						UST.println(t.getStudentsForCourse(course8).toString());
					} catch(CourseOperationException e) {
						e.printStackTrace();
					}
				case 9:
					UST.println("Enter course name");
					String courseName9 = UST.read();
					GregorianCalendar date = new GregorianCalendar();
					try {
						Course course9 = getCourse(t, courseName9);
						UST.println("Enter 1 if exists, else 0 for each student");

						HashMap <Student, Boolean> attendance = new HashMap <Student, Boolean>();
						for(Student student : course9.getStudentMarks().keySet()) {
							UST.println(student.getId() + "");
							boolean ex;
							int ok = UST.readInt();
							if(ok == 0) ex = false; else ex = true;
							attendance.put(student, ex);
						}
						t.putAttendance(course9, date, attendance);
						UST.println("Attendance list successfully uploaded");
					} catch(CourseOperationException e) {
						e.printStackTrace();
					}
				default :
					break menu;
			}
		}
	}
}