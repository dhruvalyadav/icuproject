/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Patientmedicationchart;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientmedicationchartRepository extends JpaRepository<Patientmedicationchart,Integer>{
        @Query("SELECT p FROM Patientmedicationchart p WHERE p.patientadmission.patient.patientid = :patientid")
        List<Patientmedicationchart> findByPatient(@Param("patientid") Integer  patientid);
        
       @Query( "SELECT p FROM Patientmedicationchart p WHERE p.date = :date AND p.patientadmission.patient.patientid = :patientid ORDER BY p.patientmedicationchartid DESC")     
        List<Patientmedicationchart> findByDate(@Param("date") Date date,@Param("patientid") Integer patientid);

}
