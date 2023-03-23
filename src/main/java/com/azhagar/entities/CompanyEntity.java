package com.azhagar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.azhagar.IdGenerator.StringPrefixedSequenceIdGenerator;

import lombok.Data;

@Data
@Table(name = "company_tbl", schema = "company", indexes = @Index(columnList = "comp_name"))
@Entity
public class CompanyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comp_seq")
	@GenericGenerator(name = "comp_seq", strategy = "com.azhagar.IdGenerator.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "DL"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
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
