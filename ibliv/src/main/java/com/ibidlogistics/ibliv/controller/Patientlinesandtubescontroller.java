
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.model.Patientlinestubes;
import com.ibidlogistics.ibliv.repository.PatientlinestubesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class Patientlinesandtubescontroller {
     @Autowired
    PatientlinestubesRepository repository;
     
     @GetMapping("/getallpatientlinestubes")
    public List<Patientlinestubes> getallpatientlinestubes()
    {
        return this.repository.findAll();
    }
    
    @PostMapping("/savepatientlinestubes")
    public Patientlinestubes savepatientlinestubes(@RequestBody Patientlinestubes patientlinetube)
    {
        return this.repository.save(patientlinetube);
    }
    @GetMapping("/linestubes/{id}")
    public List<Patientlinestubes> getByPatientId(@PathVariable("id") Integer id) {
        return repository.findByPatientId(id);
    }
     
}
