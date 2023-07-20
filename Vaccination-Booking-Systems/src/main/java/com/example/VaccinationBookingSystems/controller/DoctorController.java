package com.example.VaccinationBookingSystems.controller;

import com.example.VaccinationBookingSystems.dto.RequestDto.AddDoctorRequestDto;
import com.example.VaccinationBookingSystems.dto.ResponseDto.AddDoctorResponseDto;
import com.example.VaccinationBookingSystems.exception.VaccinationCenterNotFoundException;
import com.example.VaccinationBookingSystems.repository.DoctorRepository;
import com.example.VaccinationBookingSystems.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody AddDoctorRequestDto addDoctorRequestDto){
        try {
            AddDoctorResponseDto addDoctorResponseDto = doctorService.addDoctor(addDoctorRequestDto);
            return new ResponseEntity(addDoctorResponseDto, HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
