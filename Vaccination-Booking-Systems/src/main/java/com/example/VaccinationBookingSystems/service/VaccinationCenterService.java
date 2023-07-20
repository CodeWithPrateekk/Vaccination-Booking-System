package com.example.VaccinationBookingSystems.service;

import com.example.VaccinationBookingSystems.Model.VaccinationCenter;
import com.example.VaccinationBookingSystems.dto.RequestDto.VaccinationCenterRequestDto;
import com.example.VaccinationBookingSystems.dto.ResponseDto.VaccinationCenterResponseDto;
import com.example.VaccinationBookingSystems.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public VaccinationCenterResponseDto addCenter(VaccinationCenterRequestDto vaccinationCenterRequestDto) {
      // request dto -- >> entity

        VaccinationCenter center = new VaccinationCenter();
        center.setCenterName(vaccinationCenterRequestDto.getCenterName());
        center.setCenterType(vaccinationCenterRequestDto.getCenterType());
        center.setAddress(vaccinationCenterRequestDto.getAddress());

        VaccinationCenter savedCenter = vaccinationCenterRepository.save(center);

        //convert dtos -->> entity

        VaccinationCenterResponseDto vaccinationCenterResponseDto = new VaccinationCenterResponseDto();
        vaccinationCenterResponseDto.setCenterName(savedCenter.getCenterName());
        vaccinationCenterResponseDto.setCenterType(savedCenter.getCenterType());
        vaccinationCenterResponseDto.setAddress(savedCenter.getAddress());
        vaccinationCenterResponseDto.setMessage("Vaccination center has been added");
        return vaccinationCenterResponseDto;

    }
}
