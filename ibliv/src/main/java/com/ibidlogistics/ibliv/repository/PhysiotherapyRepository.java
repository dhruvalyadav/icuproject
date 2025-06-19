/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Physiothearpy;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysiotherapyRepository extends JpaRepository<Physiothearpy,Integer>{
        @Query("SELECT p FROM Physiothearpy p ORDER BY p.physiothearpy ASC")
        List<Physiothearpy> findAllByOrder();
}
