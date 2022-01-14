package com.sandin.learning.springdatabase;

import com.sandin.learning.springdatabase.entity.Person;
import com.sandin.learning.springdatabase.jpa.PersonJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJPARepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("User with id 10002 : {}", repository.findByID(10002));

		/*
		logger.info("All users : {}", repository.findAll());



		logger.info("Users in BCN : {}", repository.findByLocation("BCN"));

		logger.info("Deleting user with id 10002. Rows:{}", repository.deleteById(10002));

		logger.info("Inserting a new user with id 10004. Rows affected: {}",
				repository.insert(new Person(
						10004,
						"Rubén",
						"MAD",
						new Date()))
		);

		logger.info("Updating a Person. Rows affected: {}", repository.update(repository.findByID(10004)));

		logger.info("All users : {}", repository.findAll());

		 */
	}
}
