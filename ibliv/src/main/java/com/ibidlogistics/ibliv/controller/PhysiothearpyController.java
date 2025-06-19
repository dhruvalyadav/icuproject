/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Physiothearpy;
import com.ibidlogistics.ibliv.repository.PhysiotherapyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class PhysiothearpyController {
    @Autowired 
    PhysiotherapyRepository repository;
    
     @GetMapping("/getphysiotheripes")
    public List<Physiothearpy> getphysiotheripes()
    {
        return this.repository.findAllByOrder();
    }
    
    @PostMapping("/savephysiothearpy")
    public Physiothearpy savephysiothearpy(@RequestBody Physiothearpy physio){
       return this.repository.save(physio);
    }
}
