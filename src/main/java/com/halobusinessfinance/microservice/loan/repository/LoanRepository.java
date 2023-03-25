/*
 * Product of Halo Buiness Finance
 */
package com.halobusinessfinance.microservice.loan.repository;

import com.halobusinessfinance.microservice.loan.model.Loans;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Michael Ritchson
 * Based on https://www.mongodb.com/compatibility/spring-boot
 */


public interface LoanRepository extends MongoRepository<Loans, String>{
 
    
  
    
  //@Query(value="{loanType:'?0'}", fields="{'loanType' : 1, 'nameOfBorrower' : 1}")
  //@Query(value="{loanType:'?0'}")
  @Override
  List<Loans> findAll();
  
  @Query(value="{status:'?0'}")
  List<Loans> findAllByStatus(String status);
  
  @Query(value="{applicationNumber:'?0'}")
  List<Loans> findByApplicationNumber(String applicationNumber);
  
  @Query(value="{loanTypes:'?0'}")
  List<Loans> findLoanByTypes(String loanTypes);
    
  public long count(); 
}
