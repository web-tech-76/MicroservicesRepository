package bank.service.delegates;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bank.service.repos.BankRepository;
import bank.service.resources.Bank;

@Service
public class BankService {

	
	@Autowired
	BankRepository bankRepo;
	
	@Transactional
	public List<Bank> findAll(){
		
		List<Bank> bankList= new ArrayList<Bank>();
		
		bankList= bankRepo.findAll();
		bankList.stream()
			.forEach(System.out::print);			
		
		return bankList;
	
	}
	
	@Transactional
	public void insert(List<Bank> bankList) {
		bankRepo.saveAll(bankList);
		
		
	}
	
	
	
}
