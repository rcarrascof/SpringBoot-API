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
public class shop {
    @Id
    private Long shop_id;
    private String shop_name;
    private String shop_contact;
    private String shop_email;
    private String shop_address;
    private String currency_symbol;
    private String shop_status;

}
