/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Patientadmission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Laptop
 */
public interface PatientAdmissionRepository extends JpaRepository<Patientadmission, Integer>
{
    
}
