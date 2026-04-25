import java.io.*;
import java.util.*;

class Student {
    int roll;
    String name;
    int marks;

    Student(int roll, String name, int marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return roll + "," + name + "," + marks;
    }
}

public class StudentRecordManager {
    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent(sc);
                    break;

                case 4:
                    updateMarks(sc);
                    break;

                case 5:
                    deleteStudent(sc);
                    break;

                case 6:
                    System.out.println("Program ended.");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void addStudent(Scanner sc) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME, true);

            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            int marks = sc.nextInt();

            Student s = new Student(roll, name, marks);

            fw.write(s + "\n");
            fw.close();

            System.out.println("Student added successfully.");

        } catch (IOException e) {
            System.out.println("Error adding student.");
        }
    }

    static void displayStudents() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");

                System.out.println("Roll: " + data[0]);
                System.out.println("Name: " + data[1]);
                System.out.println("Marks: " + data[2]);
                System.out.println("------------------");
            }

            br.close();

        } catch (IOException e) {
            System.out.println("No records found.");
        }
    }

    static void searchStudent(Scanner sc) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            System.out.print("Enter roll number to search: ");
            int roll = sc.nextInt();

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");

                if (Integer.parseInt(data[0]) == roll) {
                    System.out.println("Student Found");
                    System.out.println("Roll: " + data[0]);
                    System.out.println("Name: " + data[1]);
                    System.out.println("Marks: " + data[2]);
                    found = true;
                    break;
                }
            }

            br.close();

            if (!found) {
                System.out.println("Student not found.");
            }

        } catch (IOException e) {
            System.out.println("File error.");
        }
    }

    static void updateMarks(Scanner sc) {
        ArrayList<String> records = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            System.out.print("Enter roll number to update: ");
            int roll = sc.nextInt();

            System.out.print("Enter new marks: ");
            int newMarks = sc.nextInt();

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");

                if (Integer.parseInt(data[0]) == roll) {
                    records.add(data[0] + "," + data[1] + "," + newMarks);
                    found = true;
                } else {
                    records.add(line);
                }
            }

            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));

            for (String record : records) {
                bw.write(record + "\n");
            }

            bw.close();

            if (found) {
                System.out.println("Marks updated.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (IOException e) {
            System.out.println("Update error.");
        }
    }

    static void deleteStudent(Scanner sc) {
        ArrayList<String> records = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            System.out.print("Enter roll number to delete: ");
            int roll = sc.nextInt();

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");

                if (Integer.parseInt(data[0]) == roll) {
                    found = true;
                } else {
                    records.add(line);
                }
            }

            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));

            for (String record : records) {
                bw.write(record + "\n");
            }

            bw.close();

            if (found) {
                System.out.println("Student deleted.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (IOException e) {
            System.out.println("Delete error.");
        }
    }
}
