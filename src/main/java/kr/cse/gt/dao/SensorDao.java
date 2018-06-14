package kr.cse.gt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.cse.gt.model.Sensor;

public interface SensorDao extends JpaRepository<Sensor, Integer> {

}
