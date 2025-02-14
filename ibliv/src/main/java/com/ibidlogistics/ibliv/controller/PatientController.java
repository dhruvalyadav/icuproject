/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patient;
import com.ibidlogistics.ibliv.repository.PatientJpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Laptop
 */
@CrossOrigin("*")
@RestController
public class PatientController
{
    @Autowired
    PatientJpaRepository repository;
    
    @PostMapping("/add-patient")
    public void addPatient(@RequestBody Patient p){
        repository.save(p);
    }
    
    @PutMapping("/update-patient")
    public void updatePatient(@RequestBody Patient p){
        Optional<Patient> existingPatient = repository.findById(p.getPatientId());
        
        
        if(existingPatient.isPresent()){
            repository.save(p);
        }        
    }
    
    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable int id){
        repository.deleteById(id);
    }
    
    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Integer patientid)
    {
        Optional<Patient> opatient=repository.findById(patientid);
        if(opatient!=null) return ResponseEntity.ok(opatient.get());
        return ResponseEntity.notFound().build();
    }
     
    @GetMapping("/patient-list")
    List<Patient> getAllPatient(){
        return repository.findAll();
    }
}
