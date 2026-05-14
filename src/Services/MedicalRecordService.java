package Services;

import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.MedicalRecord;
import Entities.Nurse;
import Utilities.Constants;
import Utilities.HelperUtils;
import Utilities.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService implements Manageable, Searchable {
    List <MedicalRecord> medicalRecords = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void addRecord(MedicalRecord record){
        medicalRecords.add(record);
        System.out.println(Constants.RECORD_ADDED_SUCCESSFULLY);
    }

    public MedicalRecord addNewRecords(){


        String patientId = InputHandler.getStringInput("Enter patient Id: ");

        String doctorId = InputHandler.getStringInput("Enter Doctor Id: ");

        LocalDate visitDate = LocalDate.now();

        String diagnosis = InputHandler.getStringInput("Enter diagnosis: ");

        String prescription = InputHandler.getStringInput("Enter prescription: ");

        String testResults = InputHandler.getStringInput("Enter testResults: ");
        
        String notes = InputHandler.getStringInput("Enter notes: ");

        MedicalRecord medicalRecord = new MedicalRecord(
                HelperUtils.generateId("MR",3),patientId,doctorId,visitDate,diagnosis,prescription,testResults,notes
        );

        return medicalRecord;

    }

    public void editMedicalRecord(String recordId, MedicalRecord updatedRecord){
        for(MedicalRecord m : medicalRecords){
            if(m.getRecordId().equals(recordId)){

                m.setDiagnosis(updatedRecord.getDiagnosis());
                m.setPrescription(updatedRecord.getPrescription());
                m.setNotes(updatedRecord.getNotes());


                System.out.println(Constants.RECORD_UPDATED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.RECORD_NOT_FOUND);
    }

    public void removeRecord(String recordId) {
        for (MedicalRecord n : medicalRecords) {
            if (n.getRecordId().equals(recordId)) {
                medicalRecords.remove(n);
                System.out.println(Constants.RECORD_REMOVED_SUCCESSFULLY);
                return;
            }
        }
        System.out.println(Constants.RECORD_NOT_FOUND);

    }
    public void getRecords(){
        for(MedicalRecord m : medicalRecords) {
                m.displayInfo();

        }
    }
    public void getRecordsByPatientId(String patientId){
        for(MedicalRecord m : medicalRecords) {
            if (m.getPatientId().equals(patientId)) {
                m.displayInfo();
                return;
            }
        }
        System.out.println(Constants.RECORD_NOT_FOUND);
    }

    public void getRecordsByDoctorId(String doctorId){
        for(MedicalRecord m : medicalRecords) {
            if (m.getDoctorId().equals(doctorId)) {
                m.displayInfo();
                return;
            }
        }
        System.out.println(Constants.RECORD_NOT_FOUND);
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
}
