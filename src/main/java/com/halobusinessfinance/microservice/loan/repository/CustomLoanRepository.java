/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.halobusinessfinance.microservice.loan.repository;

import com.halobusinessfinance.microservice.loan.model.Loans;
import java.util.List;

/**
 *
 * @author root
 */
public interface CustomLoanRepository {
     List<Loans> updateLoanStatus(List<Loans> list, String value, String status);
}
