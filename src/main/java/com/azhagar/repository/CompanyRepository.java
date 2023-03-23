package com.azhagar.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azhagar.entities.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Serializable> {

}
