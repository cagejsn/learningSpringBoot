package com.learning.demo.jpa;

import com.learning.demo.model.Bet;
import com.learning.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {



}
