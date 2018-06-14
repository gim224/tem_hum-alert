package kr.cse.gt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledEmailService {

	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SensorService sensorService;
	
	
	//초 분 시 일 월 요일 연도(생락가능)
	@Scheduled(cron = "0 58 12 ? * MON-FRI")
	public void reportCurrentTime() {
		emailServiceImpl.sendMessageWithHTML("kr-cse@naver.com", "test2", "<h1>hello</h1>");
	}
	
	
}
