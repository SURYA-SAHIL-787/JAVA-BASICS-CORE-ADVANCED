import java.util.*;

final class Student {
    private final String name;
    private final List<Integer> marks;

    Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = new ArrayList<>(marks); // defensive copy
    }
    String getName(){ return name; }
    List<Integer> getMarks(){ return Collections.unmodifiableList(marks); }

    public static void main(String[] args) {
        List<Integer> m = new ArrayList<>(List.of(90, 80));
        Student s = new Student("Sahil", m);
        m.add(0); // does NOT affect s
        System.out.println(s.getMarks());
        // s.getMarks().add(100); // throws exception
    }
}
