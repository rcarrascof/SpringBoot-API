package RcxDev.example.superPos.Dto;

import lombok.Data;

@Data
public class CustomerDto extends BaseDTO {

    private String name;
    private String customer_cell;
    private String customer_address;
    private String customer_email;

}

