/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
    
    
    public static final Map<String, String> process() {
        responseMap = new HashMap<>();

       
       
            responseMap.put("isSuccess", "true");
            responseMap.put("message", "message");
            

       
        return responseMap;
    }

    public static final Map<String, String> failed() {
        responseMap = new HashMap<>();

        responseMap.put("isError", "true");
        responseMap.put("reason", "invalid userid / pasword");
        return responseMap;
    }

}
