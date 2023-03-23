package com.azhagar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azhagar.bindings.CompanyBinding;
import com.azhagar.service.ICompanyservice;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private ICompanyservice service;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody CompanyBinding comBinding) {
		String save = service.save(comBinding);
		return new ResponseEntity<String>(save, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody CompanyBinding comBinding) {
		String update = service.update(comBinding);
		return new ResponseEntity<String>(update, HttpStatus.OK);
	}

	@GetMapping("/view")
	public ResponseEntity<List<CompanyBinding>> viewAll() {
		List<CompanyBinding> viewAll = service.viewAll();
		return new ResponseEntity<List<CompanyBinding>>(viewAll, HttpStatus.OK);

	}

	@GetMapping("/edit/{compId}")
	public ResponseEntity<CompanyBinding> edit(@PathVariable("compId") String compId) {
		CompanyBinding edit = service.edit(compId);
		return new ResponseEntity<CompanyBinding>(edit, HttpStatus.OK);
	}

}
