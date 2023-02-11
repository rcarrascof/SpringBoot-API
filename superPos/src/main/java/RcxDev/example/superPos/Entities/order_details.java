package RcxDev.example.superPos.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class order_details{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_details_id;
    private String invoice_id;
    private String product_name;
    private Integer product_quantity;
    private String product_weight;
    private Double product_price;
    private String product_order_date;
    private Long product_id;
    private String product_image;
    private Long shop_id;
    private Long owner_id;

    private String tax;


}
