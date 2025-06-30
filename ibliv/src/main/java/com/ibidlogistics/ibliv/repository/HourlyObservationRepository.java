/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Hourlyobservation;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ibidlogistics.ibliv.model.Patientdaysheet;
import com.ibidlogistics.ibliv.model.Vital;
import java.util.List;

/**
 *
 * @author Jayraj Malge
 */
public interface HourlyObservationRepository extends JpaRepository<Hourlyobservation, Integer>{
     List<Hourlyobservation> findByPatientdaysheet_Patientadmission_Patient_Patientid(Integer patientId);

    List<Hourlyobservation> findByPatientdaysheet(Patientdaysheet patientdaysheet);
    List<Hourlyobservation> findByVital(Vital vital);
    
}
