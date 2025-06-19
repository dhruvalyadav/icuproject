/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Ivfluid;
import com.ibidlogistics.ibliv.model.Patient;
import com.ibidlogistics.ibliv.repository.IvfluidRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class IvfluidController {
    @Autowired
    IvfluidRepository repository;
    
    @PostMapping("/saveivfluid")
    public void saveivfluid(@RequestBody Ivfluid iv){
        this.repository.save(iv);
    }
    
    @GetMapping("/getivfluid")
    public List<Ivfluid> getivfluid(){
        return repository.findAllOrderBy();
    }
}
