package RcxDev.example.superPos.Controllers;

import RcxDev.example.superPos.Dto.CustomerDto;
import RcxDev.example.superPos.Dto.ExpenseDto;
import RcxDev.example.superPos.Dto.ExpensesReportDTO;
import RcxDev.example.superPos.Dto.ReportDTO;
import RcxDev.example.superPos.Entities.customers;
import RcxDev.example.superPos.Entities.expense;
import RcxDev.example.superPos.Entities.product_category;
import RcxDev.example.superPos.Service.categoryService;
import RcxDev.example.superPos.Service.expenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path ="api/v1/Expenses" )
@AllArgsConstructor
public class ExpensesController {

    private final expenseService service;


    @GetMapping()
    public List<expense> getExpenses(@RequestParam String search_text, Long shop_id, Long owner_id){
        return service.getAllExpenses(search_text,shop_id,owner_id);
    }

    @GetMapping("reportAll")
    public List<expense> getAllExpensesReport(@RequestParam String type, Long shop_id, Long owner_id){
        return service.getAllExpensesReport(type,shop_id,owner_id);
    }

    @PostMapping()
    public ExpenseDto addExpense(@RequestParam(value = "expense_name") String name,
                              @RequestParam(value = "expense_amount") Double amount,
                              @RequestParam(value = "expense_note") String note,
                              @RequestParam(value = "expense_date") String date,
                              @RequestParam(value = "expense_time") String time,
                              @RequestParam(value = "shop_id") Long shopId,
                              @RequestParam(value = "owner_id") Long ownerId){

        ExpenseDto expense = new ExpenseDto();
        expense.setExpense_name(name);
        expense.setExpense_amount(amount);
        expense.setExpense_note(note);
        expense.setExpense_date(date);
        expense.setExpense_time(time);
        expense.setShop_id(shopId);
        expense.setOwner_id(ownerId);
        return service.addExpense(expense);



    }

    @DeleteMapping()
    public ExpenseDto deleteExpense(@RequestParam("expense_id") Long id){
        return service.deleteExpense(id);
    }

    @PutMapping
    public ExpenseDto updateExpense (@RequestParam Long expense_id, String expense_name, String expense_note, Double expense_amount, String expense_date,String expense_time){

        return service.updateExpense(expense_id,expense_name,expense_note,expense_amount,expense_date,expense_time);
    }

    @GetMapping("/total")
    public List<ExpensesReportDTO> getAllExpensesReportTotal(@RequestParam String type, Long shop_id, Long owner_id){

        List<ExpensesReportDTO> reportDTOS= new ArrayList<>();
        reportDTOS.add(service.getExpensesReport(type,shop_id,owner_id));
        return reportDTOS;
    }


   /* @PostMapping
    public ExpenseDto addExpense(@RequestBody ExpenseDto expenseDto){

        return service.addExpense(expenseDto);
    }*/
}
