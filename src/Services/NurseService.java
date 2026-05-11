package Services;

import Entities.Nurse;
import Utilities.Constants;

import java.util.ArrayList;
import java.util.List;

public class NurseService {
    List <Nurse> nurses = new ArrayList<>();

    public void addNurse(Nurse nurse){
        nurses.add(nurse);
        System.out.println(Constants.NURSE_ADDED_SUCCESSFULLY);
    }



}
