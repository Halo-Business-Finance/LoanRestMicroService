/*
 * Product of Halo Buiness Finance
 */
package com.halobusinessfinance.microservice.controller;

/**
 *
 * @author Michael Ritchson
 */
import com.halobusinessfinance.microservice.controller.utils.Utils;
import com.halobusinessfinance.microservice.loan.model.LoanCount;
import com.halobusinessfinance.microservice.loan.model.Loans;
import com.halobusinessfinance.microservice.loan.repository.CustomLoanRepositoryImpl;
import com.halobusinessfinance.microservice.loan.repository.LoanRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.halobusinessfinance.microservice.loan.repository")
@CrossOrigin(origins = "*")
public abstract class RestSpringController {

    @Autowired(required = true)
    private LoanRepository repo;

    List<Loans> itemList = new ArrayList<Loans>();

    public static void main(String[] args) {
        SpringApplication.run(RestSpringController.class, args);
    }

    @GetMapping(path = "/api/admin/get-all-loan-requests", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> getAllLoanRequests(@RequestParam("status") String status,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("take") int take) {
        Loans loans = new Loans();
        loans.setStatus(status);
        List<Loans> list = null;

        Map<String, Object> responseMap = new HashMap<>();

        //System.out.println("Getting items for the loan status " + loans.getStatus());
        // will query for count or loans in summary
        list = (status.equals("all")) ? repo.findAll() : repo.findAllByStatus(status);

        ArrayList<Loans> loanList = new ArrayList<>();
        list.forEach(item -> {
            Loans loan = new Loans(item.getAccepted(),
                    item.getStatus(),
                    item.getAmountToBeBorrowed(),
                    item.getEmailOfBorrower(),
                    item.getLoanType(),
                    item.getLoanTypeDescription(),
                    item.getNameOfBorrower(),
                    item.getNameOfBusiness(),
                    item.getPhoneNumber(),
                    item.getApplicationNumber(),
                    item.getApplicationStarted(),
                    item.getFormProgress(),
                    item.getLoanTypes(),
                    item.getLoanTypeString(),
                    item.getStarted(),
                    item.getLoanRequestId(),
                    item.getLoanRequestStatus());
            loanList.add(loan);

        }
        );
        loans.setPayload(loanList);

        LoanCount loanCount = new LoanCount();
        // if (status.equals("all")) {
        list = repo.findAllByStatus("InProgress");
        loanCount.setInProgress(Integer.toString(list.size()));
        list = repo.findAllByStatus("Accepted");
        loanCount.setAccepted(Integer.toString(list.size()));
        list = repo.findAllByStatus("Processing");
        loanCount.setProcessing(Integer.toString(list.size()));
        list = repo.findAllByStatus("Underwriting");
        loanCount.setUnderWriting(Integer.toString(list.size()));
        list = repo.findAllByStatus("Declined");
        loanCount.setDeclined(Integer.toString(list.size()));
        list = repo.findAllByStatus("Lending");
        loanCount.setLending(Integer.toString(list.size()));
        list = repo.findAllByStatus("Funded");
        loanCount.setFunded(Integer.toString(list.size()));
        list = repo.findAllByStatus("Archived");
        loanCount.setArchived(Integer.toString(list.size()));
        list = repo.findAllByStatus("Deleted");
        loanCount.setDeleted(Integer.toString(list.size()));
      
        responseMap.put("payload", loanList);
        responseMap.put("loanCount", loanCount);
        responseMap.put("isSuccess", "true");
        return ResponseEntity.ok(responseMap);
    }

    @PostMapping(path = "/api/borrower/create-prequalify-request", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createPreQualify(@RequestBody Loans loans
    ) {
        loans.setStatus("InProgress");
        Utils utils = new Utils();
        loans.setApplicationStarted(utils.getTodaysDate());
        loans.setLoanRequestId(UUID.randomUUID().toString());
        loans.setApplicationNumber(String.valueOf((int) (Math.random() * 899999) + 10000));
        loans.setLoanTypeString(utils.getLoanTypeString(loans.getLoanTypes()));
        repo.save(loans);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", "true");
        responseMap.put("message", "success");
        return ResponseEntity.ok(responseMap);
    }

    @PostMapping(path = "/api/admin/change-loan-status", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> changeLoanStatus(@RequestBody Loans loans
    ) {

        List<Loans> list = repo.findByApplicationNumber(loans.getApplicationNumber());

        CustomLoanRepositoryImpl crud = new CustomLoanRepositoryImpl();
        list = crud.updateLoanStatus(list, loans.getApplicationNumber(), loans.getLoanRequestStatus());
        List<Loans> loansUpdated = repo.saveAll(list);

        if (loansUpdated != null) {
            System.out.println("Successfully updated " + loansUpdated.size() + " items.");
        }

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", "true");
        responseMap.put("message", "success");
        return ResponseEntity.ok(responseMap);
    }

    //get-loan-requests-summary
    @GetMapping(path = "/api/admin/get-loan-requests-summary", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> getLoanRequestsSummary(@RequestParam("status") String status) {
        List<Loans> list = null;
        
        LoanCount loanCount = new LoanCount();
        // if (status.equals("all")) {
        list = repo.findAllByStatus("InProgress");
        loanCount.setInProgress(Integer.toString(list.size()));
        list = repo.findAllByStatus("Accepted");
        loanCount.setAccepted(Integer.toString(list.size()));
        list = repo.findAllByStatus("Processing");
        loanCount.setProcessing(Integer.toString(list.size()));
        list = repo.findAllByStatus("Underwriting");
        loanCount.setUnderWriting(Integer.toString(list.size()));
        list = repo.findAllByStatus("Declined");
        loanCount.setDeclined(Integer.toString(list.size()));
        list = repo.findAllByStatus("Lending");
        loanCount.setLending(Integer.toString(list.size()));
        list = repo.findAllByStatus("Funded");
        loanCount.setFunded(Integer.toString(list.size()));
        list = repo.findAllByStatus("Archived");
        loanCount.setArchived(Integer.toString(list.size()));
        list = repo.findAllByStatus("Deleted");
        loanCount.setDeleted(Integer.toString(list.size()));
        
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("loanCount", loanCount);
        responseMap.put("isSuccess", "true");
        responseMap.put("message", "success");
        return ResponseEntity.ok(responseMap);
    }

}
