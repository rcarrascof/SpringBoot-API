package RcxDev.example.superPos.Repository;

import RcxDev.example.superPos.Entities.customers;
import RcxDev.example.superPos.Entities.product_category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends JpaRepository<product_category, Long> {
}
