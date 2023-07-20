package com.example.VaccinationBookingSystems.controller;

import com.example.VaccinationBookingSystems.dto.RequestDto.BookAppointmentRequestDto;
import com.example.VaccinationBookingSystems.dto.ResponseDto.BookAppointmentResponseDto;
import com.example.VaccinationBookingSystems.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity bookAppointment(@RequestBody BookAppointmentRequestDto bookAppointmentRequestDto) {
        try {
            BookAppointmentResponseDto bookAppointmentResponseDto = appointmentService.bookAppointment(bookAppointmentRequestDto);
            return new ResponseEntity(bookAppointmentResponseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
