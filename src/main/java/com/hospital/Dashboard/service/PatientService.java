package com.hospital.Dashboard.service;

import com.hospital.Dashboard.entity.Patient;
import com.hospital.Dashboard.entity.PatientRecord;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient registerPatient(Patient patient);
    Patient updatePatient(Long id, Patient updatedPatient);
    void deletePatient(Long id);
    List<PatientRecord> getAllPatientRecord();
    PatientRecord createPatientRecord(PatientRecord record);
    PatientRecord getPatientRecordById(Long id);
    PatientRecord updatePatientRecord(Long id, PatientRecord updatedRecord);
    void deletePatientRecord(Long id);
}
