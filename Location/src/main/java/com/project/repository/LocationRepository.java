package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	Location findByLocationId(long locationId);

}
