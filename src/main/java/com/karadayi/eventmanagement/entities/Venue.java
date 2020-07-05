package com.karadayi.eventmanagement.entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Venue extends AbstractEntity{
	
	private String name;
	
	private String streetAddress;
	private String streetAddress2;
	
	
	private String city;
	private String state;
	private String country;
	
	
	private String postalCode;
	

public Long getResourceId() {
		
		return this.id;
	}
	
	
	

}
