package com.example.demo;

import com.example.controller.PetStoreController;
import com.example.model.PetStoreModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import javax.sql.DataSource;


@SpringBootApplication
//To can all packages under com.example. (to find controller)
@ComponentScan(basePackages = "com.example")
public class Mission4Application {

	public static void main(String[] args) {
		SpringApplication.run(Mission4Application.class, args);
	}
}
