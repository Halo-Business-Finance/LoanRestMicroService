/*
 * Product of Halo Buiness Finance
 */
package com.halobusinessfinance.microservice.controller;

/**
 *
 * @author Michael Ritchson
 */
import com.twilio.rest.conversations.v1.service.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@CrossOrigin(origins = "*")
public class RestSpringController {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(RestSpringController.class, args);
    }

    @PostMapping(path = "/api/admin/get-all-loan-requests", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> getAllLoanRequests(@RequestBody User user) {
        Map<String, String> responseMap = new HashMap<>();

        return ResponseEntity.ok(responseMap);
    }

    @PostMapping(path = "/api/admin/get-loan-requests-summary", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> getLoanRequestsSummary(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();

        return ResponseEntity.ok(response);
    }

}
