package boot.schedule.app.services;

import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledTasks {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRate =  2000)
    public void scheduleWithFixedRate() {}

    public void scheduleWithFixedDelay() {}

    public void scheduleWithInitialDelay() {}

    
    public void scheduleWithCronExpression() {}

	
}
