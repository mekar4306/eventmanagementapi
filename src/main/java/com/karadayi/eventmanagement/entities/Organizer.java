package com.karadayi.eventmanagement.entities;


import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Organizer extends AbstractEntity {


	private String name;

	@OneToMany(mappedBy = "organizer")
	private Set<Event> events;

	
public Long getResourceId() {
		
		return this.id;
	}
	
	
	

	
}
