import java.util.Arrays;

public class ExamResultProcessingSystem {

    static class Student {
        protected String name;
        protected int[] marks;

        public Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        public double percentage() {
            int sum = 0;
            for (int m : marks) {
                if (m < 0 || m > 100) throw new IllegalArgumentException("Invalid marks");
                sum += m;
            }
            return (sum / (double)(marks.length * 100)) * 100;
        }

        public String grade() {
            double p = percentage();
            if (p >= 90) return "A+";
            if (p >= 80) return "A";
            if (p >= 70) return "B";
            if (p >= 60) return "C";
            return "F";
        }

        public boolean isPass() {
            for (int m : marks) if (m < 35) return false;
            return true;
        }

        public void printResult() {
            System.out.println("\nName: " + name);
            System.out.println("Marks: " + Arrays.toString(marks));
            System.out.println("Percentage: " + percentage());
            System.out.println("Grade: " + grade());
            System.out.println("Pass: " + isPass());
        }
    }

    static class SchoolStudent extends Student {
        public SchoolStudent(String name, int[] marks) {
            super(name, marks);
        }

        @Override
        public String grade() {
            double p = percentage();
            if (p >= 95) return "A+";
            if (p >= 85) return "A";
            if (p >= 75) return "B";
            if (p >= 60) return "C";
            return "F";
        }
    }

    static class CollegeStudent extends Student {
        public CollegeStudent(String name, int[] marks) {
            super(name, marks);
        }

        @Override
        public boolean isPass() {
            // College: must score 40+ in each subject
            for (int m : marks) if (m < 40) return false;
            return true;
        }
    }

    public static void main(String[] args) {
        Student s1 = new SchoolStudent("Sahil", new int[]{95, 89, 92, 78, 88});
        Student s2 = new CollegeStudent("Ravi", new int[]{70, 42, 39, 60, 80});

        s1.printResult();
        s2.printResult();
    }
}
