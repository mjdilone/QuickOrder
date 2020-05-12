package com.ds.quickOrder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.quickOrder.model.PastOrderItemEntity;

@Repository
public interface PastOrderItemRepo  extends JpaRepository<PastOrderItemEntity, Integer> {
	
}
