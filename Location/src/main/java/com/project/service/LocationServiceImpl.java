package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Category;
import com.project.entity.Department;
import com.project.entity.Location;
import com.project.entity.Subcategory;
import com.project.repository.CategoryRepository;
import com.project.repository.DepartmentRepository;
import com.project.repository.LocationRepository;
import com.project.repository.SubcategoryRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository locationRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	SubcategoryRepository subcategoryRepository;

	public String createLocation(Location location) {
		location = locationRepository.save(location);
		System.out.println("LocationService.createLocation()" + location);
		return "Location Saved";
	}

	public List<Location> getLocation() {
		return locationRepository.findAll();
	}

	public Optional<Location> getLocationById(Long locationId) {
		return locationRepository.findById(locationId);
	}

	public Optional<Department> getDepartmentById(long departmentId) {
		return departmentRepository.findById(departmentId);
	}

	public Optional<Category> getCategoryById(long categoryId) {
		return categoryRepository.findById(categoryId);

	}

	public Optional<Subcategory> getSubCategoryById(long subcategoryId) {
		return subcategoryRepository.findById(subcategoryId);
	}

}
