package RcxDev.example.superPos.Service;

import RcxDev.example.superPos.Dto.*;
import RcxDev.example.superPos.Entities.order_details;
import RcxDev.example.superPos.Entities.order_list;
import RcxDev.example.superPos.Entities.products;
import RcxDev.example.superPos.Repository.orderDetailRepository;
import RcxDev.example.superPos.Repository.orderListRepository;
import RcxDev.example.superPos.Repository.productRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class orderService {

    private final orderListRepository repository;
    private final orderDetailRepository detailRepository;
    private final productRepository productRepository;

    public List<order_list> orderLists(String search_text, Long shop_id, Long owner_id){
        if(search_text.length()>1){
            repository.getOrders(search_text,shop_id,owner_id);
        }
        return repository.getOrders(shop_id,owner_id);
    }


    public List<order_details> OrderDetail(String invoice_id){
        var list = detailRepository.OrderDetailsByInvoice(invoice_id);
        return detailRepository.OrderDetailsByInvoice(invoice_id);
    }

    public order_list orderSubmit(OrderListDTO ordersData) {
        if (ordersData == null || ordersData.getInvoice_id() == null || ordersData.getLines().isEmpty()) {
            throw new IllegalArgumentException("Orders data is invalid.");
        }

        try {
            order_list orderList = new order_list();
            orderList.setInvoice_id(ordersData.getInvoice_id());
            orderList.setOrder_time(ordersData.getOrder_time());
            orderList.setOrder_type(ordersData.getOrder_type());
            orderList.setOrder_price(ordersData.getOrder_price());
            orderList.setOrder_payment_method(ordersData.getOrder_payment_method());
            orderList.setDiscount(ordersData.getDiscount());
            orderList.setTax(ordersData.getTax());
            orderList.setCustomer_name(ordersData.getCustomer_name());
            orderList.setServedBy(ordersData.getServed_by());
            orderList.setShop_id(ordersData.getShop_id());
            orderList.setOwner_id(ordersData.getOwner_id());
            orderList.setOrder_date(ordersData.getOrder_date());
            repository.save(orderList);

            List<order_details> orderDetails = ordersData.getLines().stream()
                    .map(line -> {
                        order_details orderLine = new order_details();
                     //   orderLine.setOrder_details_id(orderList.getOrder_id());
                        orderLine.setProduct_id(line.getProduct_id());
                        orderLine.setInvoice_id(ordersData.getInvoice_id());
                        orderLine.setProduct_name(line.getProduct_name());
                        orderLine.setProduct_quantity(line.getProduct_qty());
                        orderLine.setProduct_weight(line.getProduct_weight());
                        orderLine.setProduct_price(line.getProduct_price());
                        orderLine.setProduct_order_date(line.getProduct_order_date());
                        orderLine.setProduct_image(line.getProduct_image());
                        orderLine.setShop_id(ordersData.getShop_id());
                        orderLine.setOwner_id(ordersData.getOwner_id());
                        orderLine.setTax(line.getTax());
                        return orderLine;
                    })
                    .collect(Collectors.toList());
            detailRepository.saveAll(orderDetails);
            orderList.setDetails(orderDetails);
            List<products> products = orderDetails.stream()
                    .map(line -> {
                        products product = productRepository.getProductStock(line.getProduct_id());
                        product.setProduct_stock(product.getProduct_stock() - line.getProduct_quantity());
                        return product;
                    })
                    .collect(Collectors.toList());
            productRepository.saveAll(products);

            return orderList;
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException(e);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    /*public order_list orderSubmit(OrderListDTO ordersData) {
        if (ordersData == null || ordersData.getInvoice_id() == null || ordersData.getLines().isEmpty()) {
            throw new IllegalArgumentException("Orders data is invalid.");
        }
        order_list orderList = new order_list();
       // List<order_details> object = new ArrayList<>();

        try{


        orderList.setInvoice_id(ordersData.getInvoice_id());
        orderList.setOrder_time(ordersData.getOrder_time());
        orderList.setOrder_type(ordersData.getOrder_type());
        orderList.setOrder_price(ordersData.getOrder_price());
        orderList.setOrder_payment_method(ordersData.getOrder_payment_method());
        orderList.setDiscount(ordersData.getDiscount());
        orderList.setTax(ordersData.getTax());
        orderList.setCustomer_name(ordersData.getCustomer_name());
        orderList.setServedBy(ordersData.getServed_by());
        orderList.setShop_id(ordersData.getShop_id());
        orderList.setOwner_id(ordersData.getOwner_id());
        orderList.setOrder_date(ordersData.getOrder_date());
        repository.save(orderList);
        for (OrderDetailDTO line : ordersData.getLines()) {
            order_details orderLine = new order_details();
            orderLine.setOrder_details_id(orderList.getOrder_id());
            orderLine.setProduct_id(line.getProduct_id());
            orderLine.setInvoice_id(ordersData.getInvoice_id());
            orderLine.setProduct_name(line.getProduct_name());
            orderLine.setProduct_quantity(line.getProduct_qty());
            orderLine.setProduct_weight(line.getProduct_weight());
            orderLine.setProduct_price(line.getProduct_price());
            orderLine.setProduct_order_date(line.getProduct_order_date());
            orderLine.setProduct_image(line.getProduct_image());
            orderLine.setShop_id(ordersData.getShop_id());
            orderLine.setOwner_id(ordersData.getOwner_id());
            orderLine.setTax(line.getTax());
            detailRepository.save(orderLine);
     //       object.add(orderLine);
           var product = productRepository.getProductStock(line.getProduct_id());
           var stock =product.getProduct_stock()-line.getProduct_qty();
            product.setProduct_stock(stock);
            productRepository.save(product);
        }

        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException(e);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
       /// orderList.setDetails(object);
        return orderList;


    }*/

    public boolean deleteByInvoiceId(String invoiceId) {
        try {
            repository.deleteOrderListByInvoiceId(invoiceId);
            repository.deleteOrderDetailByInvoiceId(invoiceId);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting order: " + e.getMessage());
        }

    }

    public List<order_details> salesReportList(String type, Long shopId, Long ownerId, String yearly) {
        List<order_details> result= new ArrayList<>();
        if(type.equalsIgnoreCase("monthly")){
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String month = sdf.format(cal.getTime());
            result=  detailRepository.salesReportMonthly(shopId,ownerId,month);
        }else if(type.equalsIgnoreCase("yearly")){
            result= detailRepository.salesReportYearly(shopId,ownerId);

        } else if(type.equalsIgnoreCase("all")) {
            result= detailRepository.salesReportAll(shopId,ownerId);

        }else if(type.equalsIgnoreCase("weekly")) {
            String fromDate = LocalDate.now().minusDays(7).toString();
            result =detailRepository.salesReportWeekly(shopId,ownerId,fromDate);

        }
        else{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String current_date = dateFormat.format(new Date());
            result= detailRepository.salesReportDayly(shopId,ownerId,current_date);

        }
        return result;
    }
    public ReportDTO salesReportList(String type, Long shopId, Long ownerId, String yearly, boolean totales) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String current_date = dateFormat.format(new Date());

        OrderListSumDTO result = repository.salesReportDaily(shopId,current_date);
        ReportDTO reportDTOS  = new ReportDTO();
        if(type.equalsIgnoreCase("monthly")){
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String month = sdf.format(cal.getTime());
            result=  repository.salesReportMonthly(shopId);
        }else if(type.equalsIgnoreCase("yearly")){
            result= repository.salesReportYearly(shopId,ownerId);

        } else if(type.equalsIgnoreCase("all")) {
            result= repository.getsalesReportAll(shopId,ownerId);

        }else if(type.equalsIgnoreCase("weekly")) {
            String fromDate = LocalDate.now().minusDays(7).toString();
            result =repository.salesReportWeekly(shopId,fromDate);

        }
        else{
            result= repository.salesReportDaily(shopId, current_date);

        }

        reportDTOS.setTotal_discount(result.getDiscount());
        reportDTOS.setTotal_order_price(result.getorder_price());
        reportDTOS.setTotal_tax(result.getTax());


        return reportDTOS;


    }

    public ReportDTO getsalesReportList(String type, Long shopId, Long ownerId, String yearly, boolean totales){
        ReportDTO reportDTO= new ReportDTO();
        var result = repository.getsalesReportAll(shopId,ownerId);
        reportDTO.setTotal_discount(result.getDiscount());
        reportDTO.setTotal_order_price(result.getorder_price());
        reportDTO.setTotal_tax(result.getTax());

        return reportDTO;
    }

}
