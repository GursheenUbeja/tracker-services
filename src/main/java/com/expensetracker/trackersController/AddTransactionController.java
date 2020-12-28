package com.expensetracker.trackersController;


import javax.inject.Inject;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.model.Expenditure;
import com.expensetracker.trackerservice.AddTransactionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/addTransactionService")
public class AddTransactionController {

	@Inject
	private AddTransactionService transactionService;

	@PostMapping("/addTransaction")
	public void addTransaction( @RequestBody Expenditure exp) {
		transactionService.saveTransaction(exp);
		
	}
}
