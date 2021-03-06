package testers;

import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.HashMap;

import main.*;

public class StudentTester {
    public static void menu(UniversitySystemTester UST, UniversitySystem US, int sId) {
        Student s = (Student) US.getUser(sId);
        menu : while(true) {
            UST.println("Choose command");
            UST.println("1) get courses list");
            UST.println("2) get course files");
            UST.println("3) get marks");
            UST.println("4) get view transcript"); 
            UST.println("5) get Attendance List For Specific Course");
            UST.println("6) register for course");
            UST.println("7) get self info");
            UST.println("8) get self system");
            UST.println("9) Exit");
            switch(UST.readInt()) {  
                case 1:
                    UST.println(s.getCourses().toString());
                    break;
                case 2:
                    UST.println(s.getCourseFiles().toString());
                    break;
                case 3:
                    UST.println(s.getMarks().toString());
                    break;
                case 4:
                    UST.println(s.viewTranscript().toString());
                    break;
                case 5:
                    UST.println("Enter course name:");
                    String courseName = UST.read();
                    Course co = null;
                    for(Course course : s.getCourses()) {
                        if(course.getName().equals(courseName))
                            co = course;
                    }
                    HashMap <GregorianCalendar, Boolean> map
                    		= s.viewAttendanceListForSpecificCourse(co);
                    String date = "";
                    for (GregorianCalendar calendar : map.keySet()) {
                    	date += calendar.toZonedDateTime()
                    		      .format(DateTimeFormatter.ofPattern("d MMM uuuu"));
                    	date += " [" + map.get(calendar) + "]";
                    }
                    UST.println(date);  
                    break;
                case 6:
                    UST.println("Enter course name:");
                    String course = UST.read();
                    UST.println("Enter teacher name:");
                    String teacherName = UST.read();
                    s.sendCourseRegistrationOrder("Course name [" + course 
                            + "], teacher [" + teacherName + "]");
                    UST.println("Course: " + course 
                        + " addition request for Student [" + s.getId() + "] sended.");
                    break;
                case 7:
                    UserInfo info = s.getInfo();
                    UST.println(info.toString());
                    break;
                case 8:
                    UniversitySystem us1 = s.getSys();
                    UST.println(us1.toString());
                    break;
                default :
                    break menu;
            }
        }
    }
}