/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;
import java.util.List;
import com.ibidlogistics.ibliv.model.Patientivfluid;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientivfluidRepository extends JpaRepository<Patientivfluid,Integer>{
               List<Patientivfluid> findByPatient_Patientid(Integer patientid);
    List<Patientivfluid> findByPatient_Patientid(Integer patientid);
}