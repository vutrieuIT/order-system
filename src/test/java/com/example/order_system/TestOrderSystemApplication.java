package com.example.order_system;

import org.springframework.boot.SpringApplication;

public class TestOrderSystemApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderSystemApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
