package com.devg.learning.app.items;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

//@RibbonClient(name = "products-service") Ribbon impementation no needed with Eureka
@EnableHystrix
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class SpringbootItemsServiceApplication {

	private static ConfigurableApplicationContext ctx;

	public static void main(String[] args) {
		ctx = SpringApplication.run(SpringbootItemsServiceApplication.class, args);
	}

	public static void restartApplicationContext() {
		ApplicationArguments appArgs = ctx.getBean(ApplicationArguments.class);		
		Thread thread = new Thread(() -> {
			ctx.close();
			SpringApplication.run(SpringbootItemsServiceApplication.class, appArgs.getSourceArgs());
		});
		thread.setDaemon(false);
		thread.start();
	}

}
