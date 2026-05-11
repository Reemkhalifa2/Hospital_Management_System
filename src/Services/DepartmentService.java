package Services;

import Entities.Department;
import Utilities.Constants;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    List<Department> departments = new ArrayList<>();

    public void addDepartment(Department department){
        departments.add(department);
        System.out.println(Constants.DEPARTMENT_ADDED_SUCCESSFULLY);
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
    }










}
