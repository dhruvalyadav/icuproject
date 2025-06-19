/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Ventilatormode;
import com.ibidlogistics.ibliv.repository.VentialtorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class VentilatormodeController {
     @Autowired
    VentialtorRepository repository;
    
    @PostMapping("/saveventilator")
    public Ventilatormode saveventilator(@RequestBody Ventilatormode ventilator){
       return this.repository.save(ventilator);
    }
    
    @GetMapping("/getventilator")
    public List<Ventilatormode> getventilator()
    {
        return this.repository.findAllOrderBy();
    }
}
