/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Embolism;
import com.ibidlogistics.ibliv.repository.EmbolismRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class EmbolismController {
    @Autowired
    EmbolismRepository embolismRepository;
    
    @PostMapping("/saveembolism")
    public Embolism saveembolism(@RequestBody Embolism embolism){
       return this.embolismRepository.save(embolism);
    }
}
