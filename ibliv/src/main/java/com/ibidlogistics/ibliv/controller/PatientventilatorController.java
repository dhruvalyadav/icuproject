/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patientventilator;
import com.ibidlogistics.ibliv.repository.PatientventilatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    @GetMapping("/getventilatorbypatientdaysheet/{id}")
public List<Patientventilator> getVentilatorsByPatient(@PathVariable("id") Integer id) {
   return repository.findByPatientdaysheet_Patientadmission_Patient_Patientid(id);
}

}
