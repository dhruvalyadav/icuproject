/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patientadmission;
import com.ibidlogistics.ibliv.repository.IcuJpaRepository;
import com.ibidlogistics.ibliv.repository.PatientAdmissionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PatientAdmissionController {
    @Autowired
    IcuJpaRepository icurespository;
    
    @Autowired
    PatientAdmissionRepository patientrepository;
    
     @GetMapping("/getalladmittedpatient")
    public List<Patientadmission> getalladmittedpatient()
    {
        return this.patientrepository.findAll();
    } 
     
    @PostMapping("/saveadmittedpatient")
    public Patientadmission saveadmittedpatient(@RequestBody Patientadmission patientadmit){
        return this.patientrepository.save(patientadmit);
    }
    
    @GetMapping("/getpatientadmissionbypatient/{patientid}")
    public Patientadmission getpatientadmissionbypatient(@PathVariable("patientid") Integer patientid)
    {
        return this.patientrepository.findByPatient(patientid);
    } 
    
}
