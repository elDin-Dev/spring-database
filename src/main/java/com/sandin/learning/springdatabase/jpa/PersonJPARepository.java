package com.sandin.learning.springdatabase.jpa;

import com.sandin.learning.springdatabase.entity.Person;
import com.sandin.learning.springdatabase.jdbc.PersonJdbcDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonJPARepository {

    @PersistenceContext
    EntityManager entityManager;


    public Person findByID(int id) {

        return entityManager.find(Person.class, id);
    }
}
