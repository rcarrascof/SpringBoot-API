package RcxDev.example.superPos.Repository;

import RcxDev.example.superPos.Entities.shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface shopRepository extends JpaRepository<shop,Long> {

    @Query("SELECT s FROM shop s WHERE s.shop_id=?1")
    shop getShopById(Long id);

    @Query("SELECT s FROM shop s WHERE s.shop_id=?1")
    List<shop> getShopsById(Long id);
}
