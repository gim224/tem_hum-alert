package kr.cse.gt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.cse.gt.dao.SensorDao;
import kr.cse.gt.model.Sensor;

@Service
public class SensorService {

	@Autowired
	private SensorDao sensorDao;

	public Sensor findByOne(int id) {
		return sensorDao.getOne(id);
	}

	public String verifyTemperautre(int id) {
		Sensor sensor = findByOne(id);

		float temperature = sensor.getTemperature();
		System.out.println("tem = "+temperature);
		String danger = "";

		if (28 < temperature || temperature < 16) {
			danger = "상";
		} else if (24 < temperature || temperature < 21) {
			danger = "중";
		} else {
			danger = "하";
		}
		
		return danger;

	}

	public String verifyHumidity(int id) {
		Sensor sensor = findByOne(id);

		float humidity = sensor.getHumidity();
		System.out.println("hum = "+humidity);
		String danger = "";

		if (70 < humidity || humidity < 40) {
			danger = "상";
		} else if (55 < humidity || humidity < 45) {
			danger = "중";
		} else {
			danger = "하";
		}
		
		return danger;
	}

}
