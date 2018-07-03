package service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import service.business.Transaction;

public interface Transactionrepository extends JpaRepository<Transaction, Long> {

}
