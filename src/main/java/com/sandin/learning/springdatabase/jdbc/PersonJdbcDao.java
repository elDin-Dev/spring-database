package com.sandin.learning.springdatabase.jdbc;

import com.sandin.learning.springdatabase.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {

        return jdbcTemplate.query("SELECT * FROM PERSON",
                new BeanPropertyRowMapper<Person>(Person.class));
        
    }

    public Person findByID(int id) {

        return jdbcTemplate.queryForObject(
                "SELECT * FROM PERSON WHERE id=?",
                new Object[] {id},
                new BeanPropertyRowMapper<Person>(Person.class)
                );
   }

    public List<Person> findByLocation(String location) {


        return jdbcTemplate.query(
                "SELECT * FROM PERSON WHERE LOCATION=?",
                new Object[] {location},
                new BeanPropertyRowMapper<Person>(Person.class)
        );
    }

}
