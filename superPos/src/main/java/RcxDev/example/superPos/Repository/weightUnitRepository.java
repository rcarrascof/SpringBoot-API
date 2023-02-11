package RcxDev.example.superPos.Repository;

import RcxDev.example.superPos.Entities.suppliers;
import RcxDev.example.superPos.Entities.weight_unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface weightUnitRepository  extends JpaRepository<weight_unit,Long> {

    @Query("SELECT w FROM weight_unit w WHERE w.weight_unit_name LIKE %?1% ")
    List<weight_unit> getWeightUnits(String searchText);

    @Query("SELECT w FROM weight_unit w ORDER BY weight_unit_id DESC")
    List<weight_unit> getWeightUnits();
}
