package com.cstan.testmart;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class ShopInfo {
    
    @WebMethod
    @WebResult(partName="lookupOutput")
    public String getShopInfo(@WebParam(partName="lookupInput") String property) throws InvalidInputException {
        String response = null;
        if("shopName".equals(property)) {
            response = "Test Mart";
        } else if ("since".equals(property)){
            response = "since 2012";
        } else {
            throw new InvalidInputException("Invalid Input", property + " is not a valid input");
        }
        return response;
    }
}
