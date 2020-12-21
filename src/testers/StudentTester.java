package testers;

import main.*;

public class StudentTester {
    public static void menu(UniversitySystemTester UST, UniversitySystem US) {
        Student s = new Student("qwe", US);
        menu : while(true) {
            UST.println("Choose command");
            UST.println("1) get courses list");
            UST.println("2) get course files");
            UST.println("3) get marks");
            UST.println("4) get view transcript"); 
            UST.println("5) get Attendance List For Specific Course");
            UST.println("6) register for course");
            UST.println("7) Exit");
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
                    UST.println(s.viewAttendanceListForSpecificCourse(co).toString());  
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
                default :
                    break menu;
            }
        }
    }
}