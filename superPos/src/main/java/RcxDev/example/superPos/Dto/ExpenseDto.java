package RcxDev.example.superPos.Dto;

import lombok.Data;

@Data
public class ExpenseDto extends BaseDTO {

    private String expense_name;
    private String expense_note;
    private Double expense_amount;
    private String expense_date;
    private String expense_time;
}
