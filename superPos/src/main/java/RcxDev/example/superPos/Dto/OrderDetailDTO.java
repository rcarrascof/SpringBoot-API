package RcxDev.example.superPos.Dto;

import lombok.Data;

import java.util.Date;
@Data
public class OrderDetailDTO extends BaseDTO {

    private String invoice_id;
    private String product_name;
    private Integer product_qty;
    private String product_weight;
    private Double product_price;
    private String product_order_date;
    private String tax;
    private Long product_id;
    private String product_image;

}
