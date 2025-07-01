/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patientinfusion;
import com.ibidlogistics.ibliv.repository.PatientinfusionRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class PatientinfusionController {
    @Autowired
    PatientinfusionRepository repository;
    
    @PostMapping("/addpatientinfusion")
    public Patientinfusion addpatientinfusion(@RequestBody Patientinfusion patientinfusion){
       return repository.save(patientinfusion);
    }
    
    @GetMapping("/getpatientindusionbydate/{date}/{patientid}")
    public List<Patientinfusion> getpatientindusionfluidbydate(
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
            @PathVariable("patientid") Integer patientid){
       return this.repository.findByPatientANDCreatedate(date,patientid);
    }
}
