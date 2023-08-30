package com.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Category;
import com.project.entity.Department;
import com.project.entity.Location;
import com.project.entity.Subcategory;
import com.project.service.LocationService;

@RestController
@RequestMapping("/api/v1")
public class LocationController {

	@Autowired
	LocationService locationService;

	@PostMapping
	public ResponseEntity<?> createLocation(@RequestBody Location location) {
		return new ResponseEntity<>(locationService.createLocation(location), HttpStatus.CREATED);
	}

	@GetMapping("/location")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<?> getLocations() {
		return new ResponseEntity<>(locationService.getLocation(), HttpStatus.OK);
	}

	@GetMapping("/{location_id}/department")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> getLocationById(@PathVariable("location_id") long locationId) {
		Optional<Location> result = locationService.getLocationById(locationId);
		if (result.isPresent())
			return new ResponseEntity<>(result.get(), HttpStatus.OK);
		return new ResponseEntity<>("Location not found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{location_id}/department/{department_id}/category")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> getDepartmentById(@PathVariable("location_id") long locationId,
			@PathVariable("department_id") long departmentId) {
		Optional<Department> result = locationService.getDepartmentById(departmentId);
		if (result.isPresent())
			return new ResponseEntity<>(result.get(), HttpStatus.OK);
		return new ResponseEntity<>("Department not found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{location_id}/department/{department_id}/category/{category_id}/subcategory")
	public ResponseEntity<?> getCategoryById(@PathVariable("location_id") long locationId,
			@PathVariable("department_id") long departmentId, @PathVariable("category_id") long categoryId) {
		Optional<Category> result = locationService.getCategoryById(categoryId);
		if (result.isPresent())
			return new ResponseEntity<>(result.get(), HttpStatus.OK);
		return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{location_id}/department/{department_id}/category/{category_id}/subcategory/{subcategory_id}")
	public ResponseEntity<?> getSubCategoryById(@PathVariable("location_id") long locationId,
			@PathVariable("department_id") long departmentId, @PathVariable("category_id") long categoryId,
			@PathVariable("subcategory_id") long subcategoryId) {
		Optional<Subcategory> result = locationService.getSubCategoryById(subcategoryId);
		if (result.isPresent())
			return new ResponseEntity<>(result.get(), HttpStatus.OK);
		return new ResponseEntity<>("Subcategory not found", HttpStatus.NOT_FOUND);
	}

}
