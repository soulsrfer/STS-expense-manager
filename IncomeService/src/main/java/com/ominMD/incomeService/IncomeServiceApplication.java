package com.ominMD.incomeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IncomeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncomeServiceApplication.class, args);
	}

}
