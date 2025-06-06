/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Icu;
import com.ibidlogistics.ibliv.model.Patientadmission;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.ibidlogistics.ibliv.repository.IcuJpaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("*")
public class IcuController {
    
    @Autowired
    IcuJpaRepository icurespository;
    
    @GetMapping("/getallicu")
    public List<Icu> getallicu()
    {
        return this.icurespository.findAll();
    }
    
    @PostMapping("/addicu")
    public void addicu(@RequestBody Icu icu){
        this.icurespository.save(icu);
    }
}
