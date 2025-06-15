/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Hourlyobservation;
import com.ibidlogistics.ibliv.repository.HourlyObservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HourlyobservationController {
     @Autowired
    HourlyObservationRepository hourlyobserverrepository;
    
    @GetMapping("/getallhourlyobservation")
    public List<Hourlyobservation> getallhourlyobservation()
    {
        return this.hourlyobserverrepository.findAll();
    }
    
    @PostMapping("/addhourlyobservation") 
    public void addhourlyobservation(@RequestBody Hourlyobservation hourlyobservation){
        this.hourlyobserverrepository.save(hourlyobservation);
    }
}
