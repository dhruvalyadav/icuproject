/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Anthropometry;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnthropometryRepository extends JpaRepository<Anthropometry,Integer> {
     @Query("SELECT a FROM Anthropometry a WHERE a.patient.patientname LIKE LOWER(CONCAT('%', :patientname, '%'))")
    List<Anthropometry> findByPatientname(@Param("patientname") String patientname);
    @Query("SELECT a FROM Anthropometry a WHERE a.patient.patientid = :patientId")
List<Anthropometry> findByPatientId(@Param("patientId") Integer patientId);

    

}
