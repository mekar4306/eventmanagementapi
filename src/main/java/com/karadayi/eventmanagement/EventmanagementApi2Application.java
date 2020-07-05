package com.karadayi.eventmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
@EntityScan(basePackageClasses =  {EventmanagementApi2Application.class,Jsr310Converters.class}) //This entity can be used with <artifactId>jackson-datatype-jsr310</artifactId> dependency for java.time
public class EventmanagementApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApi2Application.class, args);
	}

}
