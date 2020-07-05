package com.karadayi.eventmanagement.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.karadayi.eventmanagement.entities.Participant;
import com.karadayi.eventmanagement.entities.projections.ParticipantProjection;


@RepositoryRestResource(excerptProjection = ParticipantProjection.class)
public interface ParticapantRepository extends PagingAndSortingRepository<Participant, Long> {
	
	Page<Participant> findByEmail(@Param("email")   String email,Pageable pageable);
	

}
