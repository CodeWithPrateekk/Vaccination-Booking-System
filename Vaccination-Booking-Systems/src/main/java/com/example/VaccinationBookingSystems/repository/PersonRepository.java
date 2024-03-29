package com.example.VaccinationBookingSystems.repository;

import com.example.VaccinationBookingSystems.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByEmailId(String oldEmailId);
}
