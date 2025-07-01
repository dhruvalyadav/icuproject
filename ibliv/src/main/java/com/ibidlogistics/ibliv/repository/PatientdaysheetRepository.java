/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Patientdaysheet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository 
public interface PatientdaysheetRepository  extends JpaRepository<Patientdaysheet,Integer>{
        @Query("SELECT p FROM Patientdaysheet p WHERE p.patientadmission.patient.patientid = :patientid ORDER BY p.patientdaysheetid ASC")
        List<Patientdaysheet> findByPatient(@Param("patientid") Integer patientid);
        
        @Query("SELECT p FROM Patientdaysheet p WHERE p.patientdaysheetid = :patientdaysheetid")
         Patientdaysheet findByPatientdaysheetid(@Param("patientdaysheetid") Integer patientdaysheetid);
}
