package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.entity.Category;
import com.project.entity.Department;
import com.project.entity.Location;
import com.project.entity.Subcategory;

@Service
public interface LocationService {

	public String createLocation(Location location);

	public List<Location> getLocation();

	public Optional<Location> getLocationById(Long locationId);

	public Optional<Department> getDepartmentById(long departmentId);

	public Optional<Category> getCategoryById(long categoryId);

	public Optional<Subcategory> getSubCategoryById(long subcategoryId);
}
