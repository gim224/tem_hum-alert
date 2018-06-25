package kr.cse.gt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("kr.cse.gt.*")
public class TemperatureHumidityAlertServerApplication {

	public static void main(String[] args) {
		for(int i=0;i<args.length;i++)
			System.out.println("args"+"["+i+"]"+" = " + args[i]);
		SpringApplication.run(TemperatureHumidityAlertServerApplication.class, args);
	}
}
