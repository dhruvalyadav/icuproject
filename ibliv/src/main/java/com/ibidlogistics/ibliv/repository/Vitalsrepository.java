
package com.ibidlogistics.ibliv.repository;

import com.ibidlogistics.ibliv.model.Vital;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Vitalsrepository extends JpaRepository<Vital, Integer> {

}
