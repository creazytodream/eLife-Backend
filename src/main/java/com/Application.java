package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 启动入口
 */
@SpringBootApplication
@EnableAsync
public class Application extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		//application.listeners(new JdbcPropertiesLoader());
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		//application.addListeners(new JdbcPropertiesLoader());
		application.run(args);
	}
}