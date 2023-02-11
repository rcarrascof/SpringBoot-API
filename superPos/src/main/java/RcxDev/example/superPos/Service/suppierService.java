package RcxDev.example.superPos.Service;

import RcxDev.example.superPos.Dto.CustomerDto;
import RcxDev.example.superPos.Dto.SupplierDto;
import RcxDev.example.superPos.Entities.customers;
import RcxDev.example.superPos.Entities.suppliers;
import RcxDev.example.superPos.Repository.supplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class suppierService {
    private final supplierRepository repository;


    public List<suppliers> getSuppliers(String searchText, Long shopId, Long ownerId) {
        if(searchText.length()>1){
            return repository.getSuppliers(shopId,ownerId,searchText);
        }

        return repository.getSuppliers(shopId,ownerId);
    }

    public SupplierDto addSuppliers(SupplierDto dto) {
        suppliers suppliers = new suppliers();
        if(dto.getSuppliers_name().isEmpty() || dto.getSuppliers_cell().isEmpty()){

            throw new IllegalStateException("Please fill in all data!");
        }
        else
        {
            suppliers.setSuppliers_name(dto.getSuppliers_name());
            suppliers.setSuppliers_cell(dto.getSuppliers_cell());
            suppliers.setSuppliers_contact_person(dto.getSuppliers_contact_person());
            suppliers.setSuppliers_address(dto.getSuppliers_address());
            suppliers.setSuppliers_email(dto.getSuppliers_email());
            suppliers.setOwner_id(dto.getOwner_id());
            suppliers.setShop_id(dto.getShop_id());

            repository.save(suppliers);
            dto.setValue("success");
            return dto;
        }

    }

    public SupplierDto deleteSupplier(Long id) {
        SupplierDto dto = new SupplierDto();
        boolean exists= repository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Supplier with Id"+id+" does not exist");
        }
        repository.deleteById(id);
        exists= repository.existsById(id);
        if(exists){
            dto.setValue("failure");
        }
        dto.setValue("success");
        return dto;
    }

    public SupplierDto updateSuppliers(Long suppliersId, String suppliersName, String suppliersContactPerson, String suppliersCell, String suppliersEmail, String suppliersAddress) {
        SupplierDto dto=new SupplierDto();
        if(suppliersName.isEmpty() || suppliersCell.isEmpty()){
            throw new  IllegalStateException("'Please fill in all data!';");
        }
        suppliers suppliers = repository .findById(suppliersId)
                .orElseThrow(() -> new IllegalStateException(("Customer with Id"+suppliersId+"Does not Exist" )));
        suppliers.setSuppliers_name(suppliersName);
        suppliers.setSuppliers_cell(suppliersCell);
        suppliers.setSuppliers_email(suppliersEmail);
        suppliers.setSuppliers_address(suppliersAddress);
        suppliers.setSuppliers_contact_person(suppliersContactPerson);


        repository.save(suppliers);
        dto.setValue("success");

        return dto;
    }
}
