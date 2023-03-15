/*
 * Product of Halo Buiness Finance
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
 * @author Michael Ritchson
 * Based on https://www.mongodb.com/compatibility/spring-boot
 */


public interface LoanRepository extends MongoRepository<Loans, String>{
 
    
  @Query("{nameOfBorrower:'?0'}")
  Loans findNameOfBorrower(String loanType);
    
  //@Query(value="{loanType:'?0'}", fields="{'loanType' : 1, 'nameOfBorrower' : 1}")
  //@Query(value="{loanType:'?0'}")
  @Override
  List<Loans> findAll();
  
  @Query(value="{loanType:'?0'}")
  List<Loans> findAllByLoanType(String loanType);
    
  public long count(); 
}
