/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halobusinessfinance.microservice.loan.model;

import com.halobusinessfinance.microservice.loan.repository.Payload;
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
    private String accepted;
    private String amountToBeBorrowed;
    private String emailOfBorrower;
    private String loanTypeDescription;
    private String loanType;
    private String nameOfBorrower;
    private String nameOfBusiness;
    private String phoneNumber;
    private String prequalifyAnswers;
    private Payload payload;

    public Loans(String id,
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
    
    public Payload getPayload() {
         return payload;
     }
     
     public void setPayload(Payload payload) {
         this.payload = payload;
     }
    

}
