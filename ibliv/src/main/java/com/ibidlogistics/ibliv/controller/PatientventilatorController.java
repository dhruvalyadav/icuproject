/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patientventilator;
import com.ibidlogistics.ibliv.repository.PatientventilatorRepository;
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
public class PatientventilatorController {
    @Autowired
    PatientventilatorRepository repository;
    
    @PostMapping("/addventilator")
    public Patientventilator addventilator(@RequestBody Patientventilator patvent){
       return repository.save(patvent);
    }
    
    @GetMapping("/getventilatorlist")
    public List<Patientventilator> getventilatorlist(){
        return repository.findAll();
    }
    
    @GetMapping("/getpatientventilatorbypatientdaysheetid/{patientdaysheetid}")
    public Patientventilator getpatientventilatorbypatientdaysheetid(@PathVariable("patientdaysheetid") Integer patientdaysheetid){
       return this.repository.findByPatientdaysheet(patientdaysheetid);
    }
}
