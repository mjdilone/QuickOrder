package com.ds.quickOrder;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.quickOrder.model.AccountEntity;

public class Utils {
	public static String convertIntoTime(long time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yy hh.mm aa");
		
		return dateFormat.format(new Date(time));
	}
	
	public static void printAll(Collection<?> c){
		System.out.println("Utils.printAll() called");
		for(Object o : c) {
			System.out.println(o.toString());
		}
		System.out.println("Utils.printAll() end");
	}

	public static final String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
			+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
			+ "Ut enim ad minim veniam, "
			+ "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
			+ "Duis aute irure dolor in reprehenderit in "
			+ "voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
			+ "Excepteur sint occaecat cupidatat non proident, sunt in "
			+ "culpa qui officia deserunt mollit anim id est laborum.";
	
	
	public static void printAllRepo(JpaRepository repo) {
		List<?> list = repo.findAll();
		printAll(list);
	}	
}