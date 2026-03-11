import java.util.*;

abstract class PlatformUser {
    private String name;
    private String userId;

    public PlatformUser(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public abstract void showRole();
}

class Student extends PlatformUser {
    private Map<String, Integer> progress = new HashMap<>();

    public Student(String name, String userId) {
        super(name, userId);
    }

    public void updateProgress(String courseName, int percent) {
        if (percent >= 0 && percent <= 100) {
            progress.put(courseName, percent);
        }
    }

    public int getProgress(String courseName) {
        return progress.getOrDefault(courseName, 0);
    }

    @Override
    public void showRole() {
        System.out.println("Student");
    }
}

class Instructor extends PlatformUser {
    public Instructor(String name, String userId) {
        super(name, userId);
    }

    @Override
    public void showRole() {
        System.out.println("Instructor");
    }
}

class Admin extends PlatformUser {
    public Admin(String name, String userId) {
        super(name, userId);
    }

    @Override
    public void showRole() {
        System.out.println("Admin");
    }
}

interface Certifiable {
    boolean isEligibleForCertificate(Student student);
}

interface Payable {
    double calculateFee();
}

interface Gradable {
    int evaluateQuiz(int marks);
}

abstract class Course implements Certifiable, Payable {
    protected String courseName;
    protected Instructor instructor;
    protected int quizThreshold;

    public Course(String courseName, Instructor instructor, int quizThreshold) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.quizThreshold = quizThreshold;
    }

    public String getCourseName() {
        return courseName;
    }

    public abstract void showCourseType();
}

class FreeCourse extends Course {
    public FreeCourse(String courseName, Instructor instructor, int quizThreshold) {
        super(courseName, instructor, quizThreshold);
    }

    @Override
    public double calculateFee() {
        return 0;
    }

    @Override
    public boolean isEligibleForCertificate(Student student) {
        return student.getProgress(courseName) == 100;
    }

    @Override
    public void showCourseType() {
        System.out.println("Free Course");
    }
}

class PaidCourse extends Course {
    private double fee;

    public PaidCourse(String courseName, Instructor instructor, int quizThreshold, double fee) {
        super(courseName, instructor, quizThreshold);
        this.fee = fee;
    }

    @Override
    public double calculateFee() {
        return fee;
    }

    @Override
    public boolean isEligibleForCertificate(Student student) {
        return student.getProgress(courseName) == 100;
    }

    @Override
    public void showCourseType() {
        System.out.println("Paid Course");
    }
}

class SubscriptionCourse extends Course {
    private double monthlyFee;

    public SubscriptionCourse(String courseName, Instructor instructor, int quizThreshold, double monthlyFee) {
        super(courseName, instructor, quizThreshold);
        this.monthlyFee = monthlyFee;
    }

    @Override
    public double calculateFee() {
        return monthlyFee;
    }

    @Override
    public boolean isEligibleForCertificate(Student student) {
        return student.getProgress(courseName) == 100;
    }

    @Override
    public void showCourseType() {
        System.out.println("Subscription Course");
    }
}

class Quiz implements Gradable {
    private String title;

    public Quiz(String title) {
        this.title = title;
    }

    @Override
    public int evaluateQuiz(int marks) {
        return marks;
    }
}

class Certificate {
    public void generateCertificate(Student student, Course course) {
        if (course.isEligibleForCertificate(student)) {
            System.out.println("Certificate generated for " + student.getName()
                    + " in " + course.getCourseName());
        } else {
            System.out.println("Certificate cannot be generated.");
        }
    }
}

public class OnlineLearningPlatform {
    public static void main(String[] args) {
        Instructor instructor = new Instructor("Ravi", "I101");
        Student student = new Student("Sahil", "S201");

        Course c1 = new PaidCourse("Java Advanced", instructor, 50, 2500);
        c1.showCourseType();
        System.out.println("Course Fee: Rs." + c1.calculateFee());

        student.updateProgress("Java Advanced", 100);

        Quiz quiz = new Quiz("OOP Quiz");
        int score = quiz.evaluateQuiz(85);
        System.out.println("Quiz Score: " + score);

        Certificate certificate = new Certificate();
        certificate.generateCertificate(student, c1);
    }
}
