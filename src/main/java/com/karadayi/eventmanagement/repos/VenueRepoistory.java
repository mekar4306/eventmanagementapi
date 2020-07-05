package com.karadayi.eventmanagement.repos;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.karadayi.eventmanagement.entities.Venue;

public interface VenueRepoistory extends PagingAndSortingRepository<Venue, Long> {
	
	Page<Venue> findByPostalCode(@Param("postalCode") String postalCode,Pageable  pageable);
	
	
	//http://localhost:8080/eventmanagement-api/venues/search/findByPostalCode?postalCode=78755

}
