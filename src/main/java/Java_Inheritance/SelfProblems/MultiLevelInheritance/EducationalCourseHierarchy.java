/*
Program 2: Educational Course Hierarchy (Multilevel Inheritance)
Course -> OnlineCourse -> PaidOnlineCourse
Each level adds its own course details.
 */

package Java_Inheritance.SelfProblems.MultilevelInheritance;

class Course {
    String courseName;
    int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    int discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded,
                     double fee, int discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.printf("Fee: Rs.%.2f%n", fee);
        System.out.println("Discount: " + discount + "%");
    }
}

public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        Course[] courses = {
                new Course("Basic Java", 4),
                new OnlineCourse("Java Online", 6, "Coursera", true),
                new PaidOnlineCourse("Advanced Java", 8, "Udemy", true, 2999, 20)
        };

        for (Course course : courses) {
            course.displayDetails();
            System.out.println();
        }
    }
}
