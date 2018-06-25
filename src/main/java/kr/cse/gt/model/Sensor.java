package kr.cse.gt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Sensor {

	// 기본키
	@Id
	@GeneratedValue
	private Integer id;

	// 현재시간
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;

	// 온도
	@NotNull
	private Float temperature;

	// 습도
	@NotNull
	private Integer humidity;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="tem_id")
//	private TemperatureStandard temperatureStandard;
//
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="hum_id")
//	private HumidityStandard humidityStandard;
//	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
