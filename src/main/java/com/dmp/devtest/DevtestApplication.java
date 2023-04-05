package com.dmp.devtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@ComponentScan({"com.dmp.devtest.controller","com.dmp.devtest.service","com.dmp.devtest.persistence","com.dmp.devtest.rest","com.dmp.devtest"})
@Import({Config.class,Security.class})
@EnableJpaRepositories
public class DevtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevtestApplication.class, args);
	}

}
