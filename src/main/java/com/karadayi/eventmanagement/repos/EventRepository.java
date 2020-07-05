package com.karadayi.eventmanagement.repos;

import java.time.ZoneId;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.karadayi.eventmanagement.entities.Event;
import com.karadayi.eventmanagement.entities.projections.PartialEventProjection;


@RepositoryRestResource(excerptProjection = PartialEventProjection.class)
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	
	Page<Event> findByName(@Param("name") String name,Pageable Pageable);

	
	Page<Event> findByNameAndZoneId(@Param("name") String name,@Param("zoneId") ZoneId zoneId,Pageable Pageable);
	
	
	@Override
	@PreAuthorize("hasRole(`ADMIN`)") 
	 void deleteById(Long id) ;
}