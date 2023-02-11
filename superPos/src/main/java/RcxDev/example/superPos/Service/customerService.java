package RcxDev.example.superPos.Service;

import RcxDev.example.superPos.Dto.CustomerDto;
import RcxDev.example.superPos.Entities.customers;
import RcxDev.example.superPos.Repository.customerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class customerService {

    private  final customerRepository customerRepository;

    public List<customers> getCustomers(String search_text, Long shop_id, Long owner_id){
        if(search_text.length()>1){
           return customerRepository.getCustomers(shop_id,owner_id,search_text);
        }

        return customerRepository.getAllCustomers(shop_id,owner_id);
    }

    public CustomerDto addNewCustomer(CustomerDto dto){
        customers customers = new customers();
        if(dto.getName().isEmpty() || dto.getCustomer_cell().isEmpty()){

        throw new IllegalStateException("Please fill in all data!");
        }
        else
        {
            customers.setCustomer_name(dto.getName());
            customers.setCustomer_cell(dto.getCustomer_cell());
            customers.setCustomer_address(dto.getCustomer_address());
            customers.setCustomer_email(dto.getCustomer_email());
            customers.setOwner_id(dto.getOwner_id());
            customers.setShop_id(dto.getShop_id());

            customerRepository.save(customers);
            dto.setValue("success");
            return dto;
        }

    }

    public CustomerDto updateCustomer(Long customer_id, String customer_name, String customer_cell, String customer_email, String customer_address){
        CustomerDto dto=new CustomerDto();
        if(customer_name.isEmpty() || customer_cell.isEmpty()){
            throw new  IllegalStateException("'Please fill in all data!';");
        }
        customers customer = customerRepository.findById(customer_id)
                .orElseThrow(() -> new IllegalStateException(("Customer with Id"+customer_id+"Does not Exist" )));
        customer.setCustomer_name(customer_name);
        customer.setCustomer_cell(customer_name);
        customer.setCustomer_email(customer_email);
        customer.setCustomer_address(customer_address);


        customerRepository.save(customer);
        dto.setValue("success");

        return dto;
    }


    public CustomerDto deleteCustomer(Long id) {
        CustomerDto dto = new CustomerDto();
        boolean exists= customerRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Customer with Id"+id+" does not exist");
        }
        customerRepository.deleteById(id);
        exists= customerRepository.existsById(id);
        if(exists){
            dto.setValue("failure");
        }
        dto.setValue("success");
        return dto;
    }
}
