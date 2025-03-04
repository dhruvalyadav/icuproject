/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ibidlogistics.ibliv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ibidlogistics.ibliv.model.Icu;
/**
 *
 * @author Laptop
 */
public interface IcuJpaRepository extends JpaRepository<Icu,Integer>
{
    
}
