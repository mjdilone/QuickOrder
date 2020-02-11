package com.ds.quickOrder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuickOrderApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(QuickOrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}