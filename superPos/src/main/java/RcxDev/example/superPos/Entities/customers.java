package RcxDev.example.superPos.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class customers {

@Id
    private long customer_id;
    @JsonProperty("name")
    private String customer_name;
    private String customer_cell;
    private String customer_address;
    private String customer_email;
    private  long owner_id;
    private long shop_id;




}
