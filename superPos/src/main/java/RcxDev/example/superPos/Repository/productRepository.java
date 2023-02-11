package RcxDev.example.superPos.Repository;

import RcxDev.example.superPos.Entities.products;
import RcxDev.example.superPos.Entities.vw_products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepository  extends JpaRepository<products,Long> {
    @Query("SELECT p FROM products p INNER JOIN weight_unit w ON w.weight_unit_id = p.product_weight_unit_id WHERE p.shop_id = ?1 AND p.owner_id = ?2 AND (p.product_name LIKE %?3% OR p.product_code LIKE %?3%) ORDER BY p.product_id DESC")
    List<products> getProducts(Long shopId, Long ownerId, String searchText);

    @Query("SELECT p FROM products p INNER JOIN weight_unit w ON w.weight_unit_id = p.product_weight_unit_id WHERE p.shop_id = ?1 AND p.owner_id = ?2 ORDER BY p.id DESC")
    List<products> getProducts(Long shopId, Long ownerId);

    @Query("SELECT v FROM vw_products v WHERE v.shop_id = :shopId AND v.product_id = :productId ORDER BY v.product_id DESC")
    List<vw_products> getProductsById(@Param("productId") Long product_id, @Param("shopId") Long shopId);
    @Query("SELECT P FROM products P WHERE P.product_id=?1")
    products getProductStock(Long product_id);


}