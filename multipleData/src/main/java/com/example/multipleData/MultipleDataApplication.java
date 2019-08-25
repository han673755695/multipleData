package com.example.multipleData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.example.multipleData.datasource.DBConfig1;
import com.example.multipleData.datasource.DBConfig2;

@SpringBootApplication
public class MultipleDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDataApplication.class, args);
	}

}
