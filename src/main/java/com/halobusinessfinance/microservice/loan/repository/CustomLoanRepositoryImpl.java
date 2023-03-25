/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halobusinessfinance.microservice.loan.repository;

import com.halobusinessfinance.microservice.loan.model.Loans;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author root
 */
@Component

public class CustomLoanRepositoryImpl implements CustomLoanRepository {
    
  
    
    @Override
    public List<Loans> updateLoanStatus(List<Loans> list , String applicationNumber, String newStatus) {
        
         list.forEach(item -> {
             // Update the category in each document
             item.setStatus(newStatus.equals("UnderWriting") ? "Underwriting" : newStatus);
         });
         
         return list;
    }
    
}
