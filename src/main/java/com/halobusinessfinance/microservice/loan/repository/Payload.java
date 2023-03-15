/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halobusinessfinance.microservice.loan.repository;

// Importing class
import lombok.Data;

/*
item.getAccepted(),
                    item.getAmountToBeBorrowed(),
                    item.getEmailOfBorrower(),
                    item.getLoanType(),
                    item.getLoanTypeDescription(),
                    item.getNameOfBorrower(),
                    item.getNameOfBusiness()
*/
@Data
public class Payload {
    private String accepted;
    private String amountToBeBorrowed;
    private String emailOfBorrower;
    private String loanType;
    private String loanTypeDescription;
    private String nameOfBorrower;
    private String NameOfBusiness;
   
    
    
    public Payload (String accepted,
                    String amountToBeBorrowed,
                    String emailOfBorrower,
                    String loanType,
                    String loanTypeDescription,
                    String nameOfBorrower,
                    String nameOfBusiness) {
        this.accepted = accepted;
        this.amountToBeBorrowed = amountToBeBorrowed;
        this.emailOfBorrower = emailOfBorrower;
        this.loanType = loanType;
        this.loanTypeDescription = loanTypeDescription;
        this.nameOfBorrower = nameOfBorrower;
        this.NameOfBusiness = nameOfBusiness;
        
        
    }
    
}
