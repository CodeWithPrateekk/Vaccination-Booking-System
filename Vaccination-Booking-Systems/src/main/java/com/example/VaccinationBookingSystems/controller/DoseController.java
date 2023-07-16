package com.example.VaccinationBookingSystems.controller;

import com.example.VaccinationBookingSystems.Model.Dose;
import com.example.VaccinationBookingSystems.dto.RequestDto.BookDose1RequestDto;
import com.example.VaccinationBookingSystems.service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

  //  @PostMapping("/get_dose_1")
//    public ResponseEntity getDose1(@RequestParam("id") int personId , @RequestParam("doseType") DoseType doseType) {
//
//        try {
//            Dose doseTake = doseService.getDose1(personId, doseType);
//            return new ResponseEntity(doseTake, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
  @PostMapping("/get_dose_1")
    public ResponseEntity getDose1(@RequestBody BookDose1RequestDto bookDose1RequestDto) {

        try {
            Dose doseTake = doseService.getDose1(bookDose1RequestDto);
            return new ResponseEntity(doseTake, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
