package com.vtxlab.demo.helloworld.bc_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BcCalculatorApplication {
	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(BcCalculatorApplication.class, args);
	}

}
