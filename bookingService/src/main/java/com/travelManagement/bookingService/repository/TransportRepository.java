package com.travelManagement.bookingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelManagement.bookingService.model.Vechical;

@Repository
public interface TransportRepository extends JpaRepository<Vechical, Long>{

}
