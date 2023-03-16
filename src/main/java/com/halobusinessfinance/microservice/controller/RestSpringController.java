/*
 * Product of Halo Buiness Finance
 */
package com.halobusinessfinance.microservice.controller;

/**
 *
 * @author Michael Ritchson
 */
import com.halobusinessfinance.microservice.loan.model.Loans;
import com.halobusinessfinance.microservice.loan.repository.LoanRepository;
import com.halobusinessfinance.microservice.loan.model.Payload;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
   // public String getAllLoanRequests() {
        Loans loans = new Loans();
        loans.setLoanType("102");
        
        Map<String, Object> responseMap = new HashMap<>();

        System.out.println("Getting items for the loanType " + loans.getLoanType());
        // LoanRepository repo = null;
        List<Loans> list = repo.findAllByStatus(status);

        ArrayList<Payload> payloadList = new ArrayList<>();
        list.forEach(item -> {
            Payload payload = new Payload(item.getAccepted(),
                    item.getStatus(),
                    item.getAmountToBeBorrowed(),
                    item.getEmailOfBorrower(),
                    item.getLoanType(),
                    item.getLoanTypeDescription(),
                    item.getNameOfBorrower(),
                    item.getNameOfBusiness(),
                    item.getLoan());
            payloadList.add(payload);
        }
        );
        loans.setPayload(payloadList);

        responseMap.put("Payload", payloadList);
        responseMap.put("isSuccess", "true");
        return ResponseEntity.ok(responseMap);
    }

    @PostMapping(path = "/api/admin/get-loan-requests-summary", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> getLoanRequestsSummary(@RequestBody Loans loans) {
        Map<String, Object> response = new HashMap<>();

        return ResponseEntity.ok(response);
    }

}
