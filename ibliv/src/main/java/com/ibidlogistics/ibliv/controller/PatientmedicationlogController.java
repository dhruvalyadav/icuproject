/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patientmedicationlog;
import com.ibidlogistics.ibliv.repository.PatientmedicationlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class PatientmedicationlogController {
    @Autowired
    PatientmedicationlogRepository patientmedicationlogrepository;
    
    @PostMapping("/savepatientmedicationlog")
    public Patientmedicationlog savepatientmedicationlog(@RequestBody Patientmedicationlog patientmedication){
       return this.patientmedicationlogrepository.save(patientmedication);
    }
}
