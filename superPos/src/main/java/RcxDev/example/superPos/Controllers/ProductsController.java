package RcxDev.example.superPos.Controllers;

import RcxDev.example.superPos.Dto.ProductDto;
import RcxDev.example.superPos.Entities.product_category;
import RcxDev.example.superPos.Entities.products;
import RcxDev.example.superPos.Entities.vw_products;
import RcxDev.example.superPos.Entities.weight_unit;
import RcxDev.example.superPos.Service.categoryService;
import RcxDev.example.superPos.Service.productService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path ="api/v1/products" )
@AllArgsConstructor
public class ProductsController {
    private final productService service;
    private final categoryService categoryService;
    private final RcxDev.example.superPos.Service.weightUnitsService weightUnitsService;

    @GetMapping()
    public List<products> getProducts(@RequestParam String search_text, Long shop_id, Long owner_id ){
        return service.getProducts(search_text,shop_id,owner_id);
    }

    @GetMapping(path ="/Detail")
    public List<vw_products> getProductById(@RequestParam Long product_id, Long shop_id ){
        return service.getProductById(product_id,shop_id);
    }

    @PostMapping("/update")
    public ProductDto updateProduct(@RequestParam(value = "file", required = false) MultipartFile file,
                                                    @RequestParam(value="name", required = false) String name,
                                                    @RequestParam("product_name") String productName,
                                                    @RequestParam("product_code") String productCode,
                                                    @RequestParam("category_id") Long categoryId,
                                                    @RequestParam("product_description") String description,
                                                    @RequestParam("product_sell_price") Double sellPrice,
                                                    @RequestParam("product_weight") Double weight,
                                                    @RequestParam("product_weight_unit_id") Integer weightUnitId,
                                                    @RequestParam("suppliers_id") Long supplierId,
                                                    @RequestParam("product_stock") Integer stock,
                                                    @RequestParam("product_id") Long product_id,
                                                    @RequestParam("tax") BigDecimal tax) throws IOException {

        ProductDto product = new ProductDto();
        product.setFile(name);
        product.setProduct_name(productName);
        product.setProduct_code(productCode);
        product.setCategory_id(categoryId);
        product.setProduct_description(description);
        product.setProduct_sell_price(sellPrice);
        product.setProduct_weight(weight);
        product.setProduct_weight_unit_id(weightUnitId);
        product.setProduct_supplier(supplierId);
        product.setProduct_stock(stock);
        product.setProduct_id(product_id);
        product.setTax(tax);

     //   ProductDto updatedProduct = service.updateProduct(product, file);
        return  service.updateProduct(product, file);
    }


    @PostMapping()
    public ProductDto addProduct(@RequestParam(value = "file", required = false) MultipartFile file,
                                    @RequestParam(value="name", required = false) String name,
                                    @RequestParam("product_name") String productName,
                                    @RequestParam("product_code") String productCode,
                                    @RequestParam("category_id") Long categoryId,
                                    @RequestParam("product_description") String description,
                                    @RequestParam("product_sell_price") Double sellPrice,
                                    @RequestParam("product_weight") Double weight,
                                    @RequestParam("product_weight_unit_id") Integer weightUnitId,
                                    @RequestParam("suppliers_id") Long supplierId,
                                    @RequestParam("product_stock") Integer stock,
                                     @RequestParam("shop_id") Long shop_id,
                                    @RequestParam("owner_id") Long owner_id,
                                 @RequestParam("tax") BigDecimal tax) throws IOException {

        ProductDto product = new ProductDto();
        product.setFile(name);
        product.setProduct_name(productName);
        product.setProduct_code(productCode);
        product.setCategory_id(categoryId);
        product.setProduct_description(description);
        product.setProduct_sell_price(sellPrice);
        product.setProduct_weight(weight);
        product.setProduct_weight_unit_id(weightUnitId);
        product.setProduct_supplier(supplierId);
        product.setProduct_stock(stock);
        product.setShop_id(shop_id);
        product.setOwner_id(owner_id);
        product.setTax(tax);

        //   ProductDto updatedProduct = service.updateProduct(product, file);
        return  service.addProduct(product, file);
    }


    @GetMapping("/Categories")
    public List<product_category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/weightUnit")
    public List<weight_unit> getWeightUnits(@RequestParam String search_text){
        return weightUnitsService.getWeightUnits(search_text);
    }
}
