package RcxDev.example.superPos.Service;

import RcxDev.example.superPos.Dto.*;
import RcxDev.example.superPos.Entities.customers;
import RcxDev.example.superPos.Entities.expense;
import RcxDev.example.superPos.Entities.suppliers;
import RcxDev.example.superPos.Repository.expenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class expenseService {

    private final expenseRepository repository;

    public List<expense> getAllExpenses(String searchText, Long shopId, Long ownerId) {
        if(searchText.length()>1){
            return repository.getExpense(shopId,ownerId,searchText);
        }

        return repository.getExpense(shopId,ownerId);
    }

    public ExpenseDto addExpense(ExpenseDto dto) {
        expense expense = new expense();
        if(dto.getExpense_name().isEmpty()){

            throw new IllegalStateException("Please fill in all data!");
        }
        else
        {
            expense.setExpense_name(dto.getExpense_name());
            expense.setExpense_amount(dto.getExpense_amount());
            expense.setExpense_note(dto.getExpense_note());
            expense.setExpense_date(dto.getExpense_date());
            expense.setExpense_time(dto.getExpense_time());
            expense.setOwner_id(dto.getOwner_id());
            expense.setShop_id(dto.getShop_id());

            repository.save(expense);
            dto.setValue("success");
            return dto;
        }

    }

    public ExpenseDto updateExpense(Long expenseId, String expenseName, String expenseNote, Double expenseAmount, String expenseDate, String expenseTime) {
        ExpenseDto dto=new ExpenseDto();
        if(expenseName.isEmpty()){
            throw new  IllegalStateException("'Please fill in all data!';");
        }
        expense expense = repository.findById(expenseId)
                .orElseThrow(() -> new IllegalStateException(("Expense with Id"+expenseId+"Does not Exist" )));
        expense.setExpense_name(expenseName);
        expense.setExpense_note(expenseNote);
        expense.setExpense_amount(expenseAmount);
        expense.setExpense_date(expenseDate);
        expense.setExpense_time(expenseTime);



        repository.save(expense);
        dto.setValue("success");

        return dto;


    }

    public ExpenseDto deleteExpense(Long id) {

        ExpenseDto dto = new ExpenseDto();
            boolean exists= repository.existsById(id);
            if(!exists){
                throw new IllegalStateException("Expense with Id"+id+" does not exist");
            }
            repository.deleteById(id);
            exists= repository.existsById(id);
            if(exists){
                dto.setValue("failure");
            }
            dto.setValue("success");
            return dto;

    }

    public ExpensesReportDTO getExpensesReport(String type, Long shopId, Long ownerId) {

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String current_date = dateFormat.format(new Date());

            IExpense result = repository.ExpenseReportDaily(shopId, current_date);
            ExpensesReportDTO reportDTOS = new ExpensesReportDTO();
            if (type.equalsIgnoreCase("monthly")) {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String month = sdf.format(cal.getTime());
                result = repository.ExpenseReportMonthly(shopId);
            } else if (type.equalsIgnoreCase("yearly")) {
                result = repository.ExpenseReportYearly(shopId);

            } else if (type.equalsIgnoreCase("all")) {
                result = repository.getExpenseReportAll(shopId);

            } else if (type.equalsIgnoreCase("weekly")) {
                String fromDate = LocalDate.now().minusDays(7).toString();
                result = repository.ExpenseReportWeekly(shopId, fromDate);

            } else {
                result = repository.ExpenseReportDaily(shopId, current_date);

            }

            reportDTOS.setTotal_expense_price(result.gettotal());


            return reportDTOS;



    }

    public List<expense> getAllExpensesReport(String type, Long shopId, Long ownerId) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String current_date = dateFormat.format(new Date());

        if (type.equalsIgnoreCase("monthly")) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String month = sdf.format(cal.getTime());
            return repository.ExpenseAllReportMonthly(shopId);
        } else if (type.equalsIgnoreCase("yearly")) {
            return  repository.ExpenseAllReportYearly(shopId);

        } else if (type.equalsIgnoreCase("all")) {
            return repository.getAllExpenseReport(shopId);

        } else if (type.equalsIgnoreCase("weekly")) {
            String fromDate = LocalDate.now().minusDays(7).toString();
            return repository.ExpenseAllReportWeekly(shopId, fromDate);

        } else {
            return repository.ExpenseAllReportDaily(shopId, current_date);

        }

    }
}
