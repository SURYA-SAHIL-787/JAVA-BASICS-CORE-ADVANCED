import java.util.*;

// Interface
interface Prioritizable {
    int getPriority();
}

// Abstract parent class
abstract class Person {
    private String name;
    private int age;
    private String id;
    private String phone;

    public Person(String name, int age, String id, String phone) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public abstract void showRole();
}

// Doctor class
class Doctor extends Person {
    private String specialization;

    public Doctor(String name, int age, String id, String phone, String specialization) {
        super(name, age, id, phone);
        this.specialization = specialization;
    }

    public void diagnose(Patient patient) {
        System.out.println("Doctor " + getName() + " is diagnosing patient " + patient.getName());
    }

    @Override
    public void showRole() {
        System.out.println("Role: Doctor | Specialization: " + specialization);
    }
}

// Nurse class
class Nurse extends Person {
    public Nurse(String name, int age, String id, String phone) {
        super(name, age, id, phone);
    }

    public void updateCareNotes(MedicalRecord record, String note) {
        record.addCareNote(note);
    }

    @Override
    public void showRole() {
        System.out.println("Role: Nurse");
    }
}

// Patient class
class Patient extends Person implements Prioritizable {
    private boolean emergency;
    private MedicalRecord medicalRecord;

    public Patient(String name, int age, String id, String phone, boolean emergency) {
        super(name, age, id, phone);
        this.emergency = emergency;
        this.medicalRecord = new MedicalRecord();
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void bookAppointment(Doctor doctor, String date) {
        Appointment appointment = new Appointment(this, doctor, date);
        appointment.showAppointment();
    }

    @Override
    public int getPriority() {
        return emergency ? 1 : 2;
    }

    @Override
    public void showRole() {
        System.out.println("Role: Patient | Emergency: " + emergency);
    }
}

// Encapsulation
class MedicalRecord {
    private List<String> diseaseHistory = new ArrayList<>();
    private List<String> careNotes = new ArrayList<>();

    public void addDisease(String disease) {
        diseaseHistory.add(disease);
    }

    public void addCareNote(String note) {
        careNotes.add(note);
    }

    public void displayRecord() {
        System.out.println("Disease History: " + diseaseHistory);
        System.out.println("Care Notes: " + careNotes);
    }
}

// HAS-A relation
class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public void showAppointment() {
        System.out.println("Appointment booked: " + patient.getName() +
                " with Dr. " + doctor.getName() + " on " + date);
    }
}

// Abstract billing
abstract class Bill {
    protected double amount;

    public Bill(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalBill();
}

class ConsultationBill extends Bill {
    public ConsultationBill(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalBill() {
        return amount;
    }
}

class SurgeryBill extends Bill {
    public SurgeryBill(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalBill() {
        return amount + (amount * 0.20);
    }
}

class RoomChargeBill extends Bill {
    private int days;

    public RoomChargeBill(double amountPerDay, int days) {
        super(amountPerDay);
        this.days = days;
    }

    @Override
    public double calculateFinalBill() {
        return amount * days;
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("Arun", 45, "D101", "9999999999", "Cardiology");
        Nurse n1 = new Nurse("Meena", 30, "N201", "8888888888");
        Patient p1 = new Patient("Rahul", 25, "P301", "7777777777", true);

        p1.getMedicalRecord().addDisease("Fever");
        p1.getMedicalRecord().addDisease("Chest Pain");

        d1.showRole();
        n1.showRole();
        p1.showRole();

        p1.bookAppointment(d1, "15-03-2026");
        d1.diagnose(p1);

        n1.updateCareNotes(p1.getMedicalRecord(), "Patient under observation");
        p1.getMedicalRecord().displayRecord();

        Bill b1 = new ConsultationBill(500);
        Bill b2 = new SurgeryBill(10000);
        Bill b3 = new RoomChargeBill(2000, 3);

        System.out.println("Consultation Bill: " + b1.calculateFinalBill());
        System.out.println("Surgery Bill: " + b2.calculateFinalBill());
        System.out.println("Room Charge Bill: " + b3.calculateFinalBill());

        System.out.println("Patient Priority: " + p1.getPriority());
    }
}
