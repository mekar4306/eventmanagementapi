package com.karadayi.eventmanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.karadayi.eventmanagement.entities.Participant;
import com.karadayi.eventmanagement.exceptions.AlreadyCheckedInException;
import com.karadayi.eventmanagement.exceptions.NotCheckInException;
import com.karadayi.eventmanagement.repos.ParticapantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckInController {

	@Autowired
	ParticapantRepository particapantRepository;

	@PostMapping("/checkIn/{id}")
	public ResponseEntity<PersistentEntityResource> createCheckIn(@PathVariable Long id,PersistentEntityResourceAssembler assembler) {

		Participant participant = particapantRepository.findById(id).get();

		if (participant != null) {

			if (participant.isCheckIn()) {
				throw new AlreadyCheckedInException();
			}

			participant.setCheckIn(true);
			particapantRepository.save(participant);

		}

		return ResponseEntity.ok(assembler.toFullResource(participant));
	}
	
	
	
	@PostMapping("/checkOut/{id}")
    public ResponseEntity<PersistentEntityResource> createCheckOut(@PathVariable Long id,PersistentEntityResourceAssembler assembler){
    	
    	
    	Participant participant = particapantRepository.findById(id).get();
    	
    	if (participant!=null) {
    		
    		if(!participant.isCheckIn()){
    			
    			throw new NotCheckInException();
    			
    		}
    		
    		participant.setCheckIn(false);
    		particapantRepository.save(participant);
			
		}
    	
    	
    	return ResponseEntity.ok(assembler.toFullResource(participant));
    }
	
	
}
