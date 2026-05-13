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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DoctorService implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    private List<Doctor> doctors = new ArrayList<>();


    public void addDoctor(Doctor doctor) {
        if (HelperUtils.isNull(doctor)) { System.out.println("  [!] Cannot add null doctor."); return; }
        if (HelperUtils.isNotNull(getDoctorById(doctor.getId()))){
            System.out.println("Doctor with ID " + doctor.getId() + " already exists."); return;
            }
        doctors.add(doctor);
        System.out.println(Constants.DOCTOR_ADDED_SUCCESSFULLY);

    }

    private void addDoctor() {

        String id    = HelperUtils.generateId("DOC-",4);
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
        Doctor d = new Doctor(id, firstName, lastName, dob, gender, phone, email, address,
                specialization, qualification, experience, deptId, fee);
        add(d);
    }
    private void addSurgeon() {
        String id    = HelperUtils.generateId("Surg-",4);
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
        Surgeon s = new Surgeon(id, firstName, lastName, dob, gender, phone, email, address,
                specialization, qualification, experience, deptId, fee, null, operationTheatreAccess);
        add(s);
    }
    private void addConsultant() {
        String id    = HelperUtils.generateId("Cons-",4);
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
        Consultant c = new Consultant(id, firstName, lastName, dob, gender, phone, email, address,
                specialization, qualification, experience, deptId, fee, new ArrayList<>(), online, dur);
        add(c);
    }
    private void addGeneralPractitioner() {
        String id    = HelperUtils.generateId("GP-",4);
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
        GeneralPractitioner gp = new GeneralPractitioner(id, firstName, lastName, dob, gender, phone, email, address,
                specialization, qualification, experience, deptId, fee, walkin, home, vacc);
        add(gp);
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


    public void editDoctor(String doctorId, Doctor updatedDoctor){
        for(Doctor d : doctors){
            if(d.getId().equals(doctorId)){
                d.setPhoneNumber(updatedDoctor.getPhoneNumber());
                d.setEmail(updatedDoctor.getEmail());
                d.setAddress(updatedDoctor.getAddress());

                System.out.println(Constants.DOCTOR_UPDATED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.DOCTOR_NOT_FOUND);
    }

    public void removeDoctor(String doctorId){
        for(Doctor d : doctors) {
            if (d.getId().equals(doctorId)) {
                doctors.remove(d);
                System.out.println(Constants.DOCTOR_REMOVED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.DOCTOR_NOT_FOUND);
    }

    public Doctor  getDoctorById(String doctorId){
        Doctor doctor = new Doctor();
        for(Doctor d : doctors){
            if(d.getId().equals(doctorId)){
                doctor =  d;
            }else{
                System.out.println(Constants.DOCTOR_NOT_FOUND);
                break;

            }
        }
        return doctor;

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
        if (HelperUtils.isNull(d)) { System.out.println(Constants.DOCTOR_NOT_FOUND); return; }
        d.assignPatient(patientId);
        System.out.println("  [✓] Patient " + patientId + " assigned to Dr. " + d.getFullName());
    }



    public void  assignPatient(Doctor doctor, Patient patient){
        doctor.getAssignedPatients().add(patient);
    }

    public void  assignPatient(String doctorId, List<String> patientIds) {
        for (Doctor doctor : doctors){
            if(doctor.getId().equals(doctorId)){
                for(Patient p : getPatients()){
                    for(String x : patientIds){
                        if(p.getId().equals(x)){
                            doctor.getAssignedPatients().add(p);
                            System.out.println(Constants.PATIENT_ASSIGNED_SUCCESSFULLY);
                        }else{
                            System.out.println(Constants.PATIENT_NOT_FOUND);
                        }

                    }

                }

            }else{
                System.out.println(Constants.DOCTOR_NOT_FOUND);
            }


        }

    }


    @Override
    public void add(Object entity) {
        Doctor doctor = (Doctor) entity;
        addDoctor(doctor);
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Void getAll() {
        return null ;
    }

    @Override
    public void search(String keyword) {



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
            System.out.println(MenuMessage.PatientManagementMenu);
            int option = InputHandler.getIntInput(Constants.ENTER_OPTION,0,9);
            switch (option) {




                case 0 ->{
                    doctorMenu = false;
                }

            }

        }

    }



}
