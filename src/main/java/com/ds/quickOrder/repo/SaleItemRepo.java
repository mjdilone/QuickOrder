package com.ds.quickOrder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.SaleItem;
import com.ds.quickOrder.model.SaleItemEntity;

@Repository
public interface SaleItemRepo  extends JpaRepository<SaleItemEntity, Integer> {
	//the table name in the annotation's query must be the name of your entity class, NOT the table
	@Query("select s from SaleItemEntity s where name like %:nameBuilder%")
	List<SaleItem> searchWithName(@Param("nameBuilder")String nameBuilder);
	
	@Query("select s from SaleItemEntity s where name = (:name)")
	SaleItem findByName(String name);

	@Query("select s from SaleItemEntity s where category = (:categoryId)")
	List<SaleItem> findByCategory(int categoryId);
	
	
}