package RcxDev.example.superPos.Dto;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class ProductDto extends BaseDTO {

    private String file;
    private Long product_id;
    private String product_name;
    private String product_code;
    private Long category_id;
    private Integer product_weight_unit_id;
    private String product_weight_unit;
    private String product_description;
    private Double product_sell_price;
    private Double product_weight;
    private String weight_unit_name;
    private String product_image;
    private int product_stock;
    private Long shop_id;
    private Long owner_id;
    private BigDecimal tax;
    private Double product_price;

    private Integer product_qty;
    private Long product_supplier;

    private String product_category_name;
    private String suppliers_name;
}