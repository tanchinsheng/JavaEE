package com.cstan.testmart;

import com.cstan.business.ProductServiceImpl;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ProductCatalog {

    ProductServiceImpl productService = new ProductServiceImpl();

    public List<String> getProductCategories() {
        return productService.getProductCategories();
    }

    @WebMethod(exclude=true)
    public List<String> getProducts(String category) {
        return productService.getProducts(category);
    }

    @WebMethod(exclude=true)
    public boolean addProduct(String category, String product) {
        return productService.addProduct(category, product);
    }

}
