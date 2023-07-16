package com.example.VaccinationBookingSystems.service;

import com.example.VaccinationBookingSystems.Model.Dose;
import com.example.VaccinationBookingSystems.Model.Person;
import com.example.VaccinationBookingSystems.dto.RequestDto.BookDose1RequestDto;
import com.example.VaccinationBookingSystems.exception.DoseAlreadyTakenException;
import com.example.VaccinationBookingSystems.exception.PeopleNotFoundException;
import com.example.VaccinationBookingSystems.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class DoseService {


    @Autowired
    PersonRepository personRepository;

////    public Dose getDose1(int personId, DoseType doseType) {
////        Optional<Person> optionalPerson = personRepository.findById(personId);
////
////        // check if person exists or not
////        if(!optionalPerson.isPresent())
////            throw new PeopleNotFoundException("Invalid PersonID");
////
////        Person person = optionalPerson.get();
////
////
////
////
////        // check if dose 1 is already taken
////        if(person.isDose1Taken())
////             throw new DoseAlreadyTakenException("Dose 1 already taken");
////
////        // create new dose
////        Dose dose = new Dose();
////        dose.setDoseId(String.valueOf(UUID.randomUUID()));
////        dose.setDoseType(doseType);
////        dose.setPerson(person);
////
////        person.setDose1Taken(true);
////
////        Person savedPerson = personRepository.save(person);
////
////        return savedPerson.getDosesTaken().get(0);
//
//    }


    public Dose getDose1(BookDose1RequestDto bookDose1RequestDto) {
        Optional<Person> optionalPerson = personRepository.findById(bookDose1RequestDto.getPersonId());

        // check if person exists or not
        if (!optionalPerson.isPresent())
            throw new PeopleNotFoundException("Invalid PersonID");

        Person person = optionalPerson.get();


        // check if dose 1 is already taken
        if (person.isDose1Taken())
            throw new DoseAlreadyTakenException("Dose 1 already taken");

        // create new dose
        Dose dose = new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(bookDose1RequestDto.getDoseType());
        dose.setPerson(person);

        person.setDose1Taken(true);

        Person savedPerson = personRepository.save(person);

        return savedPerson.getDosesTaken().get(0);
    }
}
