/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halobusinessfinance.microservice.controller.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author root
 */
public class Utils {

    public String getTodaysDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = today.format(formatter);

        return formattedDate;
    }

    public String getLoanTypeString(String loanType) {

        /*
        loanTypes = [
		"RefinanceOfProperty",
		"BridgeLoan",
		"PurchaseOfProperty",
		"FranchiseLoan",
		"FactoringLoan",
		"WorkingCapital",
		"EIDL",
         */
        String loanTypeString = new String();

        switch (Integer.parseInt(loanType)) {
            case 101:
                loanTypeString = "RefinanceOfProperty";
                break;
            case 102:
                loanTypeString = "BridgeLoan";
                break;
            case 103:
                loanTypeString = "PurchaseOfProperty";
                break;
            case 104:
                loanTypeString = "FranchiseLoan";
                break;
            case 105:
                loanTypeString = "FactoringLoan";
                break;
            case 106:
                loanTypeString = "WorkingCapital";
                break;
            case 107:
                loanTypeString = "EIDL";
                break;
            default:
                loanTypeString = "RefinanceOfProperty";
        }
       return loanTypeString;
    }

}
