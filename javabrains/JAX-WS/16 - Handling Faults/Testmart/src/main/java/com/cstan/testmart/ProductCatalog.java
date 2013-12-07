package com.cstan.testmart;

import com.cstan.business.ProductServiceImpl;
import com.cstan.model.Product;
import java.util.List;
import javax.jws.WebService;

@WebService(endpointInterface="com.cstan.testmart.ProductCatalogInterface",
        portName = "TestMartCatalogPort", serviceName = "TestMartCatalogService")
public class ProductCatalog implements ProductCatalogInterface {

    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    public List<String> getProductCategories() {
        return productService.getProductCategories();
    }

    @Override
    public List<String> getProducts(String category) {
        return productService.getProducts(category);
    }

    @Override
    public boolean addProduct(String category, String product) {
        return productService.addProduct(category, product);
    }

    @Override
    public List<Product> getProductsv2(String category) {
        return productService.getProductsv2(category);
    }

}
