/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patientivfluid;
import com.ibidlogistics.ibliv.repository.PatientivfluidRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
@CrossOrigin("*")
@RestController    
public class PatientivfluidController {
    @Autowired
    PatientivfluidRepository repository;
    
    @PostMapping("/addpatientivfluid")
    public void addpatientivfluid(@RequestBody Patientivfluid pativ){
        this.repository.save(pativ);
    }
    @GetMapping("/getivfluidsbypatient/{id}")
public List<Patientivfluid> getIvFluidsByPatient(@PathVariable("id") Integer id) {
    return repository.findByPatient_Patientid(id);
}

}
