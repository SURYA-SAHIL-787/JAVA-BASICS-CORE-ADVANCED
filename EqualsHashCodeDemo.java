class Student {
    private int id;
    private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Student other = (Student) obj;
        return this.id == other.id && this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return id * 31 + name.hashCode();
    }
}

public class EqualsHashCodeDemo {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Sahil");
        Student s2 = new Student(1, "Sahil");
        Student s3 = new Student(2, "Rahul");

        System.out.println(s1);
        System.out.println("s1 equals s2: " + s1.equals(s2));
        System.out.println("s1 hashCode: " + s1.hashCode());
        System.out.println("s2 hashCode: " + s2.hashCode());
        System.out.println("s1 equals s3: " + s1.equals(s3));
    }
}
