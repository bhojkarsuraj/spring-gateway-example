package com.spring.gateway.springgatewayexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringGatewayExampleApplication {

	public static void main(String[] args) {

		try {
			System.out.println(" In main");
			SpringApplication.run(SpringGatewayExampleApplication.class, args);
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}