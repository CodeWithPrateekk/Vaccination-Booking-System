package com.example.VaccinationBookingSystems.controller;

import com.example.VaccinationBookingSystems.Model.Person;
import com.example.VaccinationBookingSystems.dto.RequestDto.AddPersonRequestDto;
import com.example.VaccinationBookingSystems.dto.ResponseDto.AddPersonResponseDto;
import com.example.VaccinationBookingSystems.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/add")
    public ResponseEntity addPerson(@RequestBody AddPersonRequestDto addPersonRequestDto){
        try {
            AddPersonResponseDto personResponse = personService.addPerson(addPersonRequestDto);
            return new ResponseEntity<>(personResponse,HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


}
