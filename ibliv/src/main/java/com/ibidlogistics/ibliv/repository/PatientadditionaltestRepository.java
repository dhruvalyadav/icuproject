/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Patientadditionaltests;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientadditionaltestRepository extends JpaRepository<Patientadditionaltests, Integer>{
    @Query("SELECT p FROM Patientadditionaltests p WHERE p.patientdaysheet.patientadmission.patient.patientid = :patientid")
    List<Patientadditionaltests> findByPatientId(@Param("patientid") Integer patientid);
   }
