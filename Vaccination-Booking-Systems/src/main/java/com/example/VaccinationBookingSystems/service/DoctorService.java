package com.example.VaccinationBookingSystems.service;

import com.example.VaccinationBookingSystems.Model.Doctor;
import com.example.VaccinationBookingSystems.Model.VaccinationCenter;
import com.example.VaccinationBookingSystems.dto.RequestDto.AddDoctorRequestDto;
import com.example.VaccinationBookingSystems.dto.ResponseDto.AddDoctorResponseDto;
import com.example.VaccinationBookingSystems.dto.ResponseDto.VaccinationCenterResponseDto;
import com.example.VaccinationBookingSystems.exception.VaccinationCenterNotFoundException;
import com.example.VaccinationBookingSystems.repository.DoctorRepository;
import com.example.VaccinationBookingSystems.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public AddDoctorResponseDto addDoctor(AddDoctorRequestDto addDoctorRequestDto) {

        Optional<VaccinationCenter> vaccinationCenterOptional = vaccinationCenterRepository.findById(addDoctorRequestDto.getCenterId());
        if(vaccinationCenterOptional.isEmpty()){
            throw new VaccinationCenterNotFoundException("Center not found");
        }

        VaccinationCenter center = vaccinationCenterOptional.get();



        // RequestDto --->>> entity
        Doctor doctor = new Doctor();
        doctor.setAge(addDoctorRequestDto.getAge());
        doctor.setGender(addDoctorRequestDto.getGender());
        doctor.setName(addDoctorRequestDto.getName());
        doctor.setEmailId(addDoctorRequestDto.getEmailId());
        doctor.setCenter(center);

        //getting center details

        // adding doctor to the center
        center.getDoctors().add(doctor);
        VaccinationCenter savedCenter = vaccinationCenterRepository.save(center);

        List<Doctor> savedDoctors = center.getDoctors();
        Doctor latestSavedDoctor = savedDoctors.get(savedDoctors.size()-1);


        //Doctor saveddoctor = doctorRepository.save(doctor);



        // entity -- >> responseDto

        VaccinationCenterResponseDto vaccinationCenterResponseDto=new VaccinationCenterResponseDto();

        vaccinationCenterResponseDto.setCenterName(savedCenter.getCenterName());
        vaccinationCenterResponseDto.setCenterType(savedCenter.getCenterType());
        vaccinationCenterResponseDto.setAddress(savedCenter.getAddress());
        vaccinationCenterResponseDto.setMessage("Congrats! Your center hasbeen located");

        AddDoctorResponseDto addDoctorResponseDto = new AddDoctorResponseDto();

        addDoctorResponseDto.setName(doctor.getName());
        addDoctorResponseDto.setMessage("Doctor hasbeen added successfully");


        addDoctorResponseDto.setVaccinationCenterResponseDto(vaccinationCenterResponseDto);



        return addDoctorResponseDto;


    }
}
