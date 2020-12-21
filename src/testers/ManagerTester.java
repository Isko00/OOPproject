package testers;

import java.util.HashSet;
import java.util.Vector;

import main.*;

public class ManagerTester {
	public static void menu(UniversitySystemTester UST, UniversitySystem US) {
		Manager m = new Manager("qwe", US);
		menu : while(true) {
			UST.println("Select action:");
			UST.println("1) Add course");
			UST.println("2) Add student to course");
			UST.println("3) Delete course");
			UST.println("4) Check unread order");
			UST.println("5) Check done order");
			UST.println("6) Get all courses");
			UST.println("7) Exit");
			
			switch(UST.readInt()) {
				case 1:
					addCourse : while(true) {
						UST.println("Type teacher id");
						int id = UST.readInt();
						UST.println("Type course name");
						String name = UST.read();
						
						try {
							m.addCourse(id, name);
							UST.println("Course added");
						} catch(UserDataException e) {
							e.printStackTrace();
						}
						
			
						UST.println("1) add one more course");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
						int choise = UST.readInt();
						if (choise == 1) continue addCourse;
						if (choise == 2) continue menu;
						if (choise == 3) break menu;
						break;
					}
					break;
				case 2:
					addStudentToCourse : while(true) {
						UST.println("Enter student id:");
						int id = UST.readInt();
						UST.println("Enter course name:");
						String name = UST.read();
						
						try {
							m.addStudentToCourse(id, name);
							UST.println("Student added");
						} catch(CourseOperationException e) {
							e.printStackTrace();
						}
						
						UST.println("1) Update one more property");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
						
						int choise = UST.readInt(); 
						if (choise == 1) continue addStudentToCourse;
						if (choise == 2) continue menu;
						if (choise == 3) break menu;
						
						break;
					}
					break;
				case 3:
					deleteCourse : while(true) {
						UST.println("Enter teacher id:");
						int id = UST.readInt();
						
						UST.println("Enter course name:");
						String name = UST.read();
						try {
							m.deleteCourse(id, name);
							UST.println("Course deleted");
						} catch(UserDataException e) {
							e.printStackTrace();
						}
						
						UST.println("1) Delete one more course");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
						
						int choise = UST.readInt();
						if (choise == 1) continue deleteCourse;
						if (choise == 2) continue menu;
						if (choise == 3) break menu;
						
						break;
					}
					break;
				case 4:
					checkUnreadOrder : while(true) {
						Order o = m.getUnreadOrder();
						UST.println(o.toString());
		
						UST.println("Select action:");

						UST.println("1) Accept order");
						UST.println("2) Reject order");
						UST.println("3) Exit");
						
						int choise = UST.readInt(); 
						if (choise == 1) m.acceptOrder(o);
						if (choise == 2) {
							UST.println("Type reason you send for teacher:");
							String reason = UST.read();
							m.rejectOrder(o, reason);

							UST.println("Order rejected");
						}
						if (choise == 3) break menu;
						
						UST.println("1) Check one more unread order");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
						
						choise = UST.readInt();
						if (choise == 1) continue checkUnreadOrder;
						if (choise == 2) continue menu;
						if (choise == 3) break menu;
						
						break;
					}
					break;
				case 5:
					
					checkOrders : while(true) {
						Vector<Order> v = m.getOrders();
						for (Order o : v) {
							UST.println(o.toString());
							UST.println("");
						}
				
						UST.println("Orders printed");
						
						UST.println("1) Print one more time");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
						
						int choise = UST.readInt();
						if (choise == 1) continue checkOrders;
						if (choise == 2) continue menu;
						if (choise == 3) break menu;
						
						break;
					}
					break;

				case 6:
					getAllCourses : while(true) {
						HashSet<Course> set =  m.getAllCourses();
						
						for (Course c : set) {
							UST.println(c.toString());	
						}
				
						UST.println("Courses printed");
						
						UST.println("1) Print one more time");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
						
						int choise = UST.readInt(); 
						if (choise == 1) continue getAllCourses;
						if (choise == 2) continue menu;
						if (choise == 3) break menu;
						
						break;
					}
					break;
					
				default :
					break menu;
			}
		}
	}
}
