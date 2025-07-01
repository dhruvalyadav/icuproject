/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Rmonurselog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RmonurselogRepository extends JpaRepository<Rmonurselog,Integer>{
            @Query("SELECT r FROM Rmonurselog r WHERE r.patientdaysheet.patientdaysheetid = :patientdaysheetid ORDER BY r.rmonurselogid ASC LIMIT 3")
             List<Rmonurselog> findByPatientdaysheet(@Param("patientdaysheetid") Integer patientdaysheetid);
}
