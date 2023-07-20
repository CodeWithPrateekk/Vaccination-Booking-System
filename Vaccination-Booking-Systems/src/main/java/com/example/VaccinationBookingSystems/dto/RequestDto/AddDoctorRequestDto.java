package com.example.VaccinationBookingSystems.dto.RequestDto;

import com.example.VaccinationBookingSystems.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class AddDoctorRequestDto {

    String name;

    int age;

    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;

    int centerId;


}
