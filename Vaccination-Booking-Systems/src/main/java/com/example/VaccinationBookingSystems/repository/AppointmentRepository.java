package com.example.VaccinationBookingSystems.repository;

import com.example.VaccinationBookingSystems.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
