package RcxDev.example.superPos.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class order_list {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String servedBy;
    private Long shop_id;
    private Long owner_id;

    @OneToMany
    @JoinColumn(name = "details_order_details_id")
    @Transient
    private List<order_details> details;


}
