package Services;

import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.Patient.InPatient;
import Entities.Patient.Patient;
import Utilities.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PatientService implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);

    static public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    private static List<Patient> patients = new ArrayList<>();

    public static void addPatients(Patient patient) {
            patients.add(patient);
            System.out.println(Constants.PATIENT_ADDED_SUCCESSFULLY);

    }
    public static Patient addPatient(){
        scanner.nextLine();

        System.out.println("Enter patient id:");
        String id = scanner.nextLine();

        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter gender:");
        String gender = scanner.nextLine();

        System.out.println("Enter phone number:");
        String phone = scanner.nextLine();

        System.out.println("Enter date of birth (yyyy-MM-dd):");
        String DOB = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(DOB);

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter address:");
        String address = scanner.nextLine();

        System.out.println("Enter blood group:");
        String bloodGroup = scanner.nextLine();

        System.out.println("Enter emergency contact:");
        String emergencyContact = scanner.nextLine();

        System.out.println("Enter insurance ID:");
        String insuranceId = scanner.nextLine();

        System.out.println("Do have any allergies? (yes/no)");
        String hasAllergies = scanner.nextLine();

        List<String> allergies = new ArrayList<>();
        if(hasAllergies.equalsIgnoreCase("yes")){
            System.out.println("Enter allergies separated by commas:");
            String allergiesInput = scanner.nextLine();
            allergies.add(Arrays.toString(allergiesInput.split(",")));
        }

        Patient patient= new Patient(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phone,
                email,
                address,
                bloodGroup,
                emergencyContact,
                LocalDate.now(),
                insuranceId,
                allergies
        );

        return patient;

    }
    public void updatePatient(String patientId, Patient updatedPatient){
        for(Patient p : patients){

            if(p.getId().equals(patientId)){
                p.setPhoneNumber(updatedPatient.getPhoneNumber());
                p.setEmail(updatedPatient.getEmail());
                p.setAddress(updatedPatient.getAddress());

                System.out.println(Constants.PATIENT_UPDATED_SUCCESSFULLY);
                return;
            }

        }
        System.out.println(Constants.PATIENT_NOT_FOUND);

    }
    public void removePatient(String patientId){
        for(Patient p : patients){
            if(p.getId().equals(patientId)){
                patients.remove(p);
                System.out.println(Constants.PATIENT_REMOVED_SUCCESSFULLY);
            }
        }
    }
    public void getPatientById(String patientId){
        for(Patient p : patients){
            if(p.getId().equals(patientId)){
                p.displayInfo();
                return;
            }
        }
        System.out.println(Constants.PATIENT_NOT_FOUND);
    }

    public void searchPatientsByName(String name){
        for(Patient p : patients){
            if(p.getFirstName().equalsIgnoreCase(name) || p.getLastName().equalsIgnoreCase(name)){
                p.displayInfo();
            }
        }
    }

    public void displayPatients(){
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
    public void searchPatients(String keyword) {

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

    public void searchPatients(String firstName, String lastName){
        for(Patient p : patients){
            if(p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)){
                p.displayInfo();
                return;
            }
        }
        System.out.println(Constants.PATIENT_NOT_FOUND);

    }

    public static void handlePatientMenu(){
        int option = scanner.nextInt();
        switch (option) {

            case 1 -> {
                //register new Patient
                    addPatients(addPatient());
                    handlePatientMenu();
            }
            case 2 -> {
                //register new InPatient
                InPatient inPatient = (InPatient) addPatient();
                addPatients(inPatient);
                handlePatientMenu();
            }
            case 3 -> {
                return;
            }
        }



    }


    @Override
    public void add(Object entity) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Void getAll() {
        return null;
    }

    @Override
    public void search(String keyword) {

    }

    @Override
    public void searchById(String id) {

    }
}