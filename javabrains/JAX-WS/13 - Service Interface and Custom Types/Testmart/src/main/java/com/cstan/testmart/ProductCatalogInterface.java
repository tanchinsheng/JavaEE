/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cstan.testmart;

import com.cstan.model.Product;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "TestMartCatalog", targetNamespace = "http://www.testmart.com")
public interface ProductCatalogInterface {

    boolean addProduct(String category, String product);

    @WebMethod(action = "fetch _categories", operationName = "fetchCategories")
    List<String> getProductCategories();

    List<String> getProducts(String category);

    List<Product> getProductsv2(String category);
    
}
