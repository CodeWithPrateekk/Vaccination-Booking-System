package com.example.VaccinationBookingSystems.repository;

import com.example.VaccinationBookingSystems.Model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer>{
}
