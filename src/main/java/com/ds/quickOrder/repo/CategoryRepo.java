package com.ds.quickOrder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.CategoryEntity;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {

	@Query("select c from CategoryEntity c where name = :name")
	Category findByName(String name);
	
}
