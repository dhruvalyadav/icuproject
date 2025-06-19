/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Consultantpatientvisit;
import com.ibidlogistics.ibliv.repository.ConsultantpatientvisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class ConsultantpatientvisitController {
    
    @Autowired
    ConsultantpatientvisitRepository repository;
    
    @PostMapping("/addconsultantpatientvisit")
    public void addconsultantpatientvisit(@RequestBody Consultantpatientvisit conpatvist){
        this.repository.save(conpatvist);
    }
}
