/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Patient;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laptop
 */
@Repository
public interface PatientJpaRepository extends JpaRepository<Patient, Integer>
{
    @Query("SELECT p FROM Patient p WHERE p.patientname LIKE LOWER(CONCAT('%', :patientname, '%'))")
    List<Patient> findByPatientsimilarName(@Param("patientname") String patientname);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM Patient p WHERE p.patientid = :patientid")
    void DeleteByPatientid(@Param("patientid") Integer patientid);
    
    @Query("SELECT p FROM Patient p WHERE p.patientid = :patientid")
    Patient findByPatientid(@Param("patientid") Integer patientid);

}