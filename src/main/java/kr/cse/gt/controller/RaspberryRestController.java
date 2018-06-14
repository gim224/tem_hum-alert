package kr.cse.gt.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.cse.gt.model.BasicSensorInfo;

@RestController
@RequestMapping("/api/raspberry")
public class RaspberryRestController {

	@RequestMapping(method = RequestMethod.POST)
	public HashMap<String, Object> getSensorInfoRaspberry(@RequestBody BasicSensorInfo basicSensorInfo) {
		double temperature = basicSensorInfo.getTemperature();
		double humidity = basicSensorInfo.getHumidity();
	
		
		System.out.println(temperature + ",,,,,,,,,,,, " + humidity);

		return null;
	}
	
	@RequestMapping(value = "/sensor", method = RequestMethod.GET)
	public @ResponseBody BasicSensorInfo sensorInfoToAjax() {

		BasicSensorInfo basicSensorInfo = new BasicSensorInfo();
		basicSensorInfo.setTemperature(27.0);
		basicSensorInfo.setHumidity(30.0);
		
		System.out.println(basicSensorInfo.getTemperature());
		return basicSensorInfo;
	}
}
