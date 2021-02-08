package com.salesken.anand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.anand.model.Transaction;
import com.salesken.anand.service.TransactionService;

//mark class as Controller
@RestController
public class TransactionController {
	// autowire the TransactionService class
	@Autowired
	TransactionService transService;

	// creating a get mapping that retrieves all the books detail from the database
	@GetMapping("/alltrans")
	private List<Transaction> getAllTransactions() {
		return transService.getAllTransactions();
	}

	// creating a get mapping that retrieves the detail of a specific transaction
	@GetMapping("/transactions/{transId}")
	private Transaction getTransactions(@PathVariable("transId") String transId) {
		return transService.getTransactionsById(transId);
	}

	// creating a delete mapping that deletes a specified transaction
	@DeleteMapping("/transactions/{trnasId}")
	private void deleteTransaction(@PathVariable("trnasId") String trnasId) {
		transService.delete(trnasId);
	}

	// creating post mapping that post the transaction detail in the database
	@PostMapping("/transaction")
	private String saveTransaction(@RequestBody Transaction transactions) {
		transService.saveOrUpdate(transactions);
		return transactions.getTransId();
	}

}
