package dev.jlarsen.resourceserverdemo.repositories;

import dev.jlarsen.resourceserverdemo.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
