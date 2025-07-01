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
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;
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
      @GetMapping("/gethourlyvitalsbypatient/{patientId}")
public List<Map<String, Object>> getHourlyVitalsByPatient(@PathVariable Integer patientId) {
    List<Hourlyobservation> observations = hourlyobserverrepository.findByPatientdaysheet_Patientadmission_Patient_Patientid(patientId);

    Map<String, Map<String, String>> grouped = new LinkedHashMap<>();

    for (Hourlyobservation obs : observations) {
        String vitalName = obs.getVital().getVitalname();
        String vitalCategory = obs.getVital().getVitalcategory(); 
        String hour = String.format("%02d:00", obs.getTimeslot());
        String value = obs.getValue() != null ? obs.getValue().toString() : "-";

        String key = vitalCategory + "||" + vitalName;  
        grouped.computeIfAbsent(key, k -> new LinkedHashMap<>()).put(hour, value);
    }

    return grouped.entrySet().stream().map(entry -> {
        String key = entry.getKey();
        String[] parts = key.split("\\|\\|");
        String vitalCategory = parts.length > 0 ? parts[0] : "";
        String vitalName = parts.length > 1 ? parts[1] : "";

        Map<String, Object> map = new HashMap<>();
        map.put("vitalname", vitalName);
        map.put("vitalcategory", vitalCategory);
        map.put("data", entry.getValue());
        return map;
    }).collect(Collectors.toList());
}
}
