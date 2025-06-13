
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Menudetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenudeatailsRepository extends JpaRepository<Menudetails,Integer>{
        @Query("SELECT m FROM Menudetails m ORDER BY m.mainsort ASC")
        List<Menudetails> findAllByOrder();
        
        @Query("SELECT m FROM Menudetails m WHERE m.mainname = :mainname ORDER BY m.subsort ASC")
        List<Menudetails> findByMainnameWithOrder(@Param("mainname") String mainname);
}
