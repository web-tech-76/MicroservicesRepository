package boot.schedule.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootScheduleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootScheduleServiceApplication.class, args);
	}

}
