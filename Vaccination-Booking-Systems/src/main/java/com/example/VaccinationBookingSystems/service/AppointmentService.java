package com.example.VaccinationBookingSystems.service;

import com.example.VaccinationBookingSystems.Model.Appointment;
import com.example.VaccinationBookingSystems.Model.Doctor;
import com.example.VaccinationBookingSystems.Model.Person;
import com.example.VaccinationBookingSystems.dto.RequestDto.BookAppointmentRequestDto;
import com.example.VaccinationBookingSystems.dto.ResponseDto.BookAppointmentResponseDto;
import com.example.VaccinationBookingSystems.dto.ResponseDto.VaccinationCenterResponseDto;
import com.example.VaccinationBookingSystems.exception.DoctorNotFoundException;
import com.example.VaccinationBookingSystems.exception.PeopleNotFoundException;
import com.example.VaccinationBookingSystems.repository.AppointmentRepository;
import com.example.VaccinationBookingSystems.repository.DoctorRepository;
import com.example.VaccinationBookingSystems.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.time.Period;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService{

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public BookAppointmentResponseDto bookAppointment(BookAppointmentRequestDto bookAppointmentRequestDto) {

        Optional<Person> personOptional = personRepository.findById(bookAppointmentRequestDto.getPersonId());
        if(personOptional.isEmpty()){
            throw new PeopleNotFoundException("Invalid person id");
        }

        Person person = personOptional.get();

        Optional<Doctor> doctorOptional = doctorRepository.findById(bookAppointmentRequestDto.getDoctorId());
        if(doctorOptional.isEmpty()){
            throw new DoctorNotFoundException("Invalid doctor id");
        }

        Doctor doctor = doctorOptional.get();

        // entity -->> request dto

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setPerson(person);
        appointment.setDoctor(doctor);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        doctor.getAppointments().add(savedAppointment);
        person.getAppointments().add(savedAppointment);

        Person savedPerson = personRepository.save(person);
        Doctor savedDoctor = doctorRepository.save(doctor);


        //send  an email confirmation along with the details of the appointment

        String text = "Congrats!! "+savedPerson.getName()+" Your appointment has been booked with Doctor "+
                savedDoctor.getName() + ". Your vaccination center name is: "
                + savedDoctor.getCenter().getCenterName() + " Please reach at this address "+
                savedDoctor.getCenter().getAddress() + " at this time: "
                + savedAppointment.getAppointmentDate()+" Dhanyawad!!!";


        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("bharatVaccination.gov@gmail.com");
        simpleMailMessage.setTo(person.getEmailId());
        simpleMailMessage.setSubject("Your appointment has been booked successfully");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);




        // now make response dto


        VaccinationCenterResponseDto vaccinationCenterResponseDto = new VaccinationCenterResponseDto();
        vaccinationCenterResponseDto.setCenterName(savedDoctor.getCenter().getCenterName());
        vaccinationCenterResponseDto.setCenterType(savedDoctor.getCenter().getCenterType());
        vaccinationCenterResponseDto.setAddress(savedDoctor.getCenter().getAddress());


        BookAppointmentResponseDto bookAppointmentResponseDto = new BookAppointmentResponseDto();
        bookAppointmentResponseDto.setPersonName(savedPerson.getName());
        bookAppointmentResponseDto.setDoctorName(savedDoctor.getName());
        bookAppointmentResponseDto.setAppointmentId(savedAppointment.getAppointmentId());
        bookAppointmentResponseDto.setAppointmentDate(savedAppointment.getAppointmentDate());


        bookAppointmentResponseDto.setVaccinationCenterResponseDto(vaccinationCenterResponseDto);

        return bookAppointmentResponseDto;

    }







}
