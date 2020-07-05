package com.karadayi.eventmanagement.entities.projections;

import javax.persistence.Column;

import org.springframework.data.rest.core.config.Projection;

import com.karadayi.eventmanagement.entities.Participant;

@Projection(name = "partial",types = {Participant.class})
public interface ParticipantProjection {
	
	
	
	
		String getName();
		boolean isCheckIn();

}
