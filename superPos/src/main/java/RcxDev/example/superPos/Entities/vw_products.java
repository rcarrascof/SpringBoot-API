package RcxDev.example.superPos.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class vw_products {

    @Id
    private Long weight_unit_id;
    private String weight_unit_name;

    private Long product_id;
    private String product_name;
    private String product_code;
    private Long product_category_id;
    private String product_category_name;
    private String suppliers_name;
    private Long product_supplier_id;
    private String product_description;
    private Double product_sell_price;
    private String product_weight;
    private String product_image;
    private Integer product_stock;
    private Double tax;

    private  Long shop_id;


}
