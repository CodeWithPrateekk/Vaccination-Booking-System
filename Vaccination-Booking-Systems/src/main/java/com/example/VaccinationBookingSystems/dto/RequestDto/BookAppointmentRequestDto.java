package com.example.VaccinationBookingSystems.dto.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookAppointmentRequestDto {

    int doseNo;

    int personId;

    int doctorId;
}
