package com.sandin.learning.springdatabase;

import com.sandin.learning.springdatabase.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDatabaseApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users : {}", dao.findAll());

		logger.info("User with id 10002 : {}", dao.findByID(10002));

		logger.info("Users in BCN : {}", dao.findByLocation("BCN"));
	}
}
