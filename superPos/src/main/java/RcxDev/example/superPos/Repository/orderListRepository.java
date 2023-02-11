package RcxDev.example.superPos.Repository;

import RcxDev.example.superPos.Dto.OrderListSumDTO;
import RcxDev.example.superPos.Entities.order_list;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface orderListRepository extends JpaRepository<order_list, Long> {

    @Query("SELECT l FROM order_list l WHERE l.shop_id=?2 AND l.owner_id=?1 AND (l.invoice_id LIKE %?1% OR l.order_type LIKE %?1% OR l.order_payment_method LIKE %?1% OR l.customer_name LIKE %?1%) ")
    List<order_list> getOrders(String searchText, Long shopId, Long ownerId);


    @Query("SELECT l FROM order_list l WHERE l.shop_id=?1 AND l.owner_id=?2 ORDER BY l.order_id DESC")
    List<order_list> getOrders(Long shopId, Long ownerId);




    @Modifying
    @Transactional
    @Query("DELETE FROM order_list o WHERE o.invoice_id = :invoiceId")
    void deleteOrderListByInvoiceId(@Param("invoiceId") String invoiceId);

    @Modifying
    @Transactional
    @Query("DELETE FROM order_details o WHERE o.invoice_id = :invoiceId")
    void deleteOrderDetailByInvoiceId(@Param("invoiceId") String invoiceId);





    //Reports

    @Query(value = "SELECT  SUM(ol.order_price) AS order_price, SUM(ol.discount)  AS discount,  SUM(ol.tax) AS tax FROM order_list ol WHERE ol.shop_id = :shop_id AND MONTH(ol.order_date) = MONTH(CURRENT_DATE())",nativeQuery = true)
    OrderListSumDTO salesReportMonthly(@Param("shop_id") Long shopId);

    @Query(value = "SELECT  SUM(ol.order_price) AS order_price, SUM(ol.discount)  AS discount,  SUM(ol.tax) AS tax FROM order_list ol WHERE ol.shop_id = :shop_id AND ol.owner_id = :owner_id AND YEAR(STR_TO_DATE(ol.order_date, '%Y-%m-%d')) = YEAR(NOW()) ORDER BY ol.order_id DESC",nativeQuery = true)
    OrderListSumDTO salesReportYearly(@Param("shop_id") Long shop_id, @Param("owner_id") Long owner_id);

    @Query("SELECT  SUM(ol.order_price) AS order_price, SUM(ol.discount)  AS discount,  SUM(ol.tax) AS tax FROM order_list ol  WHERE ol.shop_id = :shop_id  AND ol.order_date >= :fromDate ORDER BY ol.order_id DESC ")
    OrderListSumDTO salesReportWeekly(@Param("shop_id") Long shop_id, @Param("fromDate") String fromDate);

    @Query("SELECT  SUM(ol.order_price) AS order_price, SUM(ol.discount)  AS discount,  SUM(ol.tax) AS tax FROM order_list ol WHERE ol.shop_id = :shop_id AND ol.order_date = :currentDate ORDER BY ol.order_id DESC ")
    OrderListSumDTO salesReportDaily(@Param("shop_id") Long shop_id, @Param("currentDate") String current_date);



    @Query("SELECT  SUM(ol.order_price) AS order_price, SUM(ol.discount)  AS discount,  SUM(ol.tax) AS tax FROM order_list ol WHERE ol.shop_id = :shop_id AND ol.owner_id = :owner_id")
    OrderListSumDTO getsalesReportAll(@Param("shop_id") Long shop_id, @Param("owner_id") Long owner_id);






}
