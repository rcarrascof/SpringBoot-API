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
public class users {
    @Id
    private Long id;
    private String  name;
    private Long shop_id;
    private Long owner_id;
    private String user_type;
    private String email;
    private String password;

}
