/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

/**
 *
 * @author Athrava Kemkar
 */
import com.ibidlogistics.ibliv.model.Icu;
import com.ibidlogistics.ibliv.model.Shiftrmonurse;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftrmonurseRepository extends JpaRepository<Shiftrmonurse,Integer>{

   List<Shiftrmonurse> findByIcu(Icu icu); 
    
    
}

