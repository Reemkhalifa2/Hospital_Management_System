package Services;

import Behaviour.Editable;
import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.MedicalRecord;
import Entities.Patient.EmergencyPatient;
import Entities.Patient.InPatient;
import Entities.Patient.OutPatient;
import Entities.Patient.Patient;

import Utilities.Constants;
import Utilities.HelperUtils;
import Utilities.InputHandler;
import Utilities.MenuMessage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatientService implements Manageable, Searchable, Editable {

    private static List<Patient> patients = new ArrayList<>();

    public static void addPatients(Patient patient) {
        if (HelperUtils.isNull(patient)) { System.out.println("Cannot add null patient."); return; }
        for(Patient p : patients){
            if (p.getId().equals(patient.getId())) {
                System.out.println("Patient with ID " + patient.getId() + " already exists.");
                return;
            }
        }
        patients.add(patient);
        System.out.println(Constants.PATIENT_ADDED_SUCCESSFULLY);
    }

    private static void registerPatient() {

        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");

        LocalDate DOB = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");

        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");
        String address   = InputHandler.getStringInput("Address: ");

        String bloodGroup  = InputHandler.getStringInput("Blood Group: ");
        String emergencyContact     = InputHandler.getStringInput("Emergency Contact: ");
        String insuranceId    = InputHandler.getStringInput("Insurance ID: ");
        Boolean hasAllergies = InputHandler.getConfirmation("Do have any allergies? ");
        List<String> allergies = new ArrayList<>();
        if(hasAllergies){
            String allergiesInput = InputHandler.getStringInput("Enter allergies separated by commas: ");
            allergies.add(Arrays.toString(allergiesInput.split(",")));
        }

        Patient p = new Patient(HelperUtils.generateId("P",4), firstName, lastName, DOB, gender, phone, email,address,
                bloodGroup, emergencyContact,LocalDate.now(),insuranceId,allergies);
        addPatients(p);
    }

    private static void registerInPatient() {
        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");

        LocalDate DOB = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");

        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");
        String address   = InputHandler.getStringInput("Address: ");

        String bloodGroup  = InputHandler.getStringInput("Blood Group: ");
        String emergencyContact     = InputHandler.getStringInput("Emergency Contact: ");
        String insuranceId    = InputHandler.getStringInput("Insurance ID: ");
        Boolean hasAllergies = InputHandler.getConfirmation("Do have any allergies? ");
        List<String> allergies = new ArrayList<>();
        if(hasAllergies){
            System.out.println("Enter allergies separated by commas:");
            String allergiesInput = InputHandler.getStringInput("Enter allergies separated by commas: ");
            allergies.add(Arrays.toString(allergiesInput.split(",")));
        }

        String room   = InputHandler.getStringInput(" Room Number: ");
        String bed    = InputHandler.getStringInput(" Bed Number: ");

        String drId   = InputHandler.getStringInput("Admitting Doctor ID: ");
        double daily  = InputHandler.getDoubleInput("Daily Charges : ");

        InPatient inPatient  = new InPatient(HelperUtils.generateId("InP",4), firstName, lastName, DOB, gender, phone, email, address,
                bloodGroup,emergencyContact,LocalDate.now(),insuranceId,allergies,
                LocalDate.now(),null,room, bed, drId, daily);
        addPatients(inPatient);
    }

    private static void registerOutPatient() {

        String firstName    = InputHandler.getStringInput("First Name: ");
        String lastName    = InputHandler.getStringInput("Last Name: ");

        LocalDate DOB = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");

        String phone  = InputHandler.getStringInput("Phone: ");
        String email  = InputHandler.getStringInput("Email: ");

        String address   = InputHandler.getStringInput("Address: ");
        String bloodGroup  = InputHandler.getStringInput("Blood Group: ");

        String emergencyContact     = InputHandler.getStringInput("Emergency Contact: ");
        String insuranceId    = InputHandler.getStringInput("Insurance ID: ");
        Boolean hasAllergies = InputHandler.getConfirmation("Do have any allergies? ");
        List<String> allergies = new ArrayList<>();
        if(hasAllergies){
            System.out.println("Enter allergies separated by commas:");
            String allergiesInput = InputHandler.getStringInput("Enter allergies separated by commas: ");
            allergies.add(Arrays.toString(allergiesInput.split(",")));
        }
        String prefDr = InputHandler.getStringInput(" Preferred Doctor ID: ");

        OutPatient outPatient = new OutPatient(HelperUtils.generateId("OutP",4), firstName, lastName, DOB, gender, phone, email, address,
                bloodGroup,emergencyContact,LocalDate.now(),insuranceId,allergies,null, null,
                prefDr);
        addPatients(outPatient);
    }

    private static void registerEmergencyPatient() {

        String firstName = InputHandler.getStringInput("First Name: ");
        String lastName = InputHandler.getStringInput("Last Name: ");

        LocalDate DOB = InputHandler.getDateInput("Date of Birth: ");
        String gender = InputHandler.getStringInput("Gender: ");

        String phone = InputHandler.getStringInput("Phone: ");
        String email = InputHandler.getStringInput("Email: ");

        String address = InputHandler.getStringInput("Address: ");
        String bloodGroup = InputHandler.getStringInput("Blood Group: ");

        String emergencyContact = InputHandler.getStringInput("Emergency Contact: ");
        String insuranceId = InputHandler.getStringInput("Insurance ID: ");

        Boolean hasAllergies = InputHandler.getConfirmation("Do you have any allergies? ");
        List<String> allergies = new ArrayList<>();

        if (hasAllergies) {
            System.out.println("Enter allergies separated by commas:");
            String allergiesInput = InputHandler.getStringInput("Enter allergies separated by commas: ");
            allergies = Arrays.asList(allergiesInput.split(","));
        }

        String room = InputHandler.getStringInput("Room Number: ");
        String bed = InputHandler.getStringInput("Bed Number: ");

        String drId = InputHandler.getStringInput("Admitting Doctor ID: ");
        String eType = InputHandler.getStringInput("Emergency Type: ");
        String mode = InputHandler.getStringInput("Arrival Mode: ");
        int triage = InputHandler.getIntInput("Triage Level (1-5): ", 1, 5);

        Boolean admittedViaER = InputHandler.getConfirmation("Admitted via ER? ");

        EmergencyPatient emergencyPatient = new EmergencyPatient(
                HelperUtils.generateId("EmergP",4),
                firstName,
                lastName,
                DOB,
                gender,
                phone,
                email,
                address,
                bloodGroup,
                emergencyContact,
                LocalDate.now(),
                insuranceId,
                allergies,
                LocalDate.now(),
                null,
                room,
                bed,
                drId,
                7.0,
                eType,
                mode,
                triage,
                admittedViaER
        );

        addPatients(emergencyPatient);
    }

    public void addPatient(String firstName, String lastName, String phone){

        Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);

        patients.add(patient);

    }

    public void addPatient(String firstName, String lastName, String phone , String bloodGroup, String email){
        Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patient.setPhoneNumber(bloodGroup);
        patient.setPhoneNumber(email);

        patients.add(patient);

    }


    public static Patient  getPatientById(String patientId){
        for(Patient p : patients){
            if(p.getId().equals(patientId)){
                return p ;
            }
        }

        System.out.println(Constants.PATIENT_NOT_FOUND);
        return null;
    }

    public void searchPatientsByName(String name){
        for(Patient p : patients){
            if(p.getFirstName().equalsIgnoreCase(name) || p.getLastName().equalsIgnoreCase(name)){
                p.displayInfo();
            }
        }
    }
    public void searchPatients(String firstName, String lastName){
        for(Patient p : patients){
            if(p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)){
                p.displayInfo();
                return;
            }
        }
        System.out.println(Constants.PATIENT_NOT_FOUND);

    }

    public static void displayPatients(){
        if (HelperUtils.isNull(patients)) { System.out.println("No patients registered."); return; }
        for(Patient p : patients){
            p.displayInfo();
        }
    }

    public void displayPatients(String filter){
        for(Patient p : patients) {
            System.out.println("Filtered By "+ filter);
            if (p.getInsuranceId().equals(filter)) {
                System.out.println();
            }
            if (p.getBloodGroup().equals(filter)) {
                System.out.println();
            }
            if (p.getGender().equals(filter)) {
                System.out.println();
            }
            if (p.getRegistrationDate().equals(filter)) {
                System.out.println();
            }


        }
    }

    public void displayPatients(int limit){
        while (limit!=0){
            for(Patient p : patients){
                p.displayInfo();
                limit--;
            }
        }
    }


    public void displayPatientHistory(String patientId) {
        Patient p = getPatientById(patientId);
        if (HelperUtils.isNull(p)) { System.out.println(Constants.PATIENT_NOT_FOUND); return; }
        if (p.getMedicalRecords().isEmpty()) {
            System.out.println("No medical records.");
        } else {
            for(MedicalRecord m :p.getMedicalRecords()){
                m.displayInfo();
            }
        }
    }

    public static void updatePatient( Patient updatedPatient){
        updatedPatient.setEmail(InputHandler.getStringInput("Enter new email: "));
        updatedPatient.setPhoneNumber(InputHandler.getStringInput("Enter new phone number: "));
        updatedPatient.setEmergencyContact(InputHandler.getStringInput("Enter Emergency Contact: "));
        updatedPatient.setAddress(InputHandler.getStringInput("Enter new address: "));
        System.out.println(Constants.PATIENT_UPDATED_SUCCESSFULLY);
    }

    private static void updatePatient() {
        String id = InputHandler.getStringInput("Patient ID to update: ");
        Patient existing = getPatientById(id);
        if (HelperUtils.isNull(existing)) { return; }else{
            updatePatient(existing);

        }
    }


    @Override
    public void add(Object entity) {
        Patient patient = (Patient) entity;
        for(Patient p : patients){
            if (p.getId().equals(patient.getId())) {
                return;
            }
        }
        patients.add(patient);

    }
    @Override
    public void remove(String id) {

        Patient p = getPatientById(id);
            if (HelperUtils.isNull(p)) { System.out.println(Constants.PATIENT_NOT_FOUND); return; }
            patients.remove(p);
            System.out.println(Constants.PATIENT_REMOVED_SUCCESSFULLY);


    }
    @Override
    public void getAll() {
        if (!HelperUtils.isNull(patients)) {
            patients.forEach(p -> p.displayInfo());

        }else {
            System.out.println("No patients");
        }
    }
    @Override
    public void search(String keyword) {
        if (HelperUtils.isNull(patients)) {
            System.out.println("No patients registered.");
            return;}
        for (Patient patient : patients) {

            if (patient.getFirstName().equalsIgnoreCase(keyword)
                    || patient.getLastName().equalsIgnoreCase(keyword)
                    || patient.getPhoneNumber().equalsIgnoreCase(keyword)
                    || patient.getBloodGroup().equalsIgnoreCase(keyword)
                    || patient.getEmail().equalsIgnoreCase(keyword)
                    || patient.getId().equalsIgnoreCase(keyword)) {

                patient.displayInfo();
                return;
            }
        }
        System.out.println(Constants.PATIENT_NOT_FOUND);

    }
    @Override
    public void searchById(String id) {
        if (HelperUtils.isNull(patients)) {
            System.out.println("No patients registered.");
            return;}
        for (Patient patient : patients) {

            if (patient.getId().equalsIgnoreCase(id)) {
                patient.displayInfo();
                return;
            }
        }
        System.out.println(Constants.PATIENT_NOT_FOUND);




    }
    @Override
    public void edit(Object updatedData) {


    }

    @Override
    public void validate() {

    }


    public void handlePatientMenu(){
        Boolean patientExit = true;
        while (patientExit) {
            System.out.println(MenuMessage.PatientManagementMenu);
            int option = InputHandler.getIntInput(Constants.ENTER_OPTION,0,9);
            switch (option) {

                case 1 -> {
                    registerPatient();
                }
                case 2 -> {
                    registerInPatient();
                }
                case 3 -> {
                    registerOutPatient();
                }
                case 4->{
                    registerEmergencyPatient();
                }
                case 5->{
                    getAll();
                }
                case 6->{
                    String key = InputHandler.getStringInput("Search keyword: ");
                    search(key);
                }
                case 7->{
                    updatePatient();
                }
                case 8->{
                    String patientId = InputHandler.getStringInput("Enter patient Id: ");
                    remove(patientId);
                }
                case 9->{
                    String patientId = InputHandler.getStringInput("Enter patient Id: ");
                    displayPatientHistory(patientId);
                }
                case 0 ->{
                    patientExit = false;
                }

            }

        }

    }

}