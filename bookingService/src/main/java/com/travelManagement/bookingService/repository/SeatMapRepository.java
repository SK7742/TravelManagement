package com.travelManagement.bookingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelManagement.bookingService.model.SeatMap;

@Repository
public interface SeatMapRepository extends JpaRepository<SeatMap, Long>{

}
