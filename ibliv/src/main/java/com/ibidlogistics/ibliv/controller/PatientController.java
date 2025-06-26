/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Anthropometry;
import com.ibidlogistics.ibliv.model.Icu;
import com.ibidlogistics.ibliv.model.Patient;
import com.ibidlogistics.ibliv.model.Patientadmission;
import com.ibidlogistics.ibliv.repository.AnthropometryRepository;
import com.ibidlogistics.ibliv.repository.IcuJpaRepository;
import com.ibidlogistics.ibliv.repository.PatientAdmissionRepository;
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


@CrossOrigin("*")
@RestController
public class PatientController
{
    @Autowired
    PatientJpaRepository repository;

    @Autowired
    IcuJpaRepository icuRepo;
    
    @Autowired
    PatientAdmissionRepository admitrepository;
    
    @Autowired 
    AnthropometryRepository anthropometryRepository;
    
    @PostMapping("/admit-patient")
    public void saveAdmission(@RequestBody Patientadmission p){
        admitrepository.save(p);
    }
    @PostMapping("/add-patient")
    public Patient addPatient(@RequestBody Patient p){
       return repository.save(p);
    }
     
    @PutMapping("/update-patient")
    public void updatePatient(@RequestBody Patient p){
        Optional<Patient> existingPatient = repository.findById(p.getPatientid());
        if(existingPatient.isPresent()){
            repository.save(p);
        }        
    }
    
    @DeleteMapping("/deletepatient/{id}")
    public void deletePatient(@PathVariable("id") Integer id){
         repository.DeleteByPatientid(id);
    }
    
    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable("id") Integer patientid)
    {
        return this.repository.findByPatientid(patientid);
    }
     
    @GetMapping("/patient-list")
    public List<Patient> getAllPatient(){
        return repository.findAllOrderBy();
    }
        
    @GetMapping("/icu-list")
    public List<Icu> getIcuType(){
        return icuRepo.findAll();
    }
    
    @GetMapping("/icu/{id}")
    public ResponseEntity<Icu> getIcuById(@PathVariable("id") Integer icuid)
    { 
        System.err.println("icu id : "+icuid);
        Optional<Icu> opatient=icuRepo.findById(icuid);
        if(opatient!=null) 
            return ResponseEntity.ok(opatient.get());
        else
            return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/filterpatient/{name}")
    public List<Patient> filterpatient(@PathVariable("name") String name){
       return this.repository.findByPatientsimilarName(name);
    }
}
