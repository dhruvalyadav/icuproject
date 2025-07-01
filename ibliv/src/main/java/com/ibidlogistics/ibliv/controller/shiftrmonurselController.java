/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patientdaysheet;
import com.ibidlogistics.ibliv.model.Shiftrmonurse;
import com.ibidlogistics.ibliv.repository.PatientdaysheetRepository;
import com.ibidlogistics.ibliv.repository.ShiftrmonurseRepository;
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
public class shiftrmonurselController {
    @Autowired
    ShiftrmonurseRepository repository;
    
    @Autowired
    PatientdaysheetRepository patientdaysheetrepository;
   
    @PostMapping("/addshiftrmo")
    public Shiftrmonurse addshiftrmo(@RequestBody Shiftrmonurse shiftrmo){
       return repository.save(shiftrmo);
    }
    
    @GetMapping("/getshiftrmonurssebypatientdaysheetid/{sheetid}")
    public List<Shiftrmonurse> getshiftrmonurssebypatientdaysheetid(@PathVariable("sheetid") Integer sheetid){
       Patientdaysheet sheet =  this.patientdaysheetrepository.findByPatientdaysheetid(sheetid);
       return this.repository.findByDate(sheet.getDate());
    }
}
