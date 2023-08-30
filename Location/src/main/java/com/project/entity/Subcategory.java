package com.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subcategory")
public class Subcategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subcategory_id")
	private Long subcategoryId;

	@Column(name = "subcategory_Name")
	private String subcategoryName;

}