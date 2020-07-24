package email.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mailSender;
	
	
	
	public Boolean send(SimpleMailMessage message) throws Exception{
		
		try 
		{
			mailSender.send(message);
		}
		catch(Exception e) {
			throw new Exception("error");
		}
		
		return true;
	}
	
	
	
	
}
