package RcxDev.example.superPos.Repository;

import RcxDev.example.superPos.Dto.OrderDetailDTO;
import RcxDev.example.superPos.Entities.order_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface orderDetailRepository extends JpaRepository<order_details,Long>{


  @Query("SELECT i FROM order_details i WHERE i.invoice_id=?1 ORDER BY i.order_details_id DESC")
  List<order_details> OrderDetailsByInvoice(String invoice_id);


  //Reports

  @Query(value = "SELECT * FROM order_details o WHERE o.shop_id = ?1 AND o.owner_id = ?2 AND   MONTH(STR_TO_DATE(o.product_order_date, '%Y-%m-%d')) = MONTH(?3) ORDER BY o.order_details_id DESC", nativeQuery = true)
  List<order_details> salesReportMonthly(Long shopId,Long ownerId, String month);




  @Query(value = "SELECT * FROM order_details WHERE shop_id=?1 AND owner_id=?2 AND YEAR(STR_TO_DATE(product_order_date, '%Y-%m-%d')) = YEAR(NOW()) ORDER BY order_details_id DESC", nativeQuery = true)
  List<order_details> salesReportYearly(Long shopId, Long ownerId);

  @Query(value = "SELECT * FROM order_details WHERE shop_id=?1 AND owner_id=?2 ORDER BY order_details_id DESC", nativeQuery = true)
  List<order_details> salesReportAll(Long shopId, Long ownerId);


  @Query("SELECT o FROM order_details o WHERE o.shop_id = :shopId AND o.owner_id = :ownerId AND o.product_order_date >= :fromDate ORDER BY o.order_details_id DESC")
  List<order_details> salesReportWeekly(@Param("shopId") Long shopId, @Param("ownerId") Long ownerId, @Param("fromDate") String fromDate);


  @Query(value = "SELECT o FROM order_details o WHERE o.shop_id = :shopId AND o.owner_id = :ownerId AND o.product_order_date = :currentDate ORDER BY o.order_details_id DESC")
  List<order_details> salesReportDayly(@Param("shopId") Long shopId, @Param("ownerId") Long ownerId, @Param("currentDate") String currentDate);

}
