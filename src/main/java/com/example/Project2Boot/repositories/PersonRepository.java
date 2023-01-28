package com.example.Project2Boot.repositories;


import com.example.Project2Boot.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByEmail(String email);

    List<Person> findBySurnameLike(String surnameLike);

}
