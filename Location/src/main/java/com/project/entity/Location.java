package com.project.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "location_id")
	private long locationId;

	@Column(name = "location_Name")
	private String locationName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ld_fklocation_id", referencedColumnName = "location_id")
	List<Department> departments = new ArrayList<>();

}