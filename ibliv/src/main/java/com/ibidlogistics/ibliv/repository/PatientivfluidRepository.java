/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Patientadditionaltests;
import com.ibidlogistics.ibliv.model.Patientivfluid;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientivfluidRepository extends JpaRepository<Patientivfluid,Integer>{
    @Query("SELECT p FROM Patientivfluid p WHERE p.createddate = :createddate AND p.patient.patientid = :patientid ORDER BY p.patientivfluidid ASC")
    List<Patientivfluid> findByPatientANDCreatedate(@Param("createddate") Date createddate,@Param("patientid") Integer patientid);
}
