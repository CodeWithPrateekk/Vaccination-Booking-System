package com.example.VaccinationBookingSystems.dto.RequestDto;

import com.example.VaccinationBookingSystems.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddPersonRequestDto {
    int id;
    String name;
    String emailId;
    int age;

    Gender gender;

}
