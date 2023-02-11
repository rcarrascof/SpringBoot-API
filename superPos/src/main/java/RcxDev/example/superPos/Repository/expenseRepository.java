package RcxDev.example.superPos.Repository;

import RcxDev.example.superPos.Dto.ExpensesReportDTO;
import RcxDev.example.superPos.Dto.IExpense;
import RcxDev.example.superPos.Entities.expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface expenseRepository  extends JpaRepository<expense, Long> {
    @Query("SELECT e FROM expense e WHERE e.shop_id = ?1 AND e.owner_id = ?2 ORDER BY e.expense_id DESC")
    List<expense> getExpense(Long shopId, Long ownerId);

    @Query("SELECT e FROM expense e WHERE e.shop_id = ?1 AND e.owner_id = ?2 AND (e.expense_name LIKE %?3% OR e.expense_note LIKE %?3%)")
    List<expense> getExpense(Long shopId, Long ownerId, String searchText);

    @Query("SELECT SUM(e.expense_amount) AS total FROM expense e WHERE e.shop_id=?1 AND e.expense_date=?2")
    IExpense ExpenseReportDaily(Long shopId, String currentDate);
    @Query(value = "SELECT SUM(e.expense_amount) AS total FROM expense e WHERE e.shop_id=?1 AND MONTH(STR_TO_DATE(expense_date, '%Y-%m-%d')) = MONTH(NOW()) ",nativeQuery = true)
    IExpense ExpenseReportMonthly(Long shopId);
    @Query(value = "SELECT SUM(e.expense_amount) AS total FROM expense e WHERE e.shop_id=?1 AND  YEAR(STR_TO_DATE(e.expense_date, '%Y-%m-%d')) = YEAR(NOW()) ",nativeQuery = true)
    IExpense ExpenseReportYearly(Long shopId);
    @Query("SELECT SUM(e.expense_amount) AS total FROM expense e WHERE e.shop_id=?1 ")
    IExpense getExpenseReportAll(Long shopId);
    @Query(value = "SELECT SUM(e.expense_amount) AS total FROM expense e WHERE e.shop_id=?1 AND expense_date>=?2 AND NOW() ",nativeQuery = true)
    IExpense ExpenseReportWeekly(Long shopId, String fromDate);



    ///EXPENSE ALL REPORT

    @Query("SELECT e  FROM expense e WHERE e.shop_id=?1 AND e.expense_date=?2")
    List<expense> ExpenseAllReportDaily(Long shopId, String currentDate);
    @Query(value = "SELECT * FROM expense e WHERE e.shop_id=?1 AND MONTH(STR_TO_DATE(e.expense_date, '%Y-%m-%d')) = MONTH(NOW()) ",nativeQuery = true)
    List<expense> ExpenseAllReportMonthly(Long shopId);
    @Query(value = "SELECT * FROM expense e WHERE e.shop_id=?1 AND YEAR(STR_TO_DATE(e.expense_date, '%Y-%m-%d')) = YEAR(NOW()) ",nativeQuery = true)
    List<expense> ExpenseAllReportYearly(Long shopId);
    @Query("SELECT e  FROM expense e WHERE e.shop_id=?1 ")
    List<expense> getAllExpenseReport(Long shopId);
    @Query(value = "SELECT * FROM expense e WHERE e.shop_id=?1 AND e.expense_date>=?2 AND NOW() ",nativeQuery = true)
    List<expense> ExpenseAllReportWeekly(Long shopId, String fromDate);
}
