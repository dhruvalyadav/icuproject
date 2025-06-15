/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Hourlyobservation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jayraj Malge
 */
public interface HourlyObservationRepository extends JpaRepository<Hourlyobservation, Integer>{
    
}
