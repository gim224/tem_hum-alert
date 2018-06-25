package kr.cse.gt.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.cse.gt.model.BasicSensorInfo;
import kr.cse.gt.model.Sensor;
import kr.cse.gt.service.SensorService;

@RestController
@RequestMapping(value="/api/raspberry")
public class RaspberryRestController {

	@Autowired
	private SensorService sensorService;

	private float globalTemperature = 0.0F;
	private int globalHumidity = 0;

	@RequestMapping(method = RequestMethod.POST)
	public HashMap<String, Object> getSensorInfoRaspberry(@RequestBody BasicSensorInfo basicSensorInfo) {
		double temperature = basicSensorInfo.getTemperature();
		int humidity = basicSensorInfo.getHumidity();

		float floatTemperature = (float) temperature;
		

		globalTemperature = floatTemperature;
		globalHumidity = humidity;

		System.out.println(temperature + ",,,,,,,,,,,, " + humidity);

		return null;
	}

	@RequestMapping(value = "/sensor", method = RequestMethod.GET)
	public @ResponseBody Sensor sensorInfoToAjax() {

		if (globalTemperature != 0.0F && globalHumidity != 0) {

			Sensor sensor = new Sensor();

			float temperature = globalTemperature;
			int humidity = globalHumidity;

			sensor.setTemperature(temperature);
			sensor.setHumidity(humidity);
			sensor.setDateTime(new Date());
			sensorService.verifyTemperautre(sensor);
			sensorService.verifyHumidity(sensor);

			return sensor;

		}

		return null;

	}

	@Scheduled(cron = "0 * * * * *")
	private void insertSensorData() {
		System.out.println("매분 저장되니?");

		if (globalTemperature != 0.0 && globalHumidity != 0) {

			Sensor sensor = new Sensor();

			double temperature = globalTemperature;
			double humidity = globalHumidity;

			float floatTemperature = (float) temperature;
			int intHumidity = (int) humidity;

			sensor.setTemperature(floatTemperature);
			sensor.setHumidity(intHumidity);
			sensor.setDateTime(null);

			sensorService.save(sensor);

		}
	}
}
