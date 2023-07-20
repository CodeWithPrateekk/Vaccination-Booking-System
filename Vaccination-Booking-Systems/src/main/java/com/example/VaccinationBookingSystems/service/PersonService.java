package com.example.VaccinationBookingSystems.service;

import com.example.VaccinationBookingSystems.Model.Person;
import com.example.VaccinationBookingSystems.dto.RequestDto.AddPersonRequestDto;
import com.example.VaccinationBookingSystems.dto.ResponseDto.AddPersonResponseDto;
import com.example.VaccinationBookingSystems.exception.PeopleNotFoundException;
import com.example.VaccinationBookingSystems.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public AddPersonResponseDto addPerson(AddPersonRequestDto addPersonRequestDto) {

        // Convert requestDTO to Entity

        Person person = new Person();

        person.setAge(addPersonRequestDto.getAge());
        person.setName(addPersonRequestDto.getName());
        person.setGender(addPersonRequestDto.getGender());
        person.setEmailId(addPersonRequestDto.getEmailId());
        person.setDose1Taken(false);
        person.setDose2Taken(false);
        person.setCertificate(null);

       Person savedResponse =  personRepository.save(person);
       // change dto --> entity
       AddPersonResponseDto addPersonResponseDto = new AddPersonResponseDto();
       addPersonResponseDto.setName(person.getName());
       addPersonResponseDto.setMessage("Congrats! You have been registered ");

       return addPersonResponseDto;


    }



    public String updateEmail(String oldEmail, String newEmail) {

        Person person = personRepository.findByEmailId(oldEmail);
        if(person==null){
            throw new PeopleNotFoundException("Email doesn't exists");
        }

        person.setEmailId(newEmail);
        personRepository.save(person);

        return "EmailId has been updated";
    }
}
