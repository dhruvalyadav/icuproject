/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Rmonurselog;
import com.ibidlogistics.ibliv.repository.RmonurselogRepository;
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
public class RmonurselogController {
    @Autowired
    RmonurselogRepository repository;
    
    @PostMapping("/addrmonurselog")
    public Rmonurselog addrmonurselog(@RequestBody Rmonurselog rmo){
       return repository.save(rmo);
    }
    
    @GetMapping("/getrmonurselogbypatientdaysheet/{sheetid}")
    public List<Rmonurselog> getrmonurselogbypatientdaysheet(@PathVariable("sheetid") Integer sheetid){
       return repository.findByPatientdaysheet(sheetid);
    }
}
