package com.devg.learning.app.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@RibbonClient(name = "products-service") Ribbon impementation no needed with Eureka
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class SpringbootItemsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootItemsServiceApplication.class, args);
	}

}
