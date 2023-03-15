/*
 * Product of Halo Buiness Finance
 */
package com.halobusinessfinance.microservice.controller;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Michael Ritchson
 */


public final class RestControllerResponses {
    
    private static Map<String, String> responseMap;
    
    
    public static final Map<String, String> processSuccess() {
        responseMap = new HashMap<>();

       
       
            responseMap.put("isSuccess", "true");
            
            

       
        return responseMap;
    }

    public static final Map<String, String> failed() {
        responseMap = new HashMap<>();

        responseMap.put("isError", "true");
        responseMap.put("reason", "no results found");
        return responseMap;
    }

}
