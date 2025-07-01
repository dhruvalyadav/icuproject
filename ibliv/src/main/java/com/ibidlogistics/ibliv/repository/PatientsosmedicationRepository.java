/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Patientsosmedication;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsosmedicationRepository extends JpaRepository<Patientsosmedication,Integer>{
    @Query("SELECT p FROM Patientsosmedication p WHERE p.time = :time AND p.patient.patientid = :patientid ORDER BY p.patientsosmedicationid ASC")
    List<Patientsosmedication> findByPatientANDCreatedate(@Param("time") Date time,@Param("patientid") Integer patientid);
}
