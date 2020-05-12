package com.ds.quickOrder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.quickOrder.model.UserEntity;

@Repository
public interface UserRepo  extends JpaRepository<UserEntity, Integer> {
	
}
