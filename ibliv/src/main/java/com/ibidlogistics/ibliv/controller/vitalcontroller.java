/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Vital;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ibidlogistics.ibliv.repository.Vitalsrepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController
public class vitalcontroller {
    
    @Autowired
    Vitalsrepository vitalrepository;
            
            
    @GetMapping("/vitals")
    public List<Vital> vitals()
    {
        return this.vitalrepository.findAll();
    }
    
    @GetMapping("/vitalsbygroup")
    public List<Vital> vitalsbygroup()
    {
        return this.vitalrepository.findAllByGroup();
    }
    
    @PostMapping("/savevitals")
    public Vital savevitals(@RequestBody Vital vital)
    {
        return this.vitalrepository.save(vital);
    }
    
    @GetMapping("/vitalbycategory/{cat}")
    public List<Vital> vitalbycategory(@PathVariable("cat") String cat)
    {
        return this.vitalrepository.findByVitalcategory(cat);
    }
    
    @GetMapping("/getGroupByvital")
    public List<Vital> getGroupByvital()
    {
        return this.vitalrepository.findAllByGroup();
    }
}
