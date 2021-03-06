package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动入口
 */
@SpringBootApplication
@EnableAsync
//@EnableEurekaClient
@EnableScheduling
public class ElifeApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		//application.listeners(new JdbcPropertiesLoader());
		return application.sources(ElifeApplication.class);
	}

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(ElifeApplication.class);
		//application.addListeners(new JdbcPropertiesLoader());
		application.run(args);
	}
}