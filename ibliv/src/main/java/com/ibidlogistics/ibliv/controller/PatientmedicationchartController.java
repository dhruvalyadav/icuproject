/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patientmedicationchart;
import com.ibidlogistics.ibliv.repository.PatientmedicationchartRepository;
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
public class PatientmedicationchartController {
    @Autowired
    PatientmedicationchartRepository Patientmedicationchartrepository;
    
    @PostMapping("/savepatientmedicationchart")
    public Patientmedicationchart savepatientmedicationchart(@RequestBody Patientmedicationchart patientmedication){
       return this.Patientmedicationchartrepository.save(patientmedication);
    }
    
    @GetMapping("/getpatientmedicationchartbypatient/{patientid}")
    public List<Patientmedicationchart> getpatientmedicationchartbypatient(@PathVariable("patientid") Integer patientid)
    {
        return this.Patientmedicationchartrepository.findByPatient(patientid);
    }
}
