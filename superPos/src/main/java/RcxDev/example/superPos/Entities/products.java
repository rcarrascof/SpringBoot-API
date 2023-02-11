package RcxDev.example.superPos.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    private String product_name;
    private String product_code;
    private Long product_category_id;
   // private String product_category_name;
    @Column(insertable=false, updatable=false)
    private Integer product_weight_unit_id;
    private String product_description;
    private Double product_sell_price;
    private Double product_weight;
    private String product_image;
    private Integer product_stock;
    private Long shop_id;
    private Long owner_id;
    private BigDecimal tax;
    private Long product_supplier_id;

    @OneToOne
    @JoinColumn(name = "product_weight_unit_id", referencedColumnName = "weight_unit_id")
    @JsonIgnore
    private weight_unit weightUnit;

    @Transient
    public String getWeight_unit_name() {
        return weightUnit.getWeight_unit_name();
    }
    @Transient
    public Integer getWeight_unit_id() {
        return weightUnit.getWeight_unit_id();
    }



}
