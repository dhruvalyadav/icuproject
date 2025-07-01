/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Shiftrmonurse;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftrmonurseRepository extends JpaRepository<Shiftrmonurse,Integer>{      
       @Query( "SELECT s FROM Shiftrmonurse s WHERE s.date = :date ORDER BY s.shiftrmonurseid DESC LIMIT 3")     
        List<Shiftrmonurse> findByDate(@Param("date") Date date);

}
