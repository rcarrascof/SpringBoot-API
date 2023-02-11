package RcxDev.example.superPos.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.awt.*;
import java.util.Date;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expense_id;
    private String expense_name;
    private String expense_note;
    private Double expense_amount;
    private String expense_date;
    private String expense_time;
    private Long shop_id;
    private Long owner_id;
}
