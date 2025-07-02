
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Vital;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Vitalsrepository extends JpaRepository<Vital, Integer> {
       @Query("SELECT v FROM Vital v GROUP BY v.vitalcategory ORDER BY v.vitalid ASC")
       List<Vital> findAllByGroup();
       
       @Query("SELECT v FROM Vital v WHERE v.vitalcategory = :vitalcategory")
       List<Vital> findByVitalcategory(@Param("vitalcategory") String vitalcategory);

}
