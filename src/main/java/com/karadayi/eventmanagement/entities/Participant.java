package com.karadayi.eventmanagement.entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
public class Participant extends AbstractEntity{

	@Column(nullable = false) 
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	private boolean checkIn;
	
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "ID",updatable = false)
	private Event event;
	
public Long getResourceId() {
		
		return this.id;
	}
	
	
}
