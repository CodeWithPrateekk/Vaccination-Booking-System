package com.example.VaccinationBookingSystems.repository;

import com.example.VaccinationBookingSystems.Model.Doctor;
import com.example.VaccinationBookingSystems.dto.RequestDto.AddDoctorRequestDto;
import com.example.VaccinationBookingSystems.dto.ResponseDto.AddDoctorResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}