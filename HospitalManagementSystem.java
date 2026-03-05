import java.util.ArrayList;
import java.util.List;

public class HospitalManagementSystem {

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            if (age <= 0) throw new IllegalArgumentException("Age must be positive");
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
    }

    static class Doctor extends Person {
        private String specialization;
        private double fee;

        public Doctor(String name, int age, String specialization, double fee) {
            super(name, age);
            this.specialization = specialization;
            this.fee = fee;
        }

        public String getSpecialization() { return specialization; }
        public double getFee() { return fee; }
    }

    static class Patient extends Person {
        private String illness;

        public Patient(String name, int age, String illness) {
            super(name, age);
            this.illness = illness;
        }

        public String getIllness() { return illness; }
    }

    static class Appointment {
        private Doctor doctor;
        private Patient patient;
        private String date; // simple string for interview style

        public Appointment(Doctor doctor, Patient patient, String date) {
            this.doctor = doctor;
            this.patient = patient;
            this.date = date;
        }

        public double calculateBill() {
            double base = doctor.getFee();
            // If age > 60 -> 10% discount
            if (patient.getAge() > 60) base *= 0.90;
            return base;
        }

        public void printAppointment() {
            System.out.println("\nAppointment Date: " + date);
            System.out.println("Doctor: " + doctor.getName() + " (" + doctor.getSpecialization() + ")");
            System.out.println("Patient: " + patient.getName() + " | Illness: " + patient.getIllness());
            System.out.println("Consultation Fee: ₹" + calculateBill());
        }
    }

    public static void main(String[] args) {
        Doctor d1 = new Doctor("Dr. Kumar", 45, "Cardiologist", 800);
        Doctor d2 = new Doctor("Dr. Priya", 38, "Dermatologist", 600);

        Patient p1 = new Patient("Sahil", 19, "Fever");
        Patient p2 = new Patient("Ramesh", 65, "Heart Pain");

        List<Appointment> appts = new ArrayList<>();
        appts.add(new Appointment(d2, p1, "2026-03-06"));
        appts.add(new Appointment(d1, p2, "2026-03-07"));

        for (Appointment a : appts) {
            a.printAppointment();
        }
    }
}
