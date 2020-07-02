package bank.service.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bank.service.resources.Bank;


@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
	
}
