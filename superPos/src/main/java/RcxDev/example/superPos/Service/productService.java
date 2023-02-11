package RcxDev.example.superPos.Service;

import RcxDev.example.superPos.Dto.CustomerDto;
import RcxDev.example.superPos.Dto.ProductDto;
import RcxDev.example.superPos.Entities.customers;
import RcxDev.example.superPos.Entities.products;
import RcxDev.example.superPos.Entities.vw_products;
import RcxDev.example.superPos.Repository.productRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class productService {

private final productRepository repository;

    public ProductDto updateProduct(ProductDto item, MultipartFile file) throws IOException {
        String fileName =file.getOriginalFilename();
        if (file!=null && !file.isEmpty()) {
            String filePath = "C:/Users/Reinold Carrasco/Documents/Images/" + file.getOriginalFilename();
            File directory = new File("C:/Users/Reinold Carrasco/Documents/Images/");
            if (!directory.exists()) {
                directory.mkdir();
            }
            // Crear un archivo en el sistema de archivos en la ruta especificada
            File dest = new File(filePath);

            // Guardar el archivo en el sistema de archivos
            file.transferTo(dest);
        }


        ProductDto dto=new ProductDto();
        if(item.getProduct_name().isEmpty()){
            throw new  IllegalStateException("'Please fill in all data!';");
        }
        products pr = repository.findById(item.getProduct_id())
                .orElseThrow(() -> new IllegalStateException(("Product with Id"+item.getProduct_id()+"Does not Exist" )));
        pr.setProduct_name(item.getProduct_name());
        pr.setProduct_code(item.getProduct_code());
        pr.setProduct_category_id(item.getCategory_id());
        pr.setProduct_description(item.getProduct_description());
        pr.setProduct_sell_price(item.getProduct_sell_price());
        pr.setProduct_weight(item.getProduct_weight());
        pr.setProduct_weight_unit_id(item.getProduct_weight_unit_id());
        pr.setProduct_supplier_id(item.getProduct_supplier());
        pr.setProduct_image(fileName.isEmpty()?  pr.getProduct_image():fileName);
        pr.setProduct_stock(item.getProduct_stock());
        pr.setTax(item.getTax());


        repository.save(pr);
        dto.setValue("success");

        return dto;
    }

    public List<products> getProducts(String search_text, Long shop_id, Long owner_id){
        if(search_text.length()>1){
            return repository.getProducts(shop_id,owner_id,search_text);
        }
        var list = repository.getProducts(shop_id,owner_id);
        return repository.getProducts(shop_id,owner_id);
    }

    public List<vw_products> getProductById(Long productId, Long shopId) {

        return repository.getProductsById(productId,shopId);
    }

    public ProductDto addProduct(ProductDto item, MultipartFile file) throws IOException {
        String fileName =file.getOriginalFilename();
        if (file!=null && !file.isEmpty()) {
            String filePath = "C:/Users/Reinold Carrasco/Documents/Images/" + file.getOriginalFilename();
            File directory = new File("C:/Users/Reinold Carrasco/Documents/Images/");
            if (!directory.exists()) {
                directory.mkdir();
            }
            // Crear un archivo en el sistema de archivos en la ruta especificada
            File dest = new File(filePath);

            // Guardar el archivo en el sistema de archivos
            file.transferTo(dest);
        }


        ProductDto dto=new ProductDto();
        if(item.getProduct_name().isEmpty()){
            throw new  IllegalStateException("'Please fill in all data!';");
        }
        products pr = new products();
        pr.setProduct_name(item.getProduct_name());
        pr.setProduct_code(item.getProduct_code());
        pr.setProduct_category_id(item.getCategory_id());
        pr.setProduct_description(item.getProduct_description());
        pr.setProduct_sell_price(item.getProduct_sell_price());
        pr.setProduct_weight(item.getProduct_weight());
        pr.setProduct_weight_unit_id(item.getProduct_weight_unit_id());
        pr.setProduct_supplier_id(item.getProduct_supplier());
        pr.setProduct_image(fileName.isEmpty()?  pr.getProduct_image():fileName);
        pr.setProduct_stock(item.getProduct_stock());
        pr.setShop_id(item.getShop_id());
        pr.setOwner_id(item.getOwner_id());
        pr.setTax(item.getTax());


        repository.save(pr);
        dto.setValue("success");

        return dto;
    }

}
