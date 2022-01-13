package com.sandin.learning.springdatabase.jdbc;

import com.sandin.learning.springdatabase.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {

        return jdbcTemplate.query("SELECT * FROM PERSON",
                new BeanPropertyRowMapper(Person.class));
        
    }
}
