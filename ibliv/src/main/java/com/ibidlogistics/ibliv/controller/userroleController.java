/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.User;
import com.ibidlogistics.ibliv.model.Userrole;
import com.ibidlogistics.ibliv.repository.UserroleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class userroleController {
    @Autowired
    UserroleRepository userrolerespoitory;
    
     @GetMapping("/userrolebyrole/{name}")
    public List<Userrole> userrolebyrole(@PathVariable("name") String nam)
    {
        return this.userrolerespoitory.findByRolename(nam);
    }
}
