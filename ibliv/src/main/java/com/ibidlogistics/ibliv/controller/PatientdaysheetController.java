
package com.ibidlogistics.ibliv.controller;

import com.ibidlogistics.ibliv.repository.PatientdaysheetRepository;
import java.util.List;
import com.ibidlogistics.ibliv.model.Patientdaysheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PatientdaysheetController {
    @Autowired
    PatientdaysheetRepository patientdaysheetrepository;
    
    @GetMapping("/getallpatientdaysheet")
    public List<Patientdaysheet> getallpatientdaysheet()
    {
        return this.patientdaysheetrepository.findAll();
    }
}
