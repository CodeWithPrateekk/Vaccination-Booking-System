package com.example.VaccinationBookingSystems.dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class AddDoctorResponseDto {

    String name;

    String message;

    VaccinationCenterResponseDto vaccinationCenterResponseDto;

}
