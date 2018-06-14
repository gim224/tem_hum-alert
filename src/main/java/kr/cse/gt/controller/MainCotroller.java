package kr.cse.gt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.cse.gt.model.Sensor;
import kr.cse.gt.service.SensorService;

@Controller
public class MainCotroller {
	
	@Autowired
	private SensorService senserService;

	@RequestMapping("/test")
	public String test(Model model) {

		Sensor sensor = senserService.findByOne(1);	
		
		Date date = sensor.getDateTime();
		Float temperature = sensor.getTemperature();
		Float humidity = sensor.getHumidity();

		Integer intHumidity = (int) humidity.floatValue();
		//SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat dateForm = new SimpleDateFormat("hh시 mm분");
		
		System.out.println(senserService.verifyTemperautre(1));
		System.out.println(senserService.verifyHumidity(1));

		
		model.addAttribute("date",dateForm.format(date));
		model.addAttribute("temperature", temperature);
		model.addAttribute("humidity", intHumidity);

		return "index";
	}

}