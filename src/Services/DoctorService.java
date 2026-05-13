package Services;

import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.Doctor.Consultant;
import Entities.Doctor.Doctor;
import Entities.Doctor.GeneralPractitioner;
import Entities.Doctor.Surgeon;
import Entities.Patient.Patient;
import Utilities.Constants;
import Utilities.HelperUtils;
import Utilities.InputHandler;
import Utilities.MenuMessage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService implements Manageable, Searchable , Editable {
    private static List<Doctor> doctors = new ArrayList<>();
    public static void addDoctor(Doctor doctor) {
        if (HelperUtils.isNull(doctor)) { System.out.println("Cannot add null doctor."); return; }
        for(Doctor d : doctors){
            if (d.getId().equals(doctor.getId())) {
                System.out.println("Patient with ID " + doctor.getId() + " already exists.");
                return;
            }
        }
        doctors.add(doctor);
        System.out.println(Constants.DOCTOR_ADDED_SUCCESSFULLY);

    }

    private void addDoctor() {

        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");

        LocalDate dob = InputHandler.getDateInput("Date of Birth");
        String gender = InputHandler.getStringInput("Gender: ");

        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");
        String address  = InputHandler.getStringInput("Address: ");

        String specialization   = InputHandler.getStringInput("Specialization: ");
        String qualification   = InputHandler.getStringInput("Qualification: ");
        int    experience    = InputHandler.getIntInput("Experience (years): ", 0, 60);
        String deptId   = InputHandler.getStringInput("Department ID: ");
        double fee    = InputHandler.getDoubleInput("Consultation Fee: ");

        Doctor d = new Doctor(HelperUtils.generateId("DOC-",4), firstName, lastName, dob, gender, phone, email, address,
                specialization, qualification, experience, deptId, fee);
        addDoctor(d);
    }
    private void addSurgeon() {

        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");

        LocalDate dob = InputHandler.getDateInput("Date of Birth");
        String gender = InputHandler.getStringInput("Gender: ");

        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");
        String address  = InputHandler.getStringInput("Address: ");

        String specialization   = InputHandler.getStringInput("Specialization: ");
        String qualification   = InputHandler.getStringInput("Qualification: ");
        int    experience    = InputHandler.getIntInput("Experience (years): ", 0, 60);
        String deptId   = InputHandler.getStringInput("Department ID: ");
        double fee    = InputHandler.getDoubleInput("Consultation Fee: ");
        boolean  operationTheatreAccess   = InputHandler.getConfirmation("Operation Theatre Access ?");

        Surgeon s = new Surgeon(HelperUtils.generateId("Surg-",4), firstName, lastName, dob, gender, phone, email, address,
                specialization, qualification, experience, deptId, fee, null, operationTheatreAccess);
        add(s);
    }
    private void addConsultant() {
        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");

        LocalDate dob = InputHandler.getDateInput("Date of Birth");
        String gender = InputHandler.getStringInput("Gender: ");

        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");
        String address  = InputHandler.getStringInput("Address: ");

        String specialization   = InputHandler.getStringInput("Specialization: ");
        String qualification   = InputHandler.getStringInput("Qualification: ");
        int    experience    = InputHandler.getIntInput("Experience (years): ", 0, 60);
        String deptId   = InputHandler.getStringInput("Department ID: ");
        double fee    = InputHandler.getDoubleInput("Consultation Fee: ");
        boolean online = InputHandler.getConfirmation(" Online consultations?");
        int dur        = InputHandler.getIntInput(" Duration (minutes): ", 15, 120);

        Consultant c = new Consultant(HelperUtils.generateId("Cons-",4), firstName, lastName, dob, gender, phone, email, address,
                specialization, qualification, experience, deptId, fee, new ArrayList<>(), online, dur);
        addDoctor(c);
    }

    private void addGeneralPractitioner() {
        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");

        LocalDate dob = InputHandler.getDateInput("Date of Birth");
        String gender = InputHandler.getStringInput("Gender: ");

        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");
        String address  = InputHandler.getStringInput("Address: ");

        String specialization   = InputHandler.getStringInput("Specialization: ");
        String qualification   = InputHandler.getStringInput("Qualification: ");

        int    experience    = InputHandler.getIntInput("Experience (years): ", 0, 60);
        String deptId   = InputHandler.getStringInput("Department ID: ");
        double fee    = InputHandler.getDoubleInput("Consultation Fee: ");
        boolean walkin = InputHandler.getConfirmation("Walk-in available?");
        boolean home   = InputHandler.getConfirmation("Home visits available?");
        boolean vacc   = InputHandler.getConfirmation("Vaccination certified?");

        GeneralPractitioner gp = new GeneralPractitioner(HelperUtils.generateId("GP-",4), firstName, lastName, dob, gender, phone, email, address,
                specialization, qualification, experience, deptId, fee, walkin, home, vacc);
        addDoctor(gp);
    }

    public void addDoctor(String name, String specialization, String phone){
        Doctor doctor = new Doctor();
        doctor.setId(HelperUtils.generateId("DOC",4));
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);

        doctors.add(doctor);
    }

    public void addDoctor(String name, String specialization, String phone, double consultationFee){
        Doctor doctor = new Doctor();
        doctor.setId(HelperUtils.generateId("DOC",4));
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);
        doctor.setConsultationFee(consultationFee);

        doctors.add(doctor);
    }
    public static void updateDoctor(Doctor doctor) {

        doctor.setQualification(
                InputHandler.getStringInput("Enter qualification: ")
        );

        doctor.setExperienceYears(
                InputHandler.getIntInput("Enter years of experience: ")
        );

        System.out.println(Constants.DOCTOR_UPDATED_SUCCESSFULLY);
    }


    public static void updateDoctor() {
        String id = InputHandler.getStringInput("Doctor ID to update: ");
        Doctor existingDoctor = getDoctorById(id);
        if (HelperUtils.isNull(existingDoctor)) {
            return;
        }
        updateDoctor(existingDoctor);
    }


    public void removeDoctor(String doctorId){
        Doctor doctor = getDoctorById(doctorId);
        if(HelperUtils.isNotNull(doctor)){
                doctors.remove(doctor);
                System.out.println(Constants.DOCTOR_REMOVED_SUCCESSFULLY);
                return;
            }

        System.out.println(Constants.DOCTOR_NOT_FOUND);
    }

    public static Doctor getDoctorById(String doctorId) {
        for (Doctor d : doctors) {
            if (d.getId().equals(doctorId)) {
                return d;
            }
        }
        System.out.println(Constants.DOCTOR_NOT_FOUND);
        return null;
    }

    public void displayDoctors(){
        for(Doctor d : doctors){
            d.displayInfo();
        }
    }

    public void displayDoctors(String specialization){
        for(Doctor d : doctors){
            if(d.getSpecialization().equalsIgnoreCase(specialization)){
                d.displayInfo();
            }
        }
    }
    public void displayDoctors(String departmentId, boolean showAvailableOnly) {
        for(Doctor d : doctors){
            if(d.getDepartmentId().equalsIgnoreCase(departmentId) && !d.getAvailableSlots().isEmpty()){
                d.displayInfo();
            }
        }
    }

    public void getAvailableDoctors(){
        for(Doctor d : doctors){
            if(!d.getAvailableSlots().isEmpty()){
                d.displayInfo();
            }
        }
    }

    public void assignPatient(String doctorId, String patientId) {
        Doctor d = getDoctorById(doctorId);
        if (HelperUtils.isNull(d)) { return; }
        d.assignPatient(patientId);
        System.out.println(Constants.PATIENT_ASSIGNED_SUCCESSFULLY);
    }



    public void  assignPatient(Doctor doctor, Patient patient){
        if (HelperUtils.isNull(doctor) || HelperUtils.isNull(patient)) return;
        doctor.assignPatient(patient.getId());
        System.out.println(Constants.PATIENT_ASSIGNED_SUCCESSFULLY);
    }

    public void assignPatient(String doctorId, List<String> patientIds) {
        Doctor d = getDoctorById(doctorId);
        if (HelperUtils.isNull(d)) { System.out.println(Constants.DOCTOR_NOT_FOUND); return; }
        if (HelperUtils.isNull(patientIds)) return;
        //d.assignPatient(patientId)
        patientIds.forEach(d::assignPatient);
        System.out.println(Constants.PATIENT_ASSIGNED_SUCCESSFULLY);
    }



    @Override
    public void add(Object entity) {
        Doctor doctor = (Doctor) entity;
        for(Doctor d : doctors){
            if (d.getId().equals(doctor.getId())) {
                return;
            }
        }
        doctors.add(doctor);

    }

    @Override
    public void remove(String id) {
        Doctor doctor = getDoctorById(id);
        if (HelperUtils.isNull(doctor)) { System.out.println(Constants.DOCTOR_NOT_FOUND); return; }
        doctors.remove(doctor);
        System.out.println(Constants.DOCTOR_REMOVED_SUCCESSFULLY);
    }

    @Override
    public void getAll() {
        doctors.forEach(d -> d.displayInfo());
    }

    @Override
    public void search(String keyword) {

        boolean found = false;

        for(Doctor d : doctors){

            if(

                    d.getId().equalsIgnoreCase(keyword) ||
                            d.getFirstName().equalsIgnoreCase(keyword) ||
                            d.getLastName().equalsIgnoreCase(keyword) ||
                            d.getGender().equalsIgnoreCase(keyword) ||
                            d.getPhoneNumber().equalsIgnoreCase(keyword) ||
                            d.getEmail().equalsIgnoreCase(keyword) ||
                            d.getAddress().equalsIgnoreCase(keyword) ||
                            d.getSpecialization().equalsIgnoreCase(keyword) ||
                            d.getQualification().equalsIgnoreCase(keyword) ||
                            d.getDepartmentId().equalsIgnoreCase(keyword) ||
                            d.getDateOfBirth().toString().equalsIgnoreCase(keyword) ||
                            String.valueOf(d.getExperienceYears()).equals(keyword) ||
                            String.valueOf(d.getConsultationFee()).equals(keyword)

            ){

                d.displayInfo();
                found = true;
            }
        }

        if(!found){
            System.out.println(Constants.DOCTOR_NOT_FOUND);
        }
    }

    @Override
    public void searchById(String id) {
        for(Doctor doctor : doctors){
            if(doctor.getId().equals(id)){
                doctor.displayInfo();
            }
        }

    }

    public void handleDoctorMenu(){
        Boolean doctorMenu = true;
        while (doctorMenu) {
            System.out.println(MenuMessage.DoctorManagementMenu);
            int option = InputHandler.getIntInput(Constants.ENTER_OPTION,0,10);
            switch (option) {
                case 1-> addDoctor();
                case 2-> addSurgeon();
                case 3-> addConsultant();
                case 4-> addGeneralPractitioner();
                case 5->displayDoctors();
                case 6 ->{
                    String spe = InputHandler.getStringInput("Search Specialization: ");
                    displayDoctors(spe);
                }
                case 7->getAvailableDoctors();
                case 8-> {
                    String doctorId = InputHandler.getStringInput("Doctor ID: ");
                    String patientId = InputHandler.getStringInput("Patient ID: ");
                    assignPatient(doctorId,patientId);
                }
                case 9-> {
                    updateDoctor();
                }
                case 10->{
                    String doctorId = InputHandler.getStringInput("Doctor ID: ");
                    removeDoctor(doctorId);
                }

                case 0 ->{
                    doctorMenu = false;
                }

            }

        }

    }
}
