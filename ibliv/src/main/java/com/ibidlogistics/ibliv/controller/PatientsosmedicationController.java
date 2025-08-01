/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patientsosmedication;
import com.ibidlogistics.ibliv.repository.PatientsosmedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class PatientsosmedicationController {
    @Autowired
    PatientsosmedicationRepository repository;
    
    @PostMapping("/savesosmedication")
    public Patientsosmedication savepatientmedicationchart(@RequestBody Patientsosmedication patientsosmedication){
       return this.repository.save(patientsosmedication);
    } 
}
