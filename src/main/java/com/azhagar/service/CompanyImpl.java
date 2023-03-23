package com.azhagar.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhagar.bindings.CompanyBinding;
import com.azhagar.entities.CompanyEntity;
import com.azhagar.exception.CompanyNotFoundException;
import com.azhagar.repository.CompanyRepository;

@Service
public class CompanyImpl implements ICompanyservice {

	@Autowired
	private CompanyRepository repo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String save(CompanyBinding companyBinding) {

		CompanyEntity comEntity = new CompanyEntity();
		BeanUtils.copyProperties(companyBinding, comEntity);
		CompanyEntity save = repo.save(comEntity);
		return "Company Name Created  Id is" + save.getCompId();
	}

	@Override
	public String update(CompanyBinding companyBinding) {
		CompanyEntity comEntity = new CompanyEntity();
		modelMapper.map(companyBinding, comEntity);
		return repo.save(comEntity).getCompName() + " details has been updated";
	}

	@Override
	public List<CompanyBinding> viewAll() {
		Function<CompanyEntity, CompanyBinding> compBind = comp -> modelMapper.map(comp, CompanyBinding.class);
		return repo.findAll().stream().map(compBind).collect(Collectors.toList());
	}

	@Override
	public CompanyBinding edit(String compId) {
		CompanyBinding compBinding = new CompanyBinding();
		Optional<CompanyEntity> findById = repo.findById(compId);
		findById.ifPresent(comp -> BeanUtils.copyProperties(comp, compBinding));
		findById.orElseThrow(() -> new CompanyNotFoundException(compId + "NOT FOUND"));
		return compBinding;
	}

}
