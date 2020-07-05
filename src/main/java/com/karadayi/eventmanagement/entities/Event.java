package com.karadayi.eventmanagement.entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonPropertyOrder(value = {"started"})
public class Event extends AbstractEntity {
	
	
	private String name;
	
	@JsonProperty("aciklama")
	private String description;

	
	private ZonedDateTime  startTime;
	private ZonedDateTime  endTime;
	
	
	private ZoneId zoneId;
	
	private boolean started;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "ID",nullable = false)
	private Organizer organizer;
	
	
	@OneToMany(mappedBy = "event",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Participant> participants;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@RestResource(exported = false)
	private Venue venue;

	
	public Long getResourceId() {
		
		return this.id;
	}
	
	
}


