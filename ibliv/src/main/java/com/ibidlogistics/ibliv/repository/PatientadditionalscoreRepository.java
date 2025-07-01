/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Patientadditionalscores;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientadditionalscoreRepository extends JpaRepository<Patientadditionalscores, Integer>{
    @Query("SELECT s FROM Patientadditionalscores s " + "WHERE s.patientdaysheet.patientadmission.patient.patientid = :patientid")
    List<Patientadditionalscores> findByPatientId(@Param("patientid") Integer id);
}
