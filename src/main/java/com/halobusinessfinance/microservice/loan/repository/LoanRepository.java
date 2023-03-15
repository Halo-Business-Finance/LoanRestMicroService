/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.halobusinessfinance.microservice.loan.repository;

import com.halobusinessfinance.microservice.loan.model.Loans;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author root
 */


public interface LoanRepository extends MongoRepository<Loans, String>{
 
    
  @Query("{nameOfBorrower:'?0'}")
  Loans findNameOfBorrower(String loanType);
    
  //@Query(value="{loanType:'?0'}", fields="{'loanType' : 1, 'nameOfBorrower' : 1}")
  @Override
  List<Loans> findAll();
    
  public long count(); 
}
