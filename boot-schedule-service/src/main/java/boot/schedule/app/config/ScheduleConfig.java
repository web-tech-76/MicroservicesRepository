package boot.schedule.app.config;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

public class ScheduleConfig implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
			ThreadPoolTaskScheduler taskScheduler= new ThreadPoolTaskScheduler();
			taskScheduler.setPoolSize(10);
			taskScheduler.setThreadNamePrefix("thred_scheduler_");
			taskScheduler.initialize();
			
			taskRegistrar.setTaskScheduler(taskScheduler);
	}

}
