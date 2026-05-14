package Services;

import Behaviour.Editable;
import Behaviour.Manageable;
import Behaviour.Searchable;
import Entities.MedicalRecord;
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

public class MedicalRecordService implements Manageable, Searchable, Editable {
    private static List <MedicalRecord> medicalRecords = new ArrayList<>();
    PatientService patientService = new PatientService();

    public void addRecord(MedicalRecord record){
        medicalRecords.add(record);
        Patient patient = patientService.getPatientById(record.getPatientId());
        patient.addMedicalRecord(record);
        System.out.println(Constants.RECORD_ADDED_SUCCESSFULLY);
    }

    public void addNewRecords(){


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

        addRecord(medicalRecord);

    }

    public void updateMedicalRecord(){
        String recordId = InputHandler.getStringInput("Enter record ID: ");
        MedicalRecord record = getRecordById(recordId);
        if(HelperUtils.isNull(record)){
            return;
        }
        String diagnosis = InputHandler.getStringInput("Enter new diagnosis: ");
        String prescription = InputHandler.getStringInput("Enter new prescription: ");
        String testResults = InputHandler.getStringInput("Enter new testResults: ");
        MedicalRecord updateMedicalRecord = new MedicalRecord();
        updateMedicalRecord.setDiagnosis(diagnosis);
        updateMedicalRecord.setPrescription(prescription);
        updateMedicalRecord.setTestResults(testResults);


    }
    @Override
    public void edit(Object updatedData) {
        MedicalRecord medicalRecord = (MedicalRecord) updatedData;
        MedicalRecord m = getRecordById(medicalRecord.getRecordId());
        if (HelperUtils.isNotNull(m)){
            m.setDiagnosis(medicalRecord.getDiagnosis());
            m.setPrescription(medicalRecord.getPrescription());
            m.setTestResults(medicalRecord.getTestResults());
        }


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
        if (HelperUtils.isNull(medicalRecords)){
            System.out.println(Constants.RECORD_NOT_FOUND);
            return;
        }
        for(MedicalRecord m : medicalRecords) {
                m.displayInfo();
        }
    }
    public MedicalRecord getRecordById(String recordId){
        for(MedicalRecord record : medicalRecords) {
            if (record.getRecordId().equals(recordId)) {
                return record;
            }
        }
        System.out.println(Constants.RECORD_NOT_FOUND);
        return null;
    }

    public void getRecordsByPatientId(String patientId){
        if (HelperUtils.isNull(medicalRecords)){
            System.out.println(Constants.RECORD_NOT_FOUND);
            return;
        }
        for(MedicalRecord m : medicalRecords) {
            if (m.getPatientId().equals(patientId)) {
                m.displayInfo();
                return;
            }
        }
        System.out.println(Constants.RECORD_NOT_FOUND);
    }

    public void getRecordsByDoctorId(String doctorId){
        if (HelperUtils.isNull(medicalRecords)){
            System.out.println(Constants.RECORD_NOT_FOUND);
            return;
        }
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
        MedicalRecord medicalRecord = (MedicalRecord) entity;
        medicalRecords.add(medicalRecord);
    }

    @Override
    public void remove(String id) {
        MedicalRecord medicalRecord = getRecordById(id);
        if(HelperUtils.isNotNull(medicalRecord)){
            medicalRecords.remove(medicalRecord);
        }

    }

    @Override
    public void getAll() {

        if(HelperUtils.isNull(medicalRecords)){
            return;
        }
        medicalRecords.forEach(MedicalRecord::displayInfo);
    }

    @Override
    public void search(String keyword) {

    }

    @Override
    public void searchById(String id) {

    }


    public void handleMedicalREcordMenu() {

        Boolean exit = true;

        while (exit) {

            System.out.println(MenuMessage.MedicalRecordsManagementMenu);

            int option = InputHandler.getIntInput(Constants.ENTER_OPTION, 0, 9);

            switch (option) {
                case 1->addNewRecords();
                case 2->getRecords();
                case 3->getRecordsByPatientId(InputHandler.getStringInput("Enter Patient Id"));
                case 4->getRecordsByDoctorId(InputHandler.getStringInput("Enter Doctor Id"));
                case 5-> updateMedicalRecord();
                case 6-> remove(InputHandler.getStringInput("Enter Patient Id"));
            }
    }
    }



    @Override
    public void validate() {

    }
}
