/*
 * Product of Halo Buiness Finance
 */
package com.halobusinessfinance.microservice.loan.model;

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
    private String prequalifyAnswers;
    private List loan;
    private List payload;

    public Loans(String id,
            String status,
            String accepted,
            String amountToBeBorrowed,
            String emailOfBorrower,
            String loanTypeDescription,
            String loanType,
            String nameOfBorrower,
            String nameOfBusiness,
            String phoneNumber,
            String prequalifyAnswers) {
        super();
        this.id = id;
        this.status = status;
        this.accepted = accepted;
        this.amountToBeBorrowed = amountToBeBorrowed;
        this.emailOfBorrower = emailOfBorrower;
        this.loanTypeDescription = loanTypeDescription;
        this.loanType = loanType;
        this.nameOfBorrower = nameOfBorrower;
        this.nameOfBusiness = nameOfBusiness;
        this.phoneNumber = phoneNumber;
        this.prequalifyAnswers = prequalifyAnswers;
        
    }
    
    public Loans() {
        
    }
    
    
    public List getLoan() {
         return loan;
     }
     
     public void setLoan(List loan) {
         this.loan = loan;
     }

    
    public List getPayload() {
         return payload;
     }
     
     public void setPayload(List payload) {
         this.payload = payload;
     }
    

}
