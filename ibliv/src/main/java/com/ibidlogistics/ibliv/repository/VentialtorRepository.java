/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Ventilatormode;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Jayraj Malge
 */
public interface VentialtorRepository extends JpaRepository<Ventilatormode,Integer>{
        @Query("SELECT v FROM Ventilatormode v ORDER BY v.ventilatormode ASC")
         List<Ventilatormode> findAllOrderBy();
}
