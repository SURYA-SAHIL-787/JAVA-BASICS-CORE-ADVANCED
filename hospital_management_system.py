# FILE NAME: hospital_management_system.py

class Person:
    # BASE CLASS FOR COMMON DETAILS
    def __init__(self, person_id, name, age, gender):
        self.person_id = person_id
        self.name = name
        self.age = age
        self.gender = gender


class Doctor(Person):
    # DOCTOR CLASS INHERITS PERSON
    def __init__(self, person_id, name, age, gender, specialization):
        super().__init__(person_id, name, age, gender)
        self.specialization = specialization
        self.patients = []

    def assign_patient(self, patient):
        self.patients.append(patient)

    def display_doctor(self):
        print(f"DOCTOR ID: {self.person_id}")
        print(f"NAME: {self.name}")
        print(f"AGE: {self.age}")
        print(f"GENDER: {self.gender}")
        print(f"SPECIALIZATION: {self.specialization}")


class Patient(Person):
    # PATIENT CLASS INHERITS PERSON
    def __init__(self, person_id, name, age, gender, disease):
        super().__init__(person_id, name, age, gender)
        self.disease = disease
        self.bill_amount = 0

    def add_bill(self, amount):
        self.bill_amount += amount

    def display_patient(self):
        print(f"PATIENT ID: {self.person_id}")
        print(f"NAME: {self.name}")
        print(f"AGE: {self.age}")
        print(f"GENDER: {self.gender}")
        print(f"DISEASE: {self.disease}")
        print(f"BILL AMOUNT: {self.bill_amount}")


class Appointment:
    # APPOINTMENT CLASS
    def __init__(self, appointment_id, patient, doctor, date):
        self.appointment_id = appointment_id
        self.patient = patient
        self.doctor = doctor
        self.date = date

    def display_appointment(self):
        print(f"APPOINTMENT ID: {self.appointment_id}")
        print(f"PATIENT NAME: {self.patient.name}")
        print(f"DOCTOR NAME: {self.doctor.name}")
        print(f"DATE: {self.date}")


class Hospital:
    # MAIN HOSPITAL MANAGEMENT CLASS
    def __init__(self, name):
        self.name = name
        self.doctors = []
        self.patients = []
        self.appointments = []

    def add_doctor(self, doctor):
        self.doctors.append(doctor)

    def add_patient(self, patient):
        self.patients.append(patient)

    def book_appointment(self, appointment):
        self.appointments.append(appointment)
        appointment.doctor.assign_patient(appointment.patient)

    def display_all_doctors(self):
        print("\nALL DOCTORS")
        for doctor in self.doctors:
            doctor.display_doctor()
            print("-" * 30)

    def display_all_patients(self):
        print("\nALL PATIENTS")
        for patient in self.patients:
            patient.display_patient()
            print("-" * 30)

    def display_all_appointments(self):
        print("\nALL APPOINTMENTS")
        for appointment in self.appointments:
            appointment.display_appointment()
            print("-" * 30)


# MAIN PROGRAM
hospital = Hospital("CITY HOSPITAL")

doctor1 = Doctor(101, "DR. RAJ", 45, "MALE", "CARDIOLOGIST")
doctor2 = Doctor(102, "DR. PRIYA", 38, "FEMALE", "DERMATOLOGIST")

patient1 = Patient(201, "SAHIL", 19, "MALE", "FEVER")
patient2 = Patient(202, "ANU", 20, "FEMALE", "SKIN ALLERGY")

patient1.add_bill(1500)
patient2.add_bill(2200)

appointment1 = Appointment(1, patient1, doctor1, "24-03-2026")
appointment2 = Appointment(2, patient2, doctor2, "25-03-2026")

hospital.add_doctor(doctor1)
hospital.add_doctor(doctor2)

hospital.add_patient(patient1)
hospital.add_patient(patient2)

hospital.book_appointment(appointment1)
hospital.book_appointment(appointment2)

hospital.display_all_doctors()
hospital.display_all_patients()
hospital.display_all_appointments()
