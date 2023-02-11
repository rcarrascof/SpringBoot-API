package RcxDev.example.superPos.Controllers;

import RcxDev.example.superPos.Dto.CustomerDto;
import RcxDev.example.superPos.Dto.SupplierDto;
import RcxDev.example.superPos.Entities.customers;
import RcxDev.example.superPos.Entities.suppliers;
import RcxDev.example.superPos.Service.suppierService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/Suppliers" )
@AllArgsConstructor
public class SuppliersController {
    private  final suppierService service;

    @GetMapping()
    public List<suppliers> getSuppliers(@RequestParam String search_text, Long shop_id, Long owner_id ){
        return service.getSuppliers(search_text,shop_id,owner_id);
    }

    @PostMapping
    public SupplierDto addSuppliers(@RequestBody SupplierDto supplierDto){

        return service.addSuppliers(supplierDto);
    }

    @PutMapping
    public SupplierDto updateSuppliers (@RequestParam Long suppliers_id, String suppliers_name, String suppliers_contact_person, String suppliers_cell, String suppliers_email,String suppliers_address){

        return service.updateSuppliers(suppliers_id,suppliers_name,suppliers_contact_person,suppliers_cell,suppliers_email,suppliers_address);
    }

    @DeleteMapping()
    public SupplierDto deleteSupplier(@RequestParam("suppliers_id") Long id){
        return service.deleteSupplier(id);
    }
}
