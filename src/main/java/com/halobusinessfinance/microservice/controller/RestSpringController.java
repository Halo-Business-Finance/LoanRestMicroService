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
import com.halobusinessfinance.microservice.loan.repository.Payload;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.halobusinessfinance.microservice.loan.repository")
@CrossOrigin(origins = "*")
public abstract class RestSpringController {

   // @Autowired
  //  private Environment env;

    @Autowired(required=true)
    private LoanRepository repo;
    
    List<Loans> itemList = new ArrayList<Loans>();

    public static void main(String[] args) {
        SpringApplication.run(RestSpringController.class, args);
    }

    @PostMapping(path = "/api/admin/get-all-loan-requests", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> getAllLoanRequests(@RequestBody Loans loans) {
        Map<String, Object> responseMap = new HashMap<>();
        

        System.out.println("Getting items for the loanType " + loans.getLoanType());
        // LoanRepository repo = null;
        List<Loans> list = repo.findAll();

        //list.forEach(item -> System.out.println("LoanType: " + item.getLoanType() + ", Name of Borrower: " + item.getNameOfBorrower()));
        /*
        Payload payload = new Payload(access_token,
                    twilioUser.getDisplayName(),
                    twilioUser.getEmail(),
                    twilioUser.getUsername(),
                    twilioUser.getFirstName(),
                    twilioUser.getLastName(),
                    twilioUser.getPhoneNumber());

            user.setPayload(payload);

            response.put("isSuccess", "true");
            response.put("Payload", user.getPayload());
        */
        list.forEach(item -> {
                   // responseMap.put("loan", item);
                   // responseMap.put("NameOfBorrower", item.getNameOfBorrower());
                    //System.out.println("LoanType: " + item.getLoanType() + ", Name of Borrower: " + item.getNameOfBorrower());
                    Payload payload = new Payload(item.getAccepted(),
                    item.getAmountToBeBorrowed(),
                    item.getEmailOfBorrower(),
                    item.getLoanType(),
                    item.getLoanTypeDescription(),
                    item.getNameOfBorrower(),
                    item.getNameOfBusiness());
                    loans.setPayload(payload);
                });
        
        responseMap.put("Payload", loans.getPayload());
        responseMap.put("isSuccess", "true");
        //responseMap.put("message", "message");
        return ResponseEntity.ok(responseMap);
    }

    @PostMapping(path = "/api/admin/get-loan-requests-summary", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> getLoanRequestsSummary(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();

        return ResponseEntity.ok(response);
    }
    
    // CRUD operations

	//CREATE
	void createLoans() {
		System.out.println("Data creation started...");

		//repo.save(new Loans("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
		
		
		System.out.println("Data creation complete...");
	}
	
	// READ
	// 1. Show all the data
	 public void showAllGroceryItems() {
		 
		 itemList = repo.findAll();
		 
		 itemList.forEach(item -> System.out.println(getItemDetails(item)));
	 }
	 
	 // 2. Get item by name
	 public void getItemByName(String name) {
		 System.out.println("Getting item by name: " + name);
		// Loans item = repo.findItemByName(name);
		// System.out.println(getItemDetails(item));
	 }
	 
	 // 3. Get name and items of a all items of a particular category
	 public void getItemsByCategory(String category) {
		 System.out.println("Getting items for the category " + category);
		// List<GroceryItem> list = groceryItemRepo.findAll(category);
		 
		// list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getItemQuantity()));
	 }
	 
	 // 4. Get count of documents in the collection
	 public void findCountOfGroceryItems() {
		// long count = groceryItemRepo.count();
		// System.out.println("Number of documents in the collection = " + count);
	 }
	 
	 // UPDATE APPROACH 1: Using MongoRepository
	 public void updateCategoryName(String category) {
		 
		 // Change to this new value
		 String newCategory = "munchies";
		 
		 // Find all the items with the category 
		// List<GroceryItem> list = groceryItemRepo.findAll(category);
		 
		// list.forEach(item -> {
			 // Update the category in each document
		//	 item.setCategory(newCategory);
		// });
		 
		 // Save all the items in database
		// List<GroceryItem> itemsUpdated = groceryItemRepo.saveAll(list);
		 
		// if(itemsUpdated != null)
		//	 System.out.println("Successfully updated " + itemsUpdated.size() + " items.");		 
	 }
	 
	 
	 // UPDATE APPROACH 2: Using MongoTemplate
	 public void updateItemQuantity(String name, float newQuantity) {
		// System.out.println("Updating quantity for " + name);
		// customRepo.updateItemQuantity(name, newQuantity);
	 }
	 
	 // DELETE
	 public void deleteGroceryItem(String id) {
		// groceryItemRepo.deleteById(id);
		// System.out.println("Item with id " + id + " deleted...");
	 }
	 // Print details in readable form
	 
	 public String getItemDetails(Loans item) {

		 System.out.println(
		 "Item Name: " + item.getNameOfBorrower() + 
		 ", \nItem Quantity: " + item.getNameOfBusiness() + 
		 ", \nItem Category: " + item.getLoanType()
		 );
		 
		 return "";
	 }

}
