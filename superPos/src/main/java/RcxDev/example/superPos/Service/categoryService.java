package RcxDev.example.superPos.Service;

import RcxDev.example.superPos.Entities.customers;
import RcxDev.example.superPos.Entities.product_category;
import RcxDev.example.superPos.Repository.categoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class categoryService {

    private final categoryRepository repo;


    public List<product_category> getAllCategory(){

        return repo.findAll();
    }
}
