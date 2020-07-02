package bank.service.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.service.delegates.BankService;
import bank.service.resources.Bank;

@RestController
@RequestMapping("/bank/")
public class BankController {
	
	@Autowired
	BankService bankService;
	
	@GetMapping
	public List<Bank> getBankData() {
			return bankService.findAll();
	}
	
	@GetMapping("insert")
	public void insertBankRecord(@RequestBody Bank bank)
	{
		//bankService.insert(bankList);
		
	}
	
	@PutMapping("update")
	public void updateBankRecord(@RequestBody Bank bank)
	{
		//bankService.insert(bankList);
		
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteBankRecord(@RequestBody String id)
	{
		//bankService.insert(bankList);
		
	}
	
	
	@GetMapping("findBank/{id}")
	public void findBankRecord(@RequestBody String id)
	{
		bankService.findAll();
		
	}
	
}
