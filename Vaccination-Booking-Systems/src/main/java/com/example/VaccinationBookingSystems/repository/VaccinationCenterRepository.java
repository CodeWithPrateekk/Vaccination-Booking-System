package com.example.VaccinationBookingSystems.repository;

import com.example.VaccinationBookingSystems.Model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {
}
