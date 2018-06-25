package kr.cse.gt.service;



import java.util.Comparator;
import java.util.List;

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
	
	public void save(Sensor sensor) {
		sensorDao.saveAndFlush(sensor);
	}
	

	public String verifyTemperautre(Sensor sensor) {		

		float temperature = sensor.getTemperature();		
		
		return verifyTem(temperature);
		
	}

	public String verifyHumidity(Sensor sensor) {
		

		float humidity = sensor.getHumidity();		
		
		return verifyHum(humidity);
	}
	
	
	
	
	
	private String verifyTem(float temperature) {
		String danger = "";

		if (28 < temperature || temperature < 16) {
			danger = "위험";
		} else if (24 < temperature || temperature < 21) {
			danger = "정상";
		} else {
			danger = "최적";
		}
		
		return danger;

	}
	
	private String verifyHum(float humidity) {
		String danger = "";

		if (70 < humidity || humidity < 40) {
			danger = "위험";
		} else if (55 < humidity || humidity < 45) {
			danger = "정상";
		} else {
			danger = "최적";
		}		
		
		return danger;
	}
	
	
	public Sensor mostRecentlyData() {
		List<Sensor>sensors = sensorDao.findAll();
		sensors.sort(new Comparator<Sensor>() {

			@Override
			public int compare(Sensor o1, Sensor o2) {
				// TODO Auto-generated method stub
				return o2.getId().compareTo(o1.getId());
			}
			
		});
		
		if(sensors.isEmpty() != true)
			return sensors.get(0);
		else
			return null;
	}
	
}
