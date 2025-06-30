/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ibidlogistics.ibliv.model.Shiftrmonurse;
import com.ibidlogistics.ibliv.repository.ShiftrmonurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ibidlogistics.ibliv.repository.IcuJpaRepository;
import com.ibidlogistics.ibliv.model.Icu;


@CrossOrigin("*")
@RestController
@RequestMapping("/shiftrmonurse")
public class shiftrmonurseController {
    @Autowired
    ShiftrmonurseRepository repository;
     @Autowired
    private IcuJpaRepository icuJpaRepository;
    
    @PostMapping("/addshiftrmo")
    public Shiftrmonurse addshiftrmo(@RequestBody Shiftrmonurse shiftrmo){
       return repository.save(shiftrmo);
    }
    
   @GetMapping("/getbyicu/{icuid}")
public List<Shiftrmonurse> getByIcu(@PathVariable("icuid") Integer icuid) {
    Optional<Icu> icuOpt = icuJpaRepository.findById(icuid);
    return icuOpt.isPresent() ? repository.findByIcu(icuOpt.get()) : new ArrayList<>();
}

}
