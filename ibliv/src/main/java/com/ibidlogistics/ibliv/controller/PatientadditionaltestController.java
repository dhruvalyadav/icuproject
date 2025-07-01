/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patientadditionaltests;
import com.ibidlogistics.ibliv.repository.PatientadditionaltestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class PatientadditionaltestController {
    @Autowired
    PatientadditionaltestRepository Patientadditionaltestrepository;
    
    @PostMapping("/saveadditionalpatienttest")
    public Patientadditionaltests saveadditionalpatienttest(@RequestBody Patientadditionaltests patientaddtest){
       return this.Patientadditionaltestrepository.save(patientaddtest);
    }
    
    @GetMapping("/getpatientadditionaltest")
    public List<Patientadditionaltests> getpatientadditionaltest()
    {
        return this.Patientadditionaltestrepository.findAll();
    }
    
    @GetMapping("/getpatientadditionaltestbypatientdaysheetid/{patientdaysheetid}")
    public Patientadditionaltests getpatientadditionaltestbypatientdaysheetid(@PathVariable("patientdaysheetid") Integer patientdaysheetid){
       return this.Patientadditionaltestrepository.findByPatientadditionaltests(patientdaysheetid);
    }
} 
 