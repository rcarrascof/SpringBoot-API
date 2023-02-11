package RcxDev.example.superPos.Repository;

import RcxDev.example.superPos.Entities.customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface customerRepository extends JpaRepository<customers, Long> {

    @Query("SELECT c FROM customers c WHERE c.shop_id = ?1 AND c.owner_id = ?2 AND (c.customer_name LIKE %?3% OR c.customer_cell LIKE %?3% OR c.customer_email LIKE %?3% OR c.customer_address LIKE %?3%)")
    List<customers> getCustomers(Long shopId, Long ownerId, String searchText);

    @Query("SELECT c FROM customers c WHERE c.shop_id = ?1 AND c.owner_id = ?2 ")
    List<customers> getAllCustomers(Long shopId, Long ownerId);


}
