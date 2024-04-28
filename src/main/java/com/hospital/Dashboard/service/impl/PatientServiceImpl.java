package com.hospital.Dashboard.service.impl;

import com.hospital.Dashboard.entity.Patient;
import com.hospital.Dashboard.entity.PatientRecord;
import com.hospital.Dashboard.repository.PatientRecordRepository;
import com.hospital.Dashboard.repository.PatientRepository;
import com.hospital.Dashboard.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientRecordRepository patientRecordRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @Override
    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient existingPatient = getPatientById(id);
        existingPatient.setName(updatedPatient.getName());
        existingPatient.setSpeciality(updatedPatient.getSpeciality());
        existingPatient.setContactInformation(updatedPatient.getContactInformation());
        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientRecord> getAllPatientRecord() {
        return patientRecordRepository.findAll();
    }

    @Override
    public PatientRecord createPatientRecord(PatientRecord record) {
        return patientRecordRepository.save(record);
    }

    @Override
    public PatientRecord getPatientRecordById(Long id) {
        return patientRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient record not found"));
    }

    @Override
    public PatientRecord updatePatientRecord(Long id, PatientRecord updatedRecord) {
        PatientRecord existingRecord = getPatientRecordById(id);
        existingRecord.setName(updatedRecord.getName());
        existingRecord.setAge(updatedRecord.getAge());
        existingRecord.setMedicalHistory(updatedRecord.getMedicalHistory());
        return patientRecordRepository.save(existingRecord);
    }

    @Override
    public void deletePatientRecord(Long id) {
        patientRecordRepository.deleteById(id);
    }
}
