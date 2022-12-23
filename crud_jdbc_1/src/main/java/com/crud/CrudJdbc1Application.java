package com.crud;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CrudJdbc1Application {

	public static void main(String[] args) {
		SpringApplication.run(CrudJdbc1Application.class, args);
	}

}
