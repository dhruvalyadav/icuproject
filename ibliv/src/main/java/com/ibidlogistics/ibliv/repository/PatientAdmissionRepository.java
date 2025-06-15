/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Patientadmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientAdmissionRepository extends JpaRepository<Patientadmission, Integer>
{
    @Query("SELECT p FROM Patientadmission p WHERE p.patient.patientid = :patientid")
    Patientadmission findByPatient(@Param("patientid") Integer patientid);  
}
