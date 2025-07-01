/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patientadditionaltests;
import com.ibidlogistics.ibliv.model.Patientivfluid;
import com.ibidlogistics.ibliv.repository.PatientivfluidRepository;
import java.time.LocalDate;
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
public class PatientivfluidController {
    @Autowired
    PatientivfluidRepository repository;
    
    @PostMapping("/addpatientivfluid")
    public void addpatientivfluid(@RequestBody Patientivfluid pativ){
        this.repository.save(pativ);
    }
    
    @GetMapping("/getpatientivfluidbydate/{date}/{patientdaysheetid}")
    public List<Patientivfluid> getpatientivfluidbydate(
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
            @PathVariable("patientdaysheetid") Integer patientdaysheetid){
       return this.repository.findByPatientANDCreatedate(date,patientdaysheetid);
    }
}
