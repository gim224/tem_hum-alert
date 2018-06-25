package kr.cse.gt.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Service;

import kr.cse.gt.model.Sensor;
import kr.cse.gt.model.User;
import kr.cse.gt.scheduler.ProgrammableScheduler;

@Service
public class ScheduledEmailService extends ProgrammableScheduler {

	@Autowired
	private EmailServiceImpl emailServiceImpl;

	@Autowired
	private UserService userService;
	@Autowired
	private SensorService sensorService;

	private String htmlConvertToStr() {
		String txt = "";
		String tep = "";
		Sensor sensor = sensorService.mostRecentlyData();
		if (sensor != null) {
			//
			// Sensor sensor = new Sensor();
			// sensor.setDateTime(null);
			// sensor.setTemperature(15.5F);
			// sensor.setHumidity(50);
			// sensor.setId(10);
			tep = "<div style=\"font-family: Gulim,sans-serif; font-size: 10pt;\"><p>​​안녕하세요.</p><p>온습도 알리미 개발자 김기태입니다.</p><p><br></p><p>--------<span style=\"font-size: 13.3333px;\">----------</span><span style=\"font-size: 10pt;\">--김포차량기지 전산실</span><span style=\"font-size: 13.3333px;\">-------</span><span style=\"font-size: 13.3333px;\">----------</span><span style=\"font-size: 13.3333px;\">---</span></p><p>";
			txt = txt.concat(tep);

			tep = "현재 온도 : " + sensor.getTemperature();
			txt = txt.concat(tep);

			tep = "<span style=\"background-color: rgb(255, 255, 255); color: rgb(0, 0, 0); font-size: 13.3333px; text-align: center;\">℃</span></p><p>";
			txt = txt.concat(tep);

			tep = "현재 습도 : " + sensor.getHumidity();
			txt = txt.concat(tep);

			tep = "<span style=\"background-color: rgb(255, 255, 255); color: rgb(0, 0, 0); font-size: 13.3333px; text-align: center;\">%</span></p><p></p><p><br></p><p>";
			txt = txt.concat(tep);

			tep = "현재 온도 위험도는 " + sensorService.verifyTemperautre(sensor) + " 입니다. <br/>";
			txt = txt.concat(tep);

			tep = "현재 습도 위험도는 " + sensorService.verifyHumidity(sensor) + " 입니다.";
			txt = txt.concat(tep);

			tep = "&nbsp;<span style=\"font-size: 13.3333px;\">확인 부탁드립니다.</span></p><p><br></p><table class=\"__se_tbl\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" style=\"background-color: rgb(199, 199, 199);\"><tbody><tr><td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 99px; height: 19px; background-color: rgb(255, 255, 255);\" class=\"\"><p><span style=\"color: rgb(0, 0, 0);\">&nbsp;</span></p></td><td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 111px; height: 19px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \" align=\"center\"><span style=\"color: rgb(0, 0, 0);\">&nbsp;온도 (℃)</span></p></td><td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 111px; height: 19px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \" align=\"center\"><span style=\"color: rgb(0, 0, 0);\">습도 (%)</span></p></td></tr><tr><td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 99px; height: 19px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \" align=\"center\"><span style=\"color: rgb(0, 0, 0);\">최적&nbsp;</span></p></td><td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 111px; height: 19px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \" align=\"center\"><span style=\"color: rgb(0, 0, 0);\">21~24</span></p></td><td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 111px; height: 19px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \" align=\"center\"><span style=\"color: rgb(0, 0, 0);\">45~55</span></p></td></tr><tr><td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 99px; height: 19px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \" align=\"center\"><span style=\"color: rgb(0, 0, 0);\">정상&nbsp;</span></p></td><td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 111px; height: 19px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \" align=\"center\"><span style=\"color: rgb(0, 0, 0);\">16~28</span></p></td><td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 111px; height: 19px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \" align=\"center\"><span style=\"color: rgb(0, 0, 0);\">40~70</span></p></td></tr><tr><td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 99px; height: 19px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \" align=\"center\"><span style=\"color: rgb(0, 0, 0);\">위험&nbsp;</span></p></td><td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 111px; height: 19px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \" align=\"center\"><span style=\"color: rgb(0, 0, 0);\">그 외</span></p></td><td style=\"padding: 3px 4px 2px; color: rgb(102, 102, 102); width: 111px; height: 19px; background-color: rgb(255, 255, 255);\" class=\"\"><p style=\"text-align: center; \" align=\"center\"><span style=\"color: rgb(0, 0, 0);\">그 외</span></p></td></tr></tbody>";
			txt = txt.concat(tep);
			tep = "</table><p></p><p></p><p></p><p>";
			txt = txt.concat(tep);
			// 이번 주 온습도 : .. (지난 주 대비)
			tep = "</p><p><br></p><p>";
			txt = txt.concat(tep);
			// 이번 달 온습도 : .. (지난 달 대비)
			tep = "</p><p><br></p><p><br></p><p><span style=\"font-size: 10pt;\">감사합니다.</span><br></p><p>&nbsp;</p><p>김기태 드림.</p><p>&nbsp;</p><p><strong><span style=\"font-size: 12pt;\">김 기 태</span></strong></p><p>SOC사업팀 / 인턴</p><p>대우정보시스템</p><p>MOBILE : 010-6515-5085</p></div>";
			txt = txt.concat(tep);

			return txt;
		} else
			return "현재 온습도를 불러 올 수 없습니다. 개발자에게 문의해주세요! TEL) 010-6515-5085 김기태";

	}

	@Override
	public void runner(String email) {
		// TODO Auto-generated method stub
		emailServiceImpl.sendMessageWithHTML(email, "[알림] 전산실 온습도 알리미", htmlConvertToStr());
		System.out.println("email sender가 실행되었다.");
	}

	@Override
	public Trigger getTrigger() {
		// TODO Auto-generated method stub
		return new PeriodicTrigger(1, TimeUnit.HOURS);
	}

	@Scheduled(cron = "0 0 0/1 1/1 * ?")
	private void sendEmail() {

		List<User> users = userService.findAll();

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (user.getEmailAlert() != false) {
				String email = user.getEmail();
				emailServiceImpl.sendMessageWithHTML(email, "[알림] 전산실 온습도 알리미입니다.", htmlConvertToStr());
			}
		}
	}

}
