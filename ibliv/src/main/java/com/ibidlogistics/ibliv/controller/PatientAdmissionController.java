/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patientadmission;
import com.ibidlogistics.ibliv.repository.PatientAdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Laptop
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/patient-admission")
public class PatientAdmissionController
{
    @Autowired
    PatientAdmissionRepository repository;
    
    @PostMapping("/save-patientadmission")
    public void saveAdmission(@RequestBody Patientadmission p){
        repository.save(p);
    }
}
