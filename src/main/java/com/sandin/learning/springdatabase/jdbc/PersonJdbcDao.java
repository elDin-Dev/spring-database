package com.sandin.learning.springdatabase.jdbc;

import com.sandin.learning.springdatabase.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {

        return jdbcTemplate.query("SELECT * FROM PERSON",
                new PersonRowMapper());
        
    }

    public Person findByID(int id) {

        return jdbcTemplate.queryForObject(
                "SELECT * FROM PERSON WHERE id=?",
                new Object[] {id},
                new PersonRowMapper()
                );
   }

    public List<Person> findByLocation(String location) {


        return jdbcTemplate.query(
                "SELECT * FROM PERSON WHERE LOCATION=?",
                new Object[] {location},
                new PersonRowMapper()
        );
    }

    public int deleteById( int id){

        return jdbcTemplate.update("DELETE FROM PERSON WHERE ID=?",new Object[] {id});
    }

    public int insert(Person person){
        return jdbcTemplate.update(
                "INSERT INTO PERSON\n" +
                    " (ID, NAME, LOCATION, BIRTH_DATE  )\n" +
                    "VALUES (?, ?, ?, ?);",
                    new Object[] {
                            person.getId(),
                            person.getName(),
                            person.getLocation(),
                            new Timestamp(person.getBirthDate().getTime())
                    });

    }
    public int update(Person person) {

        return jdbcTemplate.update(
                "UPDATE PERSON SET NAME=?, LOCATION=?, BIRTH_DATE=? WHERE ID =?",
                new Object[] {person.getName(), person.getLocation(), person.getBirthDate(), person.getId()});
    }

    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;
        }
    }
}
