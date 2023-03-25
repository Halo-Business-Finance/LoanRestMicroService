/*
 * Product of Halo Buiness Finance
 */
package com.halobusinessfinance.microservice.loan.model;

import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Michael Ritchson
 */
@Document("Loans")
@Data
public class Loans {

    @Id
    private String id;
    private String status;
    private String accepted;
    private String amountToBeBorrowed;
    private String emailOfBorrower;
    private String loanTypeDescription;
    private String loanType;
    private String nameOfBorrower;
    private String nameOfBusiness;
    private String phoneNumber;
    private PreQualifyAnswers prequalifyAnswers;
    //private List loan;
    private List payload;
    private String applicationNumber;
    private String applicationStarted;
    private String formProgress;
    private String loanTypes;
    private String loanTypeString;
    private String started;
    private String loanRequestId;
    private String loanRequestStatus;
    



   public Loans(String accepted,
                    String status,
                    String amountToBeBorrowed,
                    String emailOfBorrower,
                    String loanType,
                    String loanTypeDescription,
                    String nameOfBorrower,
                    String nameOfBusiness,
                    String phoneNumber,
                    String applicationNumber,
                    String applicationStarted,
                    String formProgress,
                    String loanTypes,
                    String loanTypeString,
                    String started,
                    String loanRequestId,
                    String loanRequestStatus) {
        this.accepted = accepted;
        this.status = status;
        this.amountToBeBorrowed = amountToBeBorrowed;
        this.emailOfBorrower = emailOfBorrower;
        this.loanType = loanType;
        this.loanTypeDescription = loanTypeDescription;
        this.nameOfBorrower = nameOfBorrower;
        this.nameOfBusiness = nameOfBusiness;
        this.phoneNumber = phoneNumber;
        this.applicationNumber = applicationNumber;
        this.applicationStarted = applicationStarted;
        this.formProgress = formProgress;
        this.loanTypes = loanTypes;
        this.started = started;
        this.loanTypeString = loanTypeString;
        this.loanRequestId = loanRequestId;
        this.loanRequestStatus = loanRequestStatus;
       
    }
    
    public Loans() {
        
    }
    
    
   // public List getLoan() {
  //       return loan;
   //  }
     
   //  public void setLoan(List loan) {
   //      this.loan = loan;
  //   }
     
     public PreQualifyAnswers getPrequalifyAnswers() {
         return prequalifyAnswers;
     }
     
     public void setPrequalifyAnswers(PreQualifyAnswers prequalifyAnswers) {
         this.prequalifyAnswers = prequalifyAnswers;
     }
     
 
  public List getPayload() {
         return payload;
   }
     
  public void setPayload(List payload) {
       this.payload = payload;
   }
    

}
