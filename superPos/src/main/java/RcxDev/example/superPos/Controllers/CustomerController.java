package RcxDev.example.superPos.Controllers;

import RcxDev.example.superPos.Dto.CustomerDto;
import RcxDev.example.superPos.Entities.customers;
import RcxDev.example.superPos.Service.customerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/customer" )
@AllArgsConstructor
public class CustomerController {

private  final customerService customerService;


    @GetMapping()
    public List<customers> getCustomers(@RequestParam String search_text,Long shop_id, Long owner_id ){
        return customerService.getCustomers(search_text,shop_id,owner_id);
    }

    @PutMapping
    public CustomerDto UpdateCustomer (@RequestParam Long customer_id, String customer_name, String customer_cell, String customer_email, String customer_address){

        return customerService.updateCustomer(customer_id,customer_name,customer_cell,customer_email,customer_address);
    }
    @PostMapping
    public CustomerDto AddNewCustomer(@RequestBody CustomerDto customers){

        return customerService.addNewCustomer(customers);
    }

    @DeleteMapping()
    public CustomerDto deleteCustomer(@RequestParam("customer_id") Long id){
        return customerService.deleteCustomer(id);
    }



}
