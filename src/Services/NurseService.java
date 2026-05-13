package Services;

import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.Doctor.Doctor;
import Entities.Nurse;
import Entities.Patient.Patient;
import Utilities.Constants;
import Utilities.HelperUtils;
import Utilities.InputHandler;
import Utilities.MenuMessage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseService implements Manageable, Searchable {
    private static List <Nurse> nurses = new ArrayList<>();

    public void addNurse(Nurse nurse){
        nurses.add(nurse);
        System.out.println(Constants.NURSE_ADDED_SUCCESSFULLY);
    }

    public void addNurses(){

        String firstName = InputHandler.getStringInput("Enter first name: ");

        String lastName = InputHandler.getStringInput("Enter last name:");

        String gender =  InputHandler.getStringInput("Enter gender: ");

        String phone = InputHandler.getStringInput("Enter phone number: ");

        LocalDate dateOfBirth = InputHandler.getDateInput("Enter date of birth (yyyy-MM-dd):");

        String email = InputHandler.getStringInput("Enter email:");

        String address = InputHandler.getStringInput("Enter address: ");

        String departmentId = InputHandler.getStringInput("Enter department id: ");

        String shift = InputHandler.getStringInput("Enter shift: ");

        String qualification = InputHandler.getStringInput("Enter qualification: ");


        Nurse nurse = new Nurse(
                HelperUtils.generateId("N-"),
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phone,
                email,
                address,
                departmentId,
                shift,
                qualification
        );

        addNurse(nurse);


    }

    public void getNurse(){
        for(Nurse nurse : nurses){
            nurse.displayInfo();
        }
    }
    public void editNurse(String nurseId, Nurse updatedNurse){
        for(Nurse n : nurses){
            if(n.getId().equals(nurseId)){

                n.setPhoneNumber(updatedNurse.getPhoneNumber());
                n.setEmail(updatedNurse.getEmail());
                n.setAddress(updatedNurse.getAddress());

                System.out.println(Constants.NURSE_UPDATED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.NURSE_NOT_FOUND);
    }

    public void removeNurse(String nurseId){
        for(Nurse n : nurses) {
            if (n.getId().equals(nurseId)) {
                nurses.remove(n);
                System.out.println(Constants.NURSE_REMOVED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.NURSE_NOT_FOUND);
    }

    public Nurse getNurseById(String nurseId){
        for(Nurse n : nurses) {
            if (n.getId().equals(nurseId)) {
               return n;
            }
        }
        System.out.println(Constants.NURSE_NOT_FOUND);
        return null;
    }

    public void getNurseByDepartment(String departmentId){

        boolean found = false;

        for(Nurse n : nurses){

            if(n.getDepartmentId().equals(departmentId)){
                n.displayInfo();
                found = true;
            }

        }
        if(!found){
            System.out.println(Constants.NURSE_NOT_FOUND);
        }
    }

    public void  getNursesByShift(String shift){
        boolean found = false;
        for(Nurse n : nurses){
            if(n.getShift().equals(shift)){
                n.displayInfo();
                found = true;
            }

        }
        if(!found){
            System.out.println(Constants.NURSE_NOT_FOUND);
        }
    }

    public void assignPatient(String nurseId, String patientId) {
        Nurse nurse = getNurseById(nurseId);
        if (HelperUtils.isNull(nurse)) { return; }
        nurse.assignPatient(patientId);
        System.out.println(Constants.PATIENT_ASSIGNED_SUCCESSFULLY);
    }



    @Override
    public void add(Object entity) {
        Nurse nurse = (Nurse) entity;
        for(Nurse n : nurses){
            if (n.getId().equals(nurse.getId())) {
                return;
            }
        }
        nurses.add(nurse);

    }

    @Override
    public void remove(String id) {
        Nurse nurse = getNurseById(id);
        nurses.remove(nurse);

    }

    @Override
    public void getAll() {
    }

    @Override
    public void search(String keyword) {

    }

    @Override
    public void searchById(String id) {

    }

    public void handleNurseMenu(){
        Boolean nurseExit = true;
        while (nurseExit){
            System.out.println(MenuMessage.NurseManagementMenu);
            int option = InputHandler.getIntInput(Constants.ENTER_OPTION,0,9);
            switch (option){
                case 1 -> addNurses();
                case 2-> getNurse();
                case 3-> {
                    String deptId = InputHandler.getStringInput("Enter department ID: ");
                    getNurseByDepartment(deptId);
                }
                case 4-> {
                    String shift = InputHandler.getStringInput("Enter shift: ");
                    getNursesByShift(shift);
                }
                case 5-> {
                    String nurseId = InputHandler.getStringInput("Nurse ID: ");
                    String patientId = InputHandler.getStringInput("Patient ID: ");
                    assignPatient(nurseId,patientId);
                }
            }
        }
    }
}
