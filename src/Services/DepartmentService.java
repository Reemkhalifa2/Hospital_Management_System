package Services;

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

public class DepartmentService implements Manageable, Searchable {
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

    public void getDepartmentById(String departmentId){
        for(Department d : departments){
            if(d.getDepartmentId().equals(departmentId)){
                d.displayInfo();
                return;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
    }

    public void displayAllDepartments(){
        for(Department d : departments){
                d.displayInfo();
            }
        }


    public void assignDoctorToDepartment(String doctorId, String departmentId){
        for(Department d : departments){
            if(d.getDepartmentId().equals(departmentId)){
                d.setHeadDoctorId(doctorId);
                return;
            }
        }
        System.out.println(Constants.DEPARTMENT_NOT_FOUND);
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

    public void handleDepartmentMenu() {
        boolean departmentExit = true;
        while (departmentExit) {
            System.out.println(MenuMessage.DepartmentManagementMenu);
            int option = InputHandler.getIntInput(Constants.ENTER_OPTION, 0, 7);
            switch (option) {
                case 1 -> addDepartment();

            }
        }
    }
}
