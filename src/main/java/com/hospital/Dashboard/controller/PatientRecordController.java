package com.hospital.Dashboard.controller;

import com.hospital.Dashboard.entity.Patient;
import com.hospital.Dashboard.entity.PatientRecord;
import com.hospital.Dashboard.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients/records")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientRecordController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientRecord>> getAllPatientRecords() {
        List<PatientRecord> records = patientService.getAllPatientRecord();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientRecord> getPatientRecordById(@PathVariable Long id) {
        PatientRecord record = patientService.getPatientRecordById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientRecord> createPatientRecord(@RequestBody PatientRecord record) {
        PatientRecord createdRecord = patientService.createPatientRecord(record);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientRecord> updatePatientRecord(@PathVariable Long id, @RequestBody PatientRecord record) {
        PatientRecord updatedRecord = patientService.updatePatientRecord(id, record);
        return new ResponseEntity<>(updatedRecord, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatientRecord(@PathVariable Long id){
        patientService.deletePatientRecord(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
