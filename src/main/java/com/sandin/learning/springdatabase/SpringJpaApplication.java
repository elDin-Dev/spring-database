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

		logger.info("Inserting a new user with. Rows affected: {}",
				repository.insert(new Person(
						"Rubén",
						"MAD",
						new Date()))
		);

		logger.info("Inserting a new user with. Rows affected: {}",
				repository.insert(new Person(
						"Alex",
						"BCN",
						new Date()))
		);

		logger.info("Inserting a new user with. Rows affected: {}",
				repository.insert(new Person(
						"Vicente",
						"BCN",
						new Date()))
		);


		logger.info("Searching a user with id 1 : {}", repository.findByID(1));

	}
}
