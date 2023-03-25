/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halobusinessfinance.microservice.loan.model;

import lombok.Data;

/**
 *
 * @author root
 */
@Data
public class LoanCount {
     private String inProgress;
     private String processing;
     private String accepted;
     private String declined;
     private String underWriting;
     private String lending;
     private String funded;
     private String archived;
     private String deleted;
     
     
}
