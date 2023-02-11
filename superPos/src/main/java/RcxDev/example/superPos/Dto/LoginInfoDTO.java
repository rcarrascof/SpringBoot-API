package RcxDev.example.superPos.Dto;

import lombok.Data;

@Data
public class LoginInfoDTO extends BaseDTO {

    //User info

    private String name;
    private Long id;
    private String user_type;
    //Shop Info
    private Long shop_id;
    private String shop_name;
    private Double tax;
    private String currency_symbol;
    private String shop_status;

    private String shop_contact;
    private String shop_email;
    private String shop_address;
}
