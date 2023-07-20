package com.example.VaccinationBookingSystems.dto.ResponseDto;

import com.example.VaccinationBookingSystems.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class VaccinationCenterResponseDto {
    CenterType centerType;

    String address;

    String centerName;

    String message;
}
