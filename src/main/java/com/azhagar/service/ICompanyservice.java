package com.azhagar.service;

import java.util.List;

import com.azhagar.bindings.CompanyBinding;

public interface ICompanyservice {
	
	
	String save(CompanyBinding companyBinding);
	
	String update(CompanyBinding companyBinding);
	
	List<CompanyBinding> viewAll();
	
	CompanyBinding edit(String compId);
	
	

}
