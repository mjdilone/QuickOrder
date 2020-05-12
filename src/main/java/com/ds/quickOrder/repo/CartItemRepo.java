package com.ds.quickOrder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ds.quickOrder.model.CartItem;
import com.ds.quickOrder.model.CartItemEntity;

@Repository
public interface CartItemRepo extends JpaRepository<CartItemEntity, Integer> {
	@Modifying//this annotation is needed in order to allow @Query to use DDL queries and queries like insert
	@Query(value = "insert into cart_items (customer_id,date_updated,item_name,quantity) VALUES (:userId ,NOW(), :name, :quantity)" , nativeQuery = true)
	void saveWithTimeStamp(int userId, String name, int quantity);
	

	//the table might have to be worked on before you can use this repo method, test this out carefully
	@Modifying//this annotation is needed in order to allow @Query to use DDL queries and queries like insert
	@Query(value = "insert into guest_cart_items (customer_id,date_updated,item_name,quantity) VALUES (:userId ,NOW(), :name, :quantity)" , nativeQuery = true)
	void saveWithTimeStampGuest(int userId, String name, int quantity);


	@Query("select c from CartItemEntity c where customer_id  = :userId")
	List<CartItem> findByUserId(int userId);

	
	@Query("select g from GuestCartItemEntity g where customer_id = :userId")
	List<CartItem> findByGuestUserId(int userId);
	
	
	
	
	
//	String queryToCopyCartToPastOrders = "insert into past_order_items  select * from cart_items where customer_id = " + id; 
//	String queryToDeleteCart = "delete  from guest_cart_items where customer_id = " + id ;
	
	//copy to past orders
	@Transactional
	@Modifying
	@Query(value = "insert into past_order_items (customer_id,date_updated,item_name,quantity)  "
			+ "select customer_id,date_updated,item_name,quantity from cart_items where customer_id = :id", nativeQuery = true)
	void copyCartToPastOrders(int id);
	
	
	
//	//delete from cart
	//"delete  from guest_cart_items where customer_id = " + id ;
	@Transactional
	@Modifying
	@Query(value = "delete from cart_items where customer_id = :id", nativeQuery = true )
	void deleteWithCustomer_Id(int id);
	
	
	
	//copy to past orders
	@Transactional
	@Modifying
	@Query(value = "insert into past_order_items (customer_id,date_updated,item_name,quantity)  "
			+ "select customer_id,date_updated,item_name,quantity from guest_cart_items where customer_id = :id", nativeQuery = true)
	void copyGuestCartToPastOrders(int id);
	
	
	
//	//delete from cart
	//"delete  from guest_cart_items where customer_id = " + id ;
	@Transactional
	@Modifying
	@Query(value = "delete from guest_cart_items where customer_id = :id", nativeQuery = true )
	void deleteWithGuest_Id(int id);
	
	
	
	
	
	
	
	
	
	
	
	
}