/*
 * Product of Halo Buiness Finance
 */
package com.halobusinessfinance.microservice.loan.model;

// Importing class
import java.util.List;
import lombok.Data;

@Data
public class Payload {
    private String accepted;
    private String amountToBeBorrowed;
    private String emailOfBorrower;
    private String loanType;
    private String loanTypeDescription;
    private String nameOfBorrower;
    private String NameOfBusiness;
    private List loan;
    
   
    public Payload (String accepted,
                    String amountToBeBorrowed,
                    String emailOfBorrower,
                    String loanType,
                    String loanTypeDescription,
                    String nameOfBorrower,
                    String nameOfBusiness,
                    List loan) {
        this.accepted = accepted;
        this.amountToBeBorrowed = amountToBeBorrowed;
        this.emailOfBorrower = emailOfBorrower;
        this.loanType = loanType;
        this.loanTypeDescription = loanTypeDescription;
        this.nameOfBorrower = nameOfBorrower;
        this.NameOfBusiness = nameOfBusiness;
        this.loan = loan;

    }
    
     public List getLoan() {
         return loan;
     }
     
     public void setLoan(List loan) {
         this.loan = loan;
     }
    
}
