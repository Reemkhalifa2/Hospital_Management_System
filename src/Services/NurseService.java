package Services;

import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.Nurse;
import Utilities.Constants;
import Utilities.HelperUtils;
import Utilities.InputHandler;
import Utilities.MenuMessage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseService implements Manageable, Searchable {
    static Scanner scanner = new Scanner(System.in);
    List <Nurse> nurses = new ArrayList<>();

    public void addNurse(Nurse nurse){
        nurses.add(nurse);
        System.out.println(Constants.NURSE_ADDED_SUCCESSFULLY);
    }

    public Nurse addNurses(){

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

        return nurse;


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

    public void getNurseById(String nurseId){
        for(Nurse n : nurses) {
            if (n.getId().equals(nurseId)) {
               n.displayInfo();
               return;
            }
        }
        System.out.println(Constants.NURSE_NOT_FOUND);
    }

    public void getNurseByDepartment(String departmentId){
        for(Nurse n : nurses) {
            if (n.getDepartmentId().equals(departmentId)) {
               n.displayInfo();
               return;
            }
        }
        System.out.println(Constants.NURSE_NOT_FOUND);
    }

    public void  getNursesByShift(String shift){
        for(Nurse n : nurses) {
            if (n.getShift().equals(shift)) {
               n.displayInfo();
               return;
            }
        }
        System.out.println(Constants.NURSE_NOT_FOUND);
    }


    @Override
    public void add(Object entity) {

    }

    @Override
    public void remove(String id) {

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

        }
    }
}
