package com.sandin.learning.springdatabase.jpa;

import com.sandin.learning.springdatabase.entity.Person;
import com.sandin.learning.springdatabase.jdbc.PersonJdbcDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class PersonJPARepository {

    @PersistenceContext
    EntityManager entityManager;


    public Person findByID(int id) {

        return entityManager.find(Person.class, id);
    }

    @Transactional
    public Person update(Person person ){
        return entityManager.merge(person);

    }

    @Transactional
    public Person insert(Person person ){
        return entityManager.merge(person);

    }


}

