package com.ds.quickOrder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ds.quickOrder.model.AccountEntity;
import com.ds.quickOrder.model.PastOrderItem;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, Integer> {
	
	/*
	 	quick implementation of a custom query, the passed value has to share the same name as the variable 
	 	being used in the SQL query and the entity's corresponding value also needs corresponding getters
	 	and setters 
	 */

	//the table name in the annotation's query must be the name of your entity class, NOT the table
	@Query("select a from AccountEntity a where account_name = (:account_name)")
	AccountEntity findByAccount_Name(String account_name);
	
	//retrieve past orders
	//String query = "select * from past_order_items where customer_name = " + username;
//	@Query("select p from PastOrderEntity p where  ")
//	List<PastOrderItem> findPastOrders(String account_name);
	
//	String query = "select * from past_order_items where customer_id = " + userId;
	@Query("select p from PastOrderItemEntity p where customer_id = (:userId)")
	List<PastOrderItem> findPastOrders(int userId);
	
	

	
}