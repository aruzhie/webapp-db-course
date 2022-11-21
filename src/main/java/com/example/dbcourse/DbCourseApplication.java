package com.example.dbcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.example.dbcourse.service", "com.example.dbcourse.controller", "com.example.dbcourse.model"})
//@EnableJpaRepositories("com.example.dbcourse.dao")
public class DbCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbCourseApplication.class, args);
	}

}
