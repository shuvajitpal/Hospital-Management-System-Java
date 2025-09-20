package com.PWskills.Project;

import java.util.ArrayList;
import java.util.Scanner;

class Patient{
   private static int idCounter=1;
   private int id;
   private String name;
   private String gender;
   private int age;
   public Patient(String name,String gender,int age){
      this.id=idCounter++;
      this.name=name;
      this.gender=gender;
      this.age=age;
   }
   public int getId(){
      return id;
   }
   @Override
   public String toString(){
      return "\n  Patient ID: "+id+", Name: "+name+", Gender: "+gender+", Age: "+age;
   }
}
class Doctor{
   private static int idCounter=1;
   private int id;
   private String name;
   private String speciality;
   public Doctor(String name,String speciality){
      this.id=idCounter++;
      this.name=name;
      this.speciality=speciality;
   }
   public int getId(){
      return id;
   }
   @Override
   public String toString(){
      return "\n  Doctor ID: "+id+", Name: "+name+", Speciality: "+speciality;
   }
}
class Appointment{
   private Patient patient;
   private Doctor doctor;
   private String date;
   public Appointment(Patient patient,Doctor doctor,String date){
      this.patient=patient;
      this.doctor=doctor;
      this.date=date;
   }
   public String toString(){
      return "Appointment:\n Patient: "+patient+".\n Doctor: "+doctor+".\n Date: "+date;
   }
}
public class HospitalManagement {
   private static ArrayList<Patient> patients = new ArrayList<>();
   private static ArrayList<Doctor> doctors = new ArrayList<>();
   private static ArrayList<Appointment> appointments = new ArrayList<>();
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int choice;
      do {
         System.out.println("Hospital Management System");
         System.out.println("1. Add Patient");
         System.out.println("2. Add Doctor");
         System.out.println("3. Schedule Appointment");
         System.out.println("4. View Patient");
         System.out.println("5. View Doctor");
         System.out.println("6. View Appointment");
         System.out.println("0. Exit");
         System.out.println("Enter Your Choice: ");
         choice = sc.nextInt();
         switch (choice){
            case 1:
               addPatient(sc);
               break;
            case 2:
               addDoctor(sc);
               break;
            case 3:
               scheduleAppointment(sc);
               break;
            case 4:
               viewPatients();
               break;
            case 5:
               viewDoctors();
               break;
            case 6:
               viewAppointmnets();
               break;
            case 0:
               System.out.println("Exiting...");
               break;
            default:
               System.out.println("Invalid Choice. Please Try Again.");
         }
      }while (choice!=0);
   }
   private static void addPatient(Scanner sc){
      System.out.print("Enter Patient Name: ");
      String name = sc.next();
      System.out.print("Enter Patient Age: ");
      int age = sc.nextInt();
      System.out.print("Enter Patient Gender: ");
      String gender = sc.next();
      Patient patient = new Patient(name,gender, age);
      patients.add(patient);
      System.out.println("Patient added successfully");
   }
   private static void addDoctor(Scanner sc) {
      System.out.print("Enter Doctor Name: ");
      String name = sc.next();
      System.out.print("Enter Speciality Name: ");
      String speciality = sc.next();
      Doctor doctor = new Doctor(name, speciality);
      doctors.add(doctor);
      System.out.println("Doctor added successfully");
   }
   private static void scheduleAppointment(Scanner sc) {
      System.out.print("Enter Patient ID: ");
      int patientId = sc.nextInt();
      System.out.print("Enter Doctr ID: ");
      int doctorId = sc.nextInt();
      System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
      String date = sc.next();
      Patient patient = findPatientById(patientId);
      Doctor doctor = findDoctorById(doctorId);
      if (patient != null && doctor != null) {
         Appointment appointment = new Appointment(patient, doctor, date);
         appointments.add(appointment);
         System.out.println("Appoint Scheduled Successfully.");
      }else System.out.println("Invalid Patient ID or Doctor ID.");
   }
   private static void viewPatients() {
      System.out.println("List of Patients: ");
      for (Patient patient : patients)
         System.out.println(patient);
   }
   private static void viewDoctors() {
      System.out.println("List of Doctors: ");
      for (Doctor doctor : doctors)
         System.out.println(doctor);
   }
   private static void viewAppointmnets() {
      System.out.println("List of Appointments: ");
      for (Appointment appointment : appointments)
         System.out.println(appointment);
   }
   private static Patient findPatientById(int id) {
      for (Patient patient: patients)
         if (patient.getId()==id) return patient;
      return null;
   }
   private static Doctor findDoctorById(int id) {
      for (Doctor doctor: doctors)
         if (doctor.getId()==id) return doctor;
      return null;
   }
}