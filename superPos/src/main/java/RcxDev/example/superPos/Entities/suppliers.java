package RcxDev.example.superPos.Entities;

import jakarta.persistence.*;
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
public class suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suppliers_id;
    private String suppliers_name;
    private String suppliers_contact_person;
    private String suppliers_cell;
    private String suppliers_address;
    private String suppliers_email;
    private Long shop_id;
    private Long owner_id;

}
