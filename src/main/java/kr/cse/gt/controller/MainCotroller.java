package kr.cse.gt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.cse.gt.service.EmailServiceImpl;

@Controller
public class MainCotroller {

	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@RequestMapping("/test")
	public String test(Model model) {

		/////////////////////////////////////////////
		String temp = "...";
		// Date date = new Date(2018,6,10);	
		
		Float temperature = 27.0F;
		Float humidity = 50F;

		Integer intHumidity = (int) humidity.floatValue();

		//emailServiceImpl.sendMessageWithHTML("kr-cse@naver.com", "test", "<h1>hello</h1>");
		
		///////////////////////////////////////////
		model.addAttribute("date", temp);
		// model.addAttribute("date", date);
		model.addAttribute("temperature", temperature);
		model.addAttribute("humidity", intHumidity);
		
		
		
		
		
		
		
		
		return "index";
	}
}