/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Hourlyobservation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface HourlyObservationRepository extends JpaRepository<Hourlyobservation, Integer>{
        @Query("SELECT h FROM Hourlyobservation h WHERE h.patientdaysheet.patientdaysheetid = :patientdaysheetid GROUP BY h.vital.vitalcategory")
        List<Hourlyobservation> findByPatientdaysheetGroupByvital(@Param("patientdaysheetid") Integer patientdaysheetid);
        
        @Query("SELECT h FROM Hourlyobservation h WHERE h.patientdaysheet.patientdaysheetid = :patientdaysheetid")
        List<Hourlyobservation> findByPatientdaysheet(@Param("patientdaysheetid") Integer patientdaysheetid);
}
