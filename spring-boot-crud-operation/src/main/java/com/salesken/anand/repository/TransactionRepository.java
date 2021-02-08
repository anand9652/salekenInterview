package com.salesken.anand.repository;

import org.springframework.data.repository.CrudRepository;

import com.salesken.anand.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
}
