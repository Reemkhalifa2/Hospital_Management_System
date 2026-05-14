package Services;

import Behaviour.Editable;
import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.Department;
import Utilities.Constants;
import Utilities.HelperUtils;
import Utilities.InputHandler;
import Utilities.MenuMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentService implements Manageable, Searchable , Editable {
    static Scanner scanner = new Scanner(System.in);
    List<Department> departments = new ArrayList<>();

    public void addDepartment(Department department){
        departments.add(department);
        System.out.println(Constants.DEPARTMENT_ADDED_SUCCESSFULLY);
    }

    public Department addDepartment(){

        String departmentName = InputHandler.getStringInput("Enter Department Name: ");

        String headDoctorId = InputHandler.getStringInput("Enter Head Doctor ID: ");

        System.out.print("Enter Bed Capacity: ");
        int bedCapacity = InputHandler.getIntInput("Enter Bed Capacity: ");

        List<String> doctors = new ArrayList<>();
        List<String> nurses = new ArrayList<>();

        System.out.print("Enter Available Beds: ");
        int availableBeds = InputHandler.getIntInput("Enter Available Beds: ");
        Department department = new Department(
                HelperUtils.generateId("D-"),
                departmentName,
                headDoctorId,
                bedCapacity

        );

        return department;

    }

    public void editDepartment(String departmentId, Department updatedDepartment) {
        for (Department d : departments) {
            if (d.getDepartmentId().equals(departmentId)) {
                d.setBedCapacity(updatedDepartment.getBedCapacity());
                d.setAvailableBeds(updatedDepartment.getAvailableBeds());
                return;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
    }

    public void removeDepartment(String departmentId) {
        for (Department d : departments) {
            if (d.getDepartmentId().equals(departmentId)) {
                departments.remove(d);
                return;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
    }
    public void getDepartments() {
        if (departments.isEmpty()) {
            System.out.println(Constants.DEPARTMENT_NOT_FOUND);
            return;
        }
        for (Department d : departments) {
            d.displayInfo();
        }
    }

    public Department getDepartmentById(String departmentId) {
        for (Department d : departments) {
            if (d.getDepartmentId().equals(departmentId)) {
                return d;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
        return null;
    }

    public void displayAllDepartments(){
        for(Department d : departments){
                d.displayInfo();
            }
        }


    public void assignDoctorToDepartment(String doctorId, String departmentId){
        Department department = getDepartmentById(departmentId);
        if (HelperUtils.isNull(department)) {
            return;
        }
        department.assignDoctor(doctorId);
        System.out.println(Constants.DOCTOR_ASSIGNED_SUCCESSFULLY);
    }

    public void assignPatientToDepartment(String nurseId, String departmentId){
        Department department = getDepartmentById(departmentId);
        if (HelperUtils.isNull(department)) {
            return;
        }
        department.assignNurse(nurseId);
        System.out.println(Constants.DOCTOR_ASSIGNED_SUCCESSFULLY);
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
    public void viewDepartmentDetails(){

        String id = InputHandler.getStringInput("Enter Department ID: ");

        for(Department d : departments){

            if(d.getDepartmentId().equals(id)){
                d.displayInfo();
                return;
            }
        }

        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
    }
    public void updateDepartment() {
        String departmentId = InputHandler.getStringInput("Enter department ID: ");
        Department existingDepartment = getDepartmentById(departmentId);
        if (HelperUtils.isNull(existingDepartment)) {
            return;
        }

        String departmentName = InputHandler.getStringInput("Enter new department name: ");
        String headDoctorId   = InputHandler.getStringInput("Enter new head doctor ID: ");
        int bedCapacity        = InputHandler.getIntInput("Enter new bed capacity: ");
        int availableBeds      = InputHandler.getIntInput("Enter new available beds: ");

        Department updatedDepartment = new Department();
        updatedDepartment.setDepartmentId(departmentId);
        updatedDepartment.setDepartmentName(departmentName);
        updatedDepartment.setHeadDoctorId(headDoctorId);
        updatedDepartment.setBedCapacity(bedCapacity);
        updatedDepartment.setAvailableBeds(availableBeds);

        edit(updatedDepartment);
    }

    public void viewDepartmentStatistics() {
        if (HelperUtils.isNull(departments)) {
            System.out.println(Constants.DEPARTMENT_NOT_FOUND);
            return;
        }
        
    }



    public void handleDepartmentMenu() {
        boolean departmentExit = true;
        while (departmentExit) {
            System.out.println(MenuMessage.DepartmentManagementMenu);
            int option = InputHandler.getIntInput(Constants.ENTER_OPTION, 0, 7);
            switch (option) {
                case 1 -> addDepartment();
                case 2 -> getDepartments();
                case 3 -> viewDepartmentDetails();
                case 4-> {
                    String doctorId     = InputHandler.getStringInput("Enter doctor ID: ");
                    String departmentId = InputHandler.getStringInput("Enter department ID: ");
                    assignDoctorToDepartment(doctorId,departmentId);
                }
                case 5-> {
                    String nurseId     = InputHandler.getStringInput("Enter Nurse ID: ");
                    String departmentId = InputHandler.getStringInput("Enter department ID: ");
                    assignDoctorToDepartment(nurseId,departmentId);
                }




            }
        }
    }

    @Override
    public void edit(Object updatedData) {
        Department updatedDepartment = (Department) updatedData;
        for (Department d : departments) {
            if (d.getDepartmentId().equals(updatedDepartment.getDepartmentId())) {
                d.setDepartmentName(updatedDepartment.getDepartmentName());
                d.setHeadDoctorId(updatedDepartment.getHeadDoctorId());
                d.setBedCapacity(updatedDepartment.getBedCapacity());
                d.setAvailableBeds(updatedDepartment.getAvailableBeds());
                System.out.println(Constants.DEPARTMENT_UPDATED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);

    }

    @Override
    public void validate() {

    }
}
