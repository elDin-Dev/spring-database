package com.sandin.learning.springdatabase;

import com.sandin.learning.springdatabase.entity.Person;
import com.sandin.learning.springdatabase.jpa.PersonJPARepository;
import com.sandin.learning.springdatabase.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Inserting a new user with. Rows affected: {}",
				repository.save(new Person(
						"Rubén",
						"MAD",
						new Date()))
		);

		logger.info("Inserting a new user with. Rows affected: {}",
				repository.save(new Person(
						"Alex",
						"BCN",
						new Date()))
		);

		logger.info("Inserting a new user with. Rows affected: {}",
				repository.save(new Person(
						"Vicente",
						"BCN",
						new Date()))
		);


		logger.info("Searching a user with id 1 : {}", repository.findById(1));

		repository.deleteById(1);
		logger.info("Delete user by id 1.");

		logger.info("Searching a user with id 1 : {}", repository.findById(1));

		logger.info("Listing all person {}", repository.findAll());

	}
}
