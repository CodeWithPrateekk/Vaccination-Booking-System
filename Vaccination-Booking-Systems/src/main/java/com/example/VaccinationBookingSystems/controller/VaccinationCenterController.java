package com.example.VaccinationBookingSystems.controller;

import com.example.VaccinationBookingSystems.dto.RequestDto.VaccinationCenterRequestDto;
import com.example.VaccinationBookingSystems.dto.ResponseDto.VaccinationCenterResponseDto;
import com.example.VaccinationBookingSystems.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {
    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add-center")
    public ResponseEntity addCenter(@RequestBody VaccinationCenterRequestDto vaccinationCenterRequestDto) {

        VaccinationCenterResponseDto centerResponseDto = vaccinationCenterService.addCenter(vaccinationCenterRequestDto);
        return new ResponseEntity(centerResponseDto, HttpStatus.ACCEPTED);
    }

}
