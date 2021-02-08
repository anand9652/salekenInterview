package com.salesken.anand.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import com.salesken.anand.model.Transaction;
import com.salesken.anand.repository.TransactionRepository;
import com.salesken.anand.util.TransactionUtil;

//defining the business logic
@Service
public class TransactionService {
	@Autowired
	TransactionRepository transRepository;

	@Autowired
	TransactionUtil transUtil;

	// getting all transactions record by using the method findaAll() of
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	public List<Transaction> getAllTransactions() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		transRepository.findAll().forEach(transactions1 -> transactions.add(transactions1));
		return transactions;
	}

	// getting a specific transaction by using the method findById() of
	// CrudRepository
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	public Transaction getTransactionsById(String id) {
		return transRepository.findById(id).get();
	}

	// save / update a specific transaction by using the method save() of
	// CrudRepository
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	public void saveOrUpdate(Transaction transactions) {
		if (transactions != null && transactions.getTransId() == null) {
			String transId = transUtil.generateTransactionId();

			transactions.setTransId(transId);

		}
		transactions.setTransDate(new Timestamp(System.currentTimeMillis()).toString());
		transRepository.save(transactions);
	}

	// deleting a specific transaction by using the method deleteById() of
	// CrudRepository
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	public void delete(String id) {
		transRepository.deleteById(id);
	}

}