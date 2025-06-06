/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Anthropometry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.ibidlogistics.ibliv.repository.AnthropometryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("*")
public class AnthropometryController {
    @Autowired 
    AnthropometryRepository anthropometryRepository;
    
    @PostMapping("/addanthropometry")
    public void addanthropometry(@RequestBody Anthropometry anthropometry){
        this.anthropometryRepository.save(anthropometry);
    }
    
    @PutMapping("/updateanthropometry")
    public Anthropometry updateanthropometry(@RequestBody Anthropometry ant)
    {
       return this.anthropometryRepository.save(ant);
    }
     
    @GetMapping("/getanthropometry")
    public List<Anthropometry> getanthropometry(){
        return this.anthropometryRepository.findAll();
    }
    
    @GetMapping("/filteranthropometry/{patientname}")
    public List<Anthropometry> filteranthropometry(@PathVariable("patientname") String patientname){
        return this.anthropometryRepository.findByPatientname(patientname);
    }
}
