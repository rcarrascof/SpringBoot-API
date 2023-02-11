package RcxDev.example.superPos.Repository;

import RcxDev.example.superPos.Entities.customers;
import RcxDev.example.superPos.Entities.suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface supplierRepository  extends JpaRepository<suppliers,Long> {

    @Query("SELECT s FROM suppliers s WHERE s.shop_id = ?1 AND s.owner_id = ?2 AND (s.suppliers_name LIKE %?3% OR s.suppliers_cell LIKE %?3% OR s.suppliers_email LIKE %?3% OR s.suppliers_address LIKE %?3% OR s.suppliers_contact_person LIKE %?3%)")
    List<suppliers> getSuppliers(Long shopId, Long ownerId, String searchText);

    @Query("SELECT s FROM suppliers s WHERE s.shop_id = ?1 AND s.owner_id = ?2 ORDER BY s.suppliers_id DESC")
    List<suppliers> getSuppliers(Long shopId, Long ownerId);
}
