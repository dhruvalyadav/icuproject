/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Patientadditionalscores;
import com.ibidlogistics.ibliv.model.Patientventilator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientventilatorRepository extends JpaRepository<Patientventilator,Integer>{
    @Query("SELECT p FROM Patientventilator p WHERE p.patientdaysheet.patientdaysheetid = :patientdaysheetid ORDER BY p.patientventilatorid ASC")
    Patientventilator findByPatientdaysheet(@Param("patientdaysheetid") Integer patientdaysheetid);
}
