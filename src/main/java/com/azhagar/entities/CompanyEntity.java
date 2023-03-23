package com.azhagar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Table(name = "company_tbl", schema = "company", indexes = @Index(columnList = "comp_name"))
@Entity
public class CompanyEntity {

	@Id
	@GeneratedValue(generator = "custom_compId")
	@GenericGenerator(strategy = "com.azhagar.IdGenerator.CompanyIDGenerator", name = "custom_compId")
	private String compId;

	@Column(name = "comp_name", length = 25, nullable = false, unique = true)
	private String compName;

	@Column(name = "address", length = 200, nullable = false, unique = true)
	private String address;

	@Column(name = "panno", length = 10, nullable = false, unique = true)
	private String panNo;

	@Column(name = "tinno", length = 11, nullable = false)
	private String tinNo;

	@Column(name = "city", length = 25, nullable = false)
	private String city;

	@Column(name = "state", length = 25, nullable = false)
	private String state;
}
