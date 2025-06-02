
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Menudetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenudeatailsRepository extends JpaRepository<Menudetails,Integer>{
    
}
