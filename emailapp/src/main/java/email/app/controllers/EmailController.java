package email.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import email.app.services.EmailService;

@RestController
@RequestMapping("/email/")
public class EmailController {

	@Autowired
	EmailService emailService;
	
		
	@Bean
	public SimpleMailMessage message() {
		return new SimpleMailMessage();
	}
	
		
	@GetMapping("send")
	@ResponseBody
	public String sendEmail(String from, String to, String content) {
	
		String returnStr="";
		try 
		{
			//from ="shanjob09@gmail.com";
			//to ="shanjob09@gmail.com";
			//content="test email";
			
			message().setFrom(from);
			message().setTo(to);
			message().setText(content);
		
			System.out.println("sending email ......");
			
			if (emailService.send(message()))
			{
				System.out.println("email send");
				returnStr="emailsent";
			}
		}
		
		catch(Exception e) {
			returnStr="error";
			
		}
		
		return returnStr;
	
			
	}
	
	
	
}
