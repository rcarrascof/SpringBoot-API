package RcxDev.example.superPos.Dto;

import RcxDev.example.superPos.Entities.order_details;
import lombok.Data;

import java.util.List;

@Data
public class OrderListDTO {

    private Long order_id;
    private String invoice_id;
    private String order_date;
    private String order_time;
    private String order_type;
    private String order_price;
    private String order_payment_method;
    private String discount;
    private String tax;
    private String customer_name;
    private String served_by;
    private Long shop_id;
    private Long owner_id;
    private List<OrderDetailDTO> lines;


}
