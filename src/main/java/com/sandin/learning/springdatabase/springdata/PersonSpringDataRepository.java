package com.sandin.learning.springdatabase.springdata;

import com.sandin.learning.springdatabase.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository
        extends JpaRepository<Person, Integer> {
}
