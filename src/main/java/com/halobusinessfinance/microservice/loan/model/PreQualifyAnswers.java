/*
 * Product of Halo Buiness Finance
 */
package com.halobusinessfinance.microservice.loan.model;

// Importing class
import java.util.List;
import lombok.Data;

@Data
public class PreQualifyAnswers {
    //common + unique 102 Bridge Loan
    private String fundPlan;
    private String refinance;
    private String cashOut;
    private String constructionAmount;
    private String rateTermAmount;
    private String developmentType;
    private String propertyAddress;
    private String propertyType;
    private String propertyTypeOther;
    private String termRequest;
    private String ownerOrInvestment;
    private String occupy;
    private String tenants;
    private String dollar;
    private String ownership;
    private String lawsuit;
    private String bankruptcy;
    private String bankruptcyYear;
    private String plan;
    private String currentProperty;
    private String stabilized;
    private String landBuildingPurchasePrice;
    //unique 101 Refinance of Property
    private String goal;
    private String cash;
    private String business;
    private String address;
    private String property;
    private String downpayment;
    private String commercial;
    //unique 103 Purchase of Property
    private String propertyState;
    //unique 104 Franchise
    private String businessYear;
    private String annualRevenue;
    private String AreaOfBusiness;
    private String useOfProceeds;
    private String specifiedOtherUse;
    private String SBALoan;
    private String creditScore;
    private String LoanAmountRequested;
    private String LoanTermRequested;
    // unique 105 Factoring
    private String invoiceReceivables;
    private String payableTerms;
    private String franchiseCompany;
    //unique 106 Working Capital
    private String grossSales;
    private String otheruse;
    private String franchise;
    private String loanAmount;
    private String ownershipPercentage;
    //unique 107 EIDL
    private String disasterLoan;
    private String eIDLoanStatus;
    private String email;
    private String federalTaxReturn;
    private String LoanAmountReceived;
    private String appliedIncreaseLoan;
    private String increaseLoanAmountReceived;
}
